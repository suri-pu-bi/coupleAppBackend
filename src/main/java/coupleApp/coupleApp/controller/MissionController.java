package coupleApp.coupleApp.controller;


import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.dto.request.UserMissionRequestDTO;
import coupleApp.coupleApp.data.dto.response.ResponseDTO;
import coupleApp.coupleApp.data.dto.response.UserMissionResponseDTO;
import coupleApp.coupleApp.service.UserMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private UserMissionService userMissionService;

    @Autowired
    public MissionController(UserMissionService userMissionService) {
        this.userMissionService = userMissionService;
    }


    @PostMapping
    public ResponseEntity<ResponseDTO<UserMissionResponseDTO>> addMission(@RequestBody UserMissionRequestDTO requestData) {
        Long uid = 1L;
        UserMissionResponseDTO mission = userMissionService.addMission(uid, requestData);
        ResponseDTO<UserMissionResponseDTO> response = new ResponseDTO<UserMissionResponseDTO>(true, "미션이 성공적으로 등록되었습닌다.", mission);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/meeting")
    public ResponseEntity<ResponseDTO<UserMissionResponseDTO>> getMeetingMission() {
        Long uid = 1L;
        UserMissionResponseDTO meetingMission = userMissionService.getMeetingMission(uid);
        ResponseDTO<UserMissionResponseDTO> response = new ResponseDTO<UserMissionResponseDTO>(true, "만나는 날 미션을 성공적으로 조회했습니다.", meetingMission);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/non-meeting")
    public ResponseEntity<ResponseDTO<UserMissionResponseDTO>> getNonMeetingMission() {
        Long uid = 2L;
        UserMissionResponseDTO nonMeetingMission = userMissionService.getNonMeetingMission(uid);
        ResponseDTO<UserMissionResponseDTO> response = new ResponseDTO<UserMissionResponseDTO>(true, "안 만나는 날 미션을 성공적으로 조회했습니다.", nonMeetingMission);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/couple")
    public ResponseEntity<ResponseDTO<UserMissionResponseDTO>> getCoupleMission() {
        Long uid = 1L;
        UserMissionResponseDTO coupleMission = userMissionService.getCoupleMission(uid);
        if (coupleMission == null) {
            return ResponseEntity.notFound().build();
        }

        ResponseDTO<UserMissionResponseDTO> response = new ResponseDTO<UserMissionResponseDTO>(true, "상대방 커플 미션을 성공적으로 조회했습니다.", coupleMission);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
