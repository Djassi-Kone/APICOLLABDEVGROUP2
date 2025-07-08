package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Coins;
import gorupe2.apicollabdevg2.entity.Contributeurs;
import gorupe2.apicollabdevg2.repository.CoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CoinsService {

    @Autowired
    private CoinsRepository coinsRepository;

    public Coins AjouterCoins(Coins coins) {
        return coinsRepository.save(coins);
    }

    public List<Coins> ListerCoins() {
        return coinsRepository.findAll();
    }

    public Optional<Coins> AfficherCoinsParId(int id) {
        return coinsRepository.findById(id);
    }

    public Coins ModifierCoins(int id, Coins coins) {
        coins.setId(id);
        return coinsRepository.save(coins);
    }


    public void SupprimerCoins(int id) {

        coinsRepository.deleteById(id);
    }



}
