package coupleApp.coupleApp.repository;

import coupleApp.coupleApp.data.domain.Couple;
import coupleApp.coupleApp.data.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {
}
