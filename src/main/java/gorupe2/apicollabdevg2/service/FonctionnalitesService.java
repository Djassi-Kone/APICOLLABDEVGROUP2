package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Domaines;
import gorupe2.apicollabdevg2.entity.Fonctionnalites;
import gorupe2.apicollabdevg2.repository.FonctionnalitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FonctionnalitesService {

    @Autowired
    private FonctionnalitesRepository fonctionnalitesRepository;

    public Fonctionnalites AjouterFonctionnalites(Fonctionnalites fonctionnalites) {
        return fonctionnalitesRepository.save(fonctionnalites);
    }

    public List<Fonctionnalites> ListerFonctionnalites() {
        return fonctionnalitesRepository.findAll();
    }

    public Optional<Fonctionnalites> AfficherFonctionnalitesParId(int id) {
        return fonctionnalitesRepository.findById(id);
    }

    public Fonctionnalites ModifierFonctionnalites(int id, Fonctionnalites fonctionnalites) {
        fonctionnalites.setId(id);
        return fonctionnalitesRepository.save(fonctionnalites);
    }

    public void SupprimerFonctionnalites(int id) {

        fonctionnalitesRepository.deleteById(id);
    }
}
