package coupleApp.coupleApp.data.domain;

import coupleApp.coupleApp.data.dto.response.CoupleResponseDTO;
import coupleApp.coupleApp.data.dto.response.UserResponseDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;


    @Column(unique = true, columnDefinition = "VARCHAR(255)", nullable = false)
    private String code;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean isConnected;

    @Column(columnDefinition = "CHAR(10)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(30)")
    private String nickname;

    @Column(columnDefinition = "CHAR(10)")
    private String mbti;


    @OneToOne(mappedBy = "user")
    private Couple couple;

    @OneToOne(mappedBy = "target")
    private Couple targetCouple;

    @Builder
    public User (String code, Boolean isConnected, String name, String nickname, String mbti) {

        this.code = code;
        this.isConnected = isConnected;
        this.name = name;
        this.nickname = nickname;
        this.mbti = mbti;
    }


    public UserResponseDTO toDTO() {
        return UserResponseDTO.builder()
                .userId(id)
                .code(code)
                .isConnected(isConnected)
                .name(name)
                .nickName(nickname)
                .mbti(mbti)
                .build();

    }
}
