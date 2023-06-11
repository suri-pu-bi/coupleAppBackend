package coupleApp.coupleApp.repository;

import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    UserMission findByUserAndDateAndMeetingStatus (User user, LocalDate date, Boolean meetingStatus);

    UserMission findByUser (User user);

    UserMission findByUserAndDate (User user, LocalDate date);
}
