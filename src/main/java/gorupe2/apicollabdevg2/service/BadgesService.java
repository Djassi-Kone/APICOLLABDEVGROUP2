package gorupe2.apicollabdevg2.service;


import gorupe2.apicollabdevg2.entity.Badges;
import gorupe2.apicollabdevg2.repository.BadgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadgesService {

    @Autowired
    private BadgesRepository badgesRepository;

    public Badges AjouterBadges(Badges badges) {
        return badgesRepository.save(badges);
    }

    public List<Badges> ListerBadges() {
        return badgesRepository.findAll();
    }

    public Optional<Badges> AfficherBadgesParId(int id) {
        return badgesRepository.findById(id);
    }

    public Badges ModifierBadges(int id, Badges badges) {
        badges.setId(id);
        return badgesRepository.save(badges);
    }

    public void SupprimerBadges(int id) {
        badgesRepository.deleteById(id);
    }

}



