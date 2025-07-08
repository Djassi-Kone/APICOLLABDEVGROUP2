package gorupe2.apicollabdevg2.repository;

import gorupe2.apicollabdevg2.entity.Contributeurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContributeursRepository extends JpaRepository<Contributeurs, Integer> {
    boolean existsContributeursByEmail(String email);
    //boolean existsContributeursByPassword(String password);
    Optional<Contributeurs> findByEmail(String email);
    //boolean existsByemail(String email);
    //boolean existsByEmail(String email);
    //boolean existByPassword(String password);
}
