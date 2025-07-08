package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.DemandeParticipation;
import gorupe2.apicollabdevg2.entity.Domaines;
import gorupe2.apicollabdevg2.repository.DomainesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DomaineService {

    @Autowired
    private DomainesRepository domainesRepository;

    public Domaines AjouterDomaines(Domaines domaines) {
        return domainesRepository.save(domaines);
    }

    public List<Domaines> ListerDomaines() {
        return domainesRepository.findAll();
    }

    public Optional<Domaines> AfficherDomainesParId(int id) {
        return domainesRepository.findById(id);
    }

    public Domaines ModifierDomaines(int id, Domaines domaines) {
        domaines.setId(id);
        return domainesRepository.save(domaines);
    }

    public void SupprimerDomaines(int id) {

        domainesRepository.deleteById(id);
    }
}
