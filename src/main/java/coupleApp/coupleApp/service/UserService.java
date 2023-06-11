package coupleApp.coupleApp.service;

import coupleApp.coupleApp.data.dto.request.UserRequestDTO;
import coupleApp.coupleApp.data.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO join(UserRequestDTO request);
    UserResponseDTO getUser(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO request);
}
