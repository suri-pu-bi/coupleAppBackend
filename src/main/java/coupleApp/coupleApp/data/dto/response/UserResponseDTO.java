package coupleApp.coupleApp.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDTO {

    private Long userId;
    private String code;

    private Boolean isConnected;
    private String name;
    private String nickName;
    private String mbti;
}
