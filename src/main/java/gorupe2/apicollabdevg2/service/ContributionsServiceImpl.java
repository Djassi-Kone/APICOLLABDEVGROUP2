package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Contributions;
import gorupe2.apicollabdevg2.repository.ContributionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributionsServiceImpl implements ContributionService{

    private ContributionsRepository contributionsRepository;

    @Override
    public Contributions createContribution(Contributions contributions) {
        return contributionsRepository.save(contributions);
    }

    @Override
    public List<Contributions> getAllContributions() {
        return contributionsRepository.findAll();
    }

    @Override
    public Contributions getById(Long id) {
        return contributionsRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Contribution non trouvée"));
    }

    @Override
    public void deleteById(Long id) {
        contributionsRepository.deleteById(Math.toIntExact(id));
    }

}
