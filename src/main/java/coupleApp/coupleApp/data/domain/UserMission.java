package coupleApp.coupleApp.data.domain;

import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;
import coupleApp.coupleApp.data.dto.response.UserMissionResponseDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_mission_id", columnDefinition = "BIGINT(11)")
    private Long userMissionId;

    @Column(name = "is_locked", columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean isLocked;

    @Column(name = "is_completed",columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean isCompleted;

    @Column(name = "meeting_status",columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean meetingStatus;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name="mission_id", nullable = false)
    private Mission mission;

    @Builder
    public UserMission (User user, Mission mission, Boolean isLocked, Boolean isCompleted, Boolean meetingStatus, LocalDate date) {
        this.user = user;
        this.mission = mission;
        this.isLocked = isLocked;
        this.isCompleted = isCompleted;
        this.meetingStatus = meetingStatus;
        this.date = date;
        }



    public UserMissionResponseDTO toDTO() {
        return UserMissionResponseDTO .builder()
                .userMissionId(userMissionId)
                .userId(user.getId())
                .missionId(mission.getMissionId())
                .isLocked(isLocked)
                .isCompleted(isCompleted)
                .meetingStatus(meetingStatus)
                .date(date)
                .build();

    }

    }



