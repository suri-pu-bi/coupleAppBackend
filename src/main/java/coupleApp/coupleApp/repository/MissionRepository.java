package coupleApp.coupleApp.repository;

import coupleApp.coupleApp.data.domain.Mission;
import coupleApp.coupleApp.data.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findByMeetingStatus (Boolean meetingStatus);

    long countByMeetingStatus (Boolean meetingStatus);
}
