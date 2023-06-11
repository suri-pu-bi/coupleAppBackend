package coupleApp.coupleApp.service.impl;

import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.dto.request.UserRequestDTO;
import coupleApp.coupleApp.data.dto.response.UserResponseDTO;
import coupleApp.coupleApp.repository.UserRepository;
import coupleApp.coupleApp.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO join(UserRequestDTO request) {

        Boolean isConnected = false;
        String name = request.getName();
        String nickName = request.getNickName();
        String mbti = request.getMbti();
        String code = createCode();



        User users = userRepository.findByCode(code);

        // 똑같은 코드를 가진 사용자가 없을 때까지 새로 코드만들기
        while (users != null) {
                code = createCode();
                users = userRepository.findByCode(code);

        }

        User user = new User(code, isConnected, name, nickName, mbti);
        userRepository.save(user);
        return user.toDTO();

    }

    @Override
    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id).get();
        return user.toDTO();
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {
        User user = userRepository.findById(id).get();

        user.setName(request.getName() != null ? request.getName() : user.getName());
        user.setNickname(request.getNickName() != null ? request.getNickName() : user.getNickname());
        user.setMbti(request.getMbti() != null ? request.getMbti() : user.getMbti());

        userRepository.save(user);
        return user.toDTO();
    }



    // 커플 코드 생성
    public String createCode() {
        String code = RandomStringUtils.randomAlphanumeric(5);
        return code;
    }

}
