package coupleApp.coupleApp.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissionRequestDTO {

    private Long missionId;
    private Boolean isLocked;
    private Boolean isCompleted;
    private Boolean meetingStatus;

    private Date date;
}
