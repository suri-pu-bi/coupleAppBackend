package coupleApp.coupleApp.service;


import coupleApp.coupleApp.data.dto.request.CoupleReqeustDTO;
import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;

public interface CoupleService {

    CoupleResponseDTO connect(Long uid, CoupleReqeustDTO request);

    CoupleResponseDTO getCouple(Long uid);

    Boolean deleteCouple(Long id);
}
