package gorupe2.apicollabdevg2.service;


import gorupe2.apicollabdevg2.entity.DemandeParticipation;
import gorupe2.apicollabdevg2.repository.DemandeParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeParticipationService {

    @Autowired
    private DemandeParticipationRepository demandeParticipationRepository;


    public DemandeParticipation AjouterDemandeParticipation(DemandeParticipation demandeParticipation) {
        return demandeParticipationRepository.save(demandeParticipation);
    }


    public List<DemandeParticipation> ListerDemandeParticipation() {
        return demandeParticipationRepository.findAll();
    }


    public Optional<DemandeParticipation> AfficherDemandeParticipationParId(int id) {
        return demandeParticipationRepository.findById(id);
    }


    public DemandeParticipation ModifierDemandeParticipation(int id, DemandeParticipation demandeParticipation) {
        demandeParticipation.setId(id);
        return demandeParticipationRepository.save(demandeParticipation);
    }


    public void SupprimerDemandeParticipation(int id) {

        demandeParticipationRepository.deleteById(id);
    }
}
