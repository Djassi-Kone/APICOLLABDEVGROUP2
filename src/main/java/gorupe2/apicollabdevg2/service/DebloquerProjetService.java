package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.DebloquerProjet;
import gorupe2.apicollabdevg2.repository.DebloquerProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DebloquerProjetService {

    @Autowired
    private DebloquerProjetRepository debloquerProjetRepository;

    public DebloquerProjet AjouterDebloquerProjet(DebloquerProjet debloquerProjet) {
        return debloquerProjetRepository.save(debloquerProjet);
    }

    public List<DebloquerProjet> ListerDebloquerProjet() {
        return debloquerProjetRepository.findAll();
    }

    public Optional<DebloquerProjet> AfficherDebloquerProjetParId(int id) {
        return debloquerProjetRepository.findById(id);
    }

    public DebloquerProjet ModifierDebloquerProjet(int id, DebloquerProjet debloquerProjet) {
        debloquerProjet.setId(id);
        return debloquerProjetRepository.save(debloquerProjet);
    }

    public void SupprimerDebloquerProjet(int id) {
        debloquerProjetRepository.deleteById(id);
    }
}
