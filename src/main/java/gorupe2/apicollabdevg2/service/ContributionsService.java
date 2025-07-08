package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Coins;
import gorupe2.apicollabdevg2.entity.Commentaires;
import gorupe2.apicollabdevg2.entity.Contributions;
import gorupe2.apicollabdevg2.repository.ContributionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ContributionsService {

    @Autowired
    private ContributionsRepository contributionsRepository;

    public Contributions AjouterContributions(Contributions contributions) {
        return contributionsRepository.save(contributions);
    }

    public List<Contributions> ListerContributions() {
        return contributionsRepository.findAll();
    }

    public Optional<Contributions> AfficherContributionsParId(int id) {
        return contributionsRepository.findById(id);
    }

    public Contributions ModifierContributions(int id, Contributions contributions) {
        contributions.setId_contribution(id);
        return contributionsRepository.save(contributions);
    }

    public void SupprimerContributions(int id) {

        contributionsRepository.deleteById(id);
    }


}
