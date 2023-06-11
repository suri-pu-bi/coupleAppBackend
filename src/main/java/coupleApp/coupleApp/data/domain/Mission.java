package coupleApp.coupleApp.data.domain;


import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id", columnDefinition = "BIGINT(11)")
    private Long missionId;


    @Column(name = "action_data", columnDefinition = "VARCHAR(255)", nullable = false)
    private String actionData;

    @Column(name = "meeting_status",columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean meetingStatus;

    @Builder
    public Mission (String actionData, Boolean meetingStatus) {
        this.actionData = actionData;
        this.meetingStatus = meetingStatus;
    }



}
