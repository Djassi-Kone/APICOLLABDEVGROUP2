package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Coins;
import gorupe2.apicollabdevg2.entity.Commentaires;
import gorupe2.apicollabdevg2.entity.Contributeurs;
import gorupe2.apicollabdevg2.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CommentairesService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public Commentaires AjouterCommentaires(Commentaires commentaires) {
        return commentaireRepository.save(commentaires);
    }

    public List<Commentaires> ListerCommentaires() {
        return commentaireRepository.findAll();
    }

    public Optional<Commentaires> AfficherCommentairesParId(int id) {
        return commentaireRepository.findById(id);
    }

    public Commentaires ModifierCommentaire(int id, Commentaires commentaires) {
        commentaires.setId(id);
        return commentaireRepository.save(commentaires);
    }

    public void SupprimerCommentaires(int id) {
        commentaireRepository.deleteById(id);
    }
}
