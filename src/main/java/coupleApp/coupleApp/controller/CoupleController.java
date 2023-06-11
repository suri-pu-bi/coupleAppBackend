package coupleApp.coupleApp.controller;

import coupleApp.coupleApp.data.dto.request.CoupleReqeustDTO;
import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;
import coupleApp.coupleApp.data.dto.response.ResponseDTO;
import coupleApp.coupleApp.data.dto.response.UserMissionResponseDTO;
import coupleApp.coupleApp.service.CoupleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couple")
public class CoupleController {

    private CoupleService coupleService;

    @Autowired
    public CoupleController(CoupleService coupleService) {
        this.coupleService = coupleService;
    }


    @PostMapping("/connection")
    public ResponseEntity<ResponseDTO<CoupleResponseDTO>> coupleConnect(@RequestBody CoupleReqeustDTO request_data){
        Long uid = 1L;
        CoupleResponseDTO couple = coupleService.connect(uid, request_data);
        if (couple == null) {
            ResponseDTO<CoupleResponseDTO> response = new ResponseDTO<CoupleResponseDTO>(false, "커플 등록이 실패하였습니다..", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        ResponseDTO<CoupleResponseDTO> response = new ResponseDTO<CoupleResponseDTO>(true, "커플이 성공적으로 등록되었습니다.", couple);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<CoupleResponseDTO>> getCouple() {
        Long uid = 1L;
        CoupleResponseDTO couple = coupleService.getCouple(uid);
        ResponseDTO<CoupleResponseDTO> response = new ResponseDTO<CoupleResponseDTO>(true, "커플이 성공적으로 조회되었습니다.", couple);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Boolean>> deleteCouple(@PathVariable Long id) {
        Boolean result = coupleService.deleteCouple(id);
        ResponseDTO<Boolean> response;
        if (result) {
           response = new ResponseDTO<Boolean>(true, "커플이 성공적으로 해제되었습니다.", Boolean.TRUE);
        }

        else {
            response = new ResponseDTO<Boolean>(false, "커플 해제가 실패되었습니다.", Boolean.FALSE);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
