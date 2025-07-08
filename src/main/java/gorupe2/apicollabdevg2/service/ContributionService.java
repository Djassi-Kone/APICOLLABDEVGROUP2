package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Contributions;

import java.util.List;

public interface ContributionService {
    Contributions createContribution(Contributions contributions);
    List<Contributions> getAllContributions();
    Contributions getById(Long id);
    void deleteById(Long id);
}
