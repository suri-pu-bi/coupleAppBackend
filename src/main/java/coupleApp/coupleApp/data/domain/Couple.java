package coupleApp.coupleApp.data.domain;

import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Couple {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couple_id", columnDefinition = "BIGINT(11)")
    private Long coupleId;


    @Column(name = "d_day", columnDefinition = "VARCHAR(30)", nullable = false)
    private Long dDay;



    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "target_id", nullable = false)
    private User target;


    @Builder
    public Couple (User user, User target, Long dDay) {
        this.user = user;
        this.target = target;
        this.dDay = dDay;

    }

//   양방향 참조관계를 해야 유저에서 getCouple을 할 수 있음


    public CoupleResponseDTO toDTO() {
        return CoupleResponseDTO.builder()
                .coupleId(coupleId)
                .userId(user.getId())
                .targetId(target.getId())
                .dDay(dDay)
                .build();

    }





}
