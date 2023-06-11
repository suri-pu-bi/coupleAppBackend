package coupleApp.coupleApp.controller;

import coupleApp.coupleApp.data.domain.User;
import coupleApp.coupleApp.data.dto.request.UserRequestDTO;
import coupleApp.coupleApp.data.dto.response.ResponseDTO;
import coupleApp.coupleApp.data.dto.response.UserResponseDTO;
import coupleApp.coupleApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO<UserResponseDTO>> signUp(@RequestBody UserRequestDTO request_data) {
        UserResponseDTO user = userService.join(request_data);
        ResponseDTO<UserResponseDTO> response = new ResponseDTO<UserResponseDTO>(true, "회원이 성공적으로 등록되었습니다.", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/code/{id}")
    public ResponseEntity<ResponseDTO<String>> getUserCode (@PathVariable Long id) {
        UserResponseDTO user = userService.getUser(id);
        String code = user.getCode();
        ResponseDTO<String> response = new ResponseDTO<String>(true, "회원의 코드가 성공적으로 조회되었습니다.", code);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserResponseDTO>> getUser(@PathVariable Long id) {
        UserResponseDTO user = userService.getUser(id);
        ResponseDTO<UserResponseDTO> response = new ResponseDTO<UserResponseDTO>(true, "회원이 성공적으로 조회되었습니다.", user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserResponseDTO>> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO request_data) {
        UserResponseDTO user = userService.updateUser(id, request_data);
        ResponseDTO<UserResponseDTO> response = new ResponseDTO<UserResponseDTO>(true, "회원이 성공적으로 업데이트되었습니다.", user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
