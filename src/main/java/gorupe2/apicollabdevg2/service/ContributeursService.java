package gorupe2.apicollabdevg2.service;


import gorupe2.apicollabdevg2.DTO.ContributeursDTO;
import gorupe2.apicollabdevg2.entity.Contributeurs;
import gorupe2.apicollabdevg2.repository.ContributeursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ContributeursService {


    @Autowired
    private ContributeursRepository contributeursRepository;

    public Contributeurs AjouterContributeur(Contributeurs contributeurs) {
        return contributeursRepository.save(contributeurs);
    }

    public List<Contributeurs> ListerContributeurs() {
        return contributeursRepository.findAll();
    }

    public Optional<Contributeurs> AfficherContributeurParId(int id) {
        return contributeursRepository.findById(id);
    }

    public Contributeurs ModifierContributeur(int id, Contributeurs contributeurs) {
        contributeurs.setId(id);
        return contributeursRepository.save(contributeurs);
    }

    public void SupprimerContributeur(int id) {

        contributeursRepository.deleteById(id);
    }


    public ContributeursDTO convertirEnDTO(Contributeurs contributeurs) {

        ContributeursDTO contributeurDTO = new ContributeursDTO();

        return new ContributeursDTO(
                contributeurDTO.getId(),
                contributeurDTO.getNom(),
                contributeurDTO.getPrenom(),
                contributeurDTO.getEmail(),
                contributeurDTO.getPassword(),
                contributeurDTO.getProfil(),
                contributeurDTO.getNiveau()

        );
    }
    public Contributeurs convertirEnEntite(ContributeursDTO dto){
        Contributeurs contributeurs = new Contributeurs();
        contributeurs.setId(dto.getId());
        contributeurs.setNom(dto.getNom());
        contributeurs.setEmail(dto.getEmail());
        contributeurs.setProfil(dto.getProfil());
        contributeurs.setNiveau(dto.getNiveau());
        return contributeurs;
    }
}

