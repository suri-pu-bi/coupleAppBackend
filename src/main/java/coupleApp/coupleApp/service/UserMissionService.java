package coupleApp.coupleApp.service;

import coupleApp.coupleApp.data.dto.request.UserMissionRequestDTO;
import coupleApp.coupleApp.data.dto.response.UserMissionResponseDTO;

public interface UserMissionService {

    UserMissionResponseDTO getMeetingMission(Long uid);

    UserMissionResponseDTO getNonMeetingMission(Long uid);

    UserMissionResponseDTO addMission(Long uid, UserMissionRequestDTO requestData);

    UserMissionResponseDTO getCoupleMission(Long uid);


}
