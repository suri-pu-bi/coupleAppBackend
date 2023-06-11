package coupleApp.coupleApp.data.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CoupleResponseDTO {

    private Long coupleId;

    private Long userId;

    private Long targetId;

    private Long dDay;


}
