package gorupe2.apicollabdevg2.service;


import gorupe2.apicollabdevg2.entity.Projet;
import gorupe2.apicollabdevg2.repository.ProjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetsService {

    @Autowired
    private ProjetsRepository projetsRepository;

    public Projet AjouterProjet(Projet projets) {
        return projetsRepository.save(projets);
    }

    public List<Projet> ListerProjet() {
        return projetsRepository.findAll();
    }

    public Optional<Projet> AfficherProjetParId(int id) {
        return projetsRepository.findById(id);
    }

    public Projet ModifierProjet(int id, Projet projets) {
        projets.setId(id);
        return projetsRepository.save(projets);
    }

    public void SupprimerProjet(int id) {

        projetsRepository.deleteById(id);
    }
}
