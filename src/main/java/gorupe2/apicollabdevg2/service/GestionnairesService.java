package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Fonctionnalites;
import gorupe2.apicollabdevg2.entity.Gestionnaires;
import gorupe2.apicollabdevg2.repository.GestionnairesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class GestionnairesService {

    @Autowired
    private GestionnairesRepository gestionnairesRepository;

    public Gestionnaires AjouterGestionnaires(Gestionnaires gestionnaires) {
        return gestionnairesRepository.save(gestionnaires);
    }

    public List<Gestionnaires> ListerGestionnaires() {
        return gestionnairesRepository.findAll();
    }

    public Optional<Gestionnaires> AfficherGestionnairesParId(int id) {
        return gestionnairesRepository.findById(id);
    }

    public Gestionnaires ModifierGestionnaires(int id, Gestionnaires gestionnaires) {
        gestionnaires.setId(id);
        return gestionnairesRepository.save(gestionnaires);
    }

    public void SupprimerGestionnaires(int id) {

        gestionnairesRepository.deleteById(id);
    }
}
