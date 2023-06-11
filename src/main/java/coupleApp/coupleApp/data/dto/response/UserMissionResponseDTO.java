package coupleApp.coupleApp.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserMissionResponseDTO {

    private Long userMissionId;
    private Long userId;
    private Long missionId;
    private Boolean isLocked;
    private Boolean isCompleted;
    private Boolean meetingStatus;
    private LocalDate date;
}
