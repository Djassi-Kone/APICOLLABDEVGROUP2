package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Gestionnaires;
import gorupe2.apicollabdevg2.entity.IdeeProjet;
import gorupe2.apicollabdevg2.repository.IdeeProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class IdeeProjetService {

    @Autowired
    private IdeeProjetRepository ideeProjetRepository;

    public IdeeProjet AjouterIdeeProjet(IdeeProjet ideeProjet) {
        return ideeProjetRepository.save(ideeProjet);
    }

    public List<IdeeProjet> ListerIdeeProjet() {
        return ideeProjetRepository.findAll();
    }

    public Optional<IdeeProjet> AfficherIdeeProjetParId(int id) {
        return ideeProjetRepository.findById(id);
    }

    public IdeeProjet ModifierIdeeProjet(int id, IdeeProjet ideeProjet) {
        ideeProjet.setId(id);
        return ideeProjetRepository.save(ideeProjet);
    }

    public void SupprimerIdeeProjet(int id) {

        ideeProjetRepository.deleteById(id);
    }
}
