package coupleApp.coupleApp.repository;

import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCode(String code);

}
