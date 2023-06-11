package coupleApp.coupleApp.service.impl;

import coupleApp.coupleApp.data.domain.Mission;
import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.domain.UserMission;
import coupleApp.coupleApp.data.dto.request.UserMissionRequestDTO;
import coupleApp.coupleApp.data.dto.response.UserMissionResponseDTO;
import coupleApp.coupleApp.repository.MissionRepository;
import coupleApp.coupleApp.repository.UserMissionRepository;
import coupleApp.coupleApp.repository.UserRepository;
import coupleApp.coupleApp.service.UserMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class UserMissionServiceImpl implements UserMissionService {

    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    private final MissionRepository missionRepository;


    public UserMissionServiceImpl(UserMissionRepository userMissionRepository, UserRepository userRepository, MissionRepository missionRepository) {
        this.userMissionRepository = userMissionRepository;
        this.userRepository = userRepository;
        this.missionRepository = missionRepository;
    }


    @Override
    public UserMissionResponseDTO getMeetingMission(Long uid) {

        User user = userRepository.findById(uid).get();
        // 오늘 날짜인 미션 가져오기 위해
        LocalDate today = LocalDate.now();
        Boolean meetingStatus = true;
        UserMission userMission = userMissionRepository.findByUserAndDateAndMeetingStatus(user,today, meetingStatus);
//        userMission.getMission().getActionData();
        return userMission.toDTO();
    }

    @Override
    public UserMissionResponseDTO getNonMeetingMission(Long uid) {
        LocalDate today = LocalDate.now();
        User user = userRepository.findById(uid).get();
        Boolean meetingStatus = false;
        UserMission userMission = userMissionRepository.findByUserAndDateAndMeetingStatus(user,today, meetingStatus);
        return userMission.toDTO();
    }

    @Override
    public UserMissionResponseDTO addMission(Long uid, UserMissionRequestDTO requestData) {
        LocalDate today = LocalDate.now();
        User user = userRepository.findById(uid).get();
        Mission mission = getRandomMission(requestData.getMeetingStatus());

        UserMission existingUserMission = userMissionRepository.findByUserAndDate(user, today);
        if (existingUserMission != null) {
            // 이미 오늘 날짜에 미션을 가지고 있는 경우
            return existingUserMission.toDTO();
        }

        UserMission userMission = new UserMission(user, mission, false, false, mission.getMeetingStatus(), today);
        userMissionRepository.save(userMission);
        return userMission.toDTO();

    }


    public void updateLockedMissionAfterOneMinute(Long uid) {
        try {
            Thread.sleep(60000); // 1분 동안 스레드 일시 정지
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // 예외 처리
        }

        User user = userRepository.findById(uid).get();
        UserMission userMission = userMissionRepository.findByUser(user);

        if (userMission.getIsLocked()) {
            userMission.setIsLocked(false);
            userMissionRepository.save(userMission);
        }

        // 1분 후에 isLocked 값을 변경하는 로직 구현
    }








    @Override
    public UserMissionResponseDTO getCoupleMission(Long uid) {
        User user = userRepository.findById(uid).get();
        User couple = user.getCouple().getTarget();
        System.out.println(couple);

        UserMission userMission = userMissionRepository.findByUser(couple);

        if (userMission.getIsLocked() == false) {
            return userMission.toDTO();
        }


        return null;



    }

    public Mission getRandomMission(Boolean meetingStatus) {

        long missionCount = missionRepository.countByMeetingStatus(meetingStatus);
        Random random = new Random();
        int randomIndex = random.nextInt((int) missionCount);
        List<Mission> missions = missionRepository.findByMeetingStatus(meetingStatus);
        Mission randomMission = missions.get(randomIndex);
        return randomMission;

    }
}
