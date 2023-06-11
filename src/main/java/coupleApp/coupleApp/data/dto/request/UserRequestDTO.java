package coupleApp.coupleApp.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {

    private String name;
    private String nickName;
    private String mbti;
}
