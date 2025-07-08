package gorupe2.apicollabdevg2.repository;

import gorupe2.apicollabdevg2.entity.Contributions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributionsRepository extends JpaRepository<Contributions, Integer> {
    Contributions save(Contributions contribution);
}
