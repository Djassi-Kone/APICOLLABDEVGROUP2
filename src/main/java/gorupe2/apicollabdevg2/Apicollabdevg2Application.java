package gorupe2.apicollabdevg2;


import gorupe2.apicollabdevg2.entity.Admin;
import gorupe2.apicollabdevg2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired; // Pour l'injection des dépendances
import org.springframework.boot.CommandLineRunner; // Interface qui permet d'exécuter du code au démarrage
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder; // Pour encoder le mot de passe
import org.springframework.stereotype.Component; // Pour que Spring détecte cette classe comme un composant

import java.util.Optional;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class Apicollabdevg2Application {

	public static void main(String[] args) {
		SpringApplication.run(Apicollabdevg2Application.class, args);
	}

}


// Classe qui s'exécute automatiquement au lancement de l'application
@Component // Permet à Spring de gérer cette classe et d'injecter les dépendances
class AdminInitializer implements CommandLineRunner {

	@Autowired // Injection automatique du repository Admin
	private AdminRepository adminRepository;

	@Autowired // Injection automatique du password encoder
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// Définition des informations de l'admin par défaut
		String emailAdmin = "admin1234@gmail.com";
		String password = "admin1234";

		// Recherche si un admin avec cet email existe déjà
		Optional<Admin> adminOpt = adminRepository.findByEmail(emailAdmin);

		// Si l'admin n'existe pas, on le crée
		if (adminOpt.isEmpty()) {
			Admin admin = new Admin();
			admin.setEmail(emailAdmin); // Correction : on utilise la variable et non un texte fixe
			admin.setPassword(passwordEncoder.encode(password)); // On encode le mot de passe avant de le sauvegarder

			adminRepository.save(admin); // Sauvegarde de l'admin dans la base de données
			System.out.println("L'Admin par défaut créé avec succès.");
		} else {
			// Si l'admin existe déjà
			Admin adminExist = adminOpt.get();
			System.out.println("Admin existe déjà.");
			System.out.println("Veillez vous connecter !");

			// Vérification du mot de passe : si le mot de passe par défaut correspond au mot de passe en base lors de la connexion
			if (passwordEncoder.matches(password, adminExist.getPassword())) {
				System.out.println("Admin connecté avec succès !");
				System.out.println("Votre email est : " + adminExist.getEmail() + "  " + "et votre mot de passe est :" + passwordEncoder.encode(password));
			} else {
				System.out.println("Mot de passe ou Email incorrect, veillez vérifier puis réessayer !");
			}
		}
	}
}
