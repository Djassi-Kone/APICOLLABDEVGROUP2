package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Admin;
import gorupe2.apicollabdevg2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private AdminService adminService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Admin AjouterAdmin(@RequestBody Admin admin) {
        return adminService.AjouterAdmin(admin);
    }

    @GetMapping
    public List<Admin> ListerAdmin() {
        return adminService.ListerAdmin();
    }

    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Admin> AfficherAdminParId(@PathVariable int id) {
        return adminService.AfficherAdminParId(id);
    }

    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Admin Modifier(@PathVariable int id, @RequestBody Admin admin) {
        return adminService.ModifierAdmin(id, admin);
    }

    /**
     * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void supprimerAdmin(@PathVariable int id) {
        adminService.SupprimerAdmin(id);
    }

}
