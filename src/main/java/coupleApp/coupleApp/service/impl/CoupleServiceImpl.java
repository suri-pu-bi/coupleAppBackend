package coupleApp.coupleApp.service.impl;

import coupleApp.coupleApp.data.domain.Couple;
import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.dto.request.CoupleReqeustDTO;
import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;
import coupleApp.coupleApp.repository.CoupleRepository;
import coupleApp.coupleApp.repository.UserRepository;
import coupleApp.coupleApp.service.CoupleService;
import coupleApp.coupleApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CoupleServiceImpl implements CoupleService {

    private final CoupleRepository coupleRepository;
    private final UserRepository userRepository;


    public CoupleServiceImpl(CoupleRepository coupleRepository, UserRepository userRepository) {
        this.coupleRepository = coupleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CoupleResponseDTO connect(Long uid, CoupleReqeustDTO request) {

        Long dDay = null;
        try {
            dDay = dDayCalculate(request.getStartAt());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        User userTarget = userRepository.findByCode(request.getCode());
        User user = userRepository.findById(uid).get();


        if (userTarget != null && user != userTarget && user.getCouple() == null && userTarget.getCouple() == null) {
            if (userTarget.getCouple() == null) {
                Couple couple = new Couple(user, userTarget, dDay);
                coupleRepository.save(couple);
                user.setIsConnected(true);
                userTarget.setIsConnected(true);
                userRepository.save(user);
                userRepository.save(userTarget);

                return couple.toDTO();
            }
        }


        return null;



    }

    @Override
    public CoupleResponseDTO getCouple(Long uid) {
        User user = userRepository.findById(uid).get();
        Couple couple = user.getCouple();
        return couple.toDTO();
    }

    @Override
    public Boolean deleteCouple(Long id) {
        try {
            coupleRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


    // 디데이 계산
    public Long dDayCalculate(String date) throws ParseException {
        Date today = new Date(); // 현재 날짜
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startAtDate = dateFormat.parse(date);
        Long timeDiff = today.getTime() - startAtDate.getTime(); // 시작 날짜와 현재 날짜의 차이 계산 (밀리초 단위)
        Long dayDiff = timeDiff / (24 * 60 * 60 * 1000) + 1 ; // 일 단위로 변환

        return dayDiff;
    }
}
