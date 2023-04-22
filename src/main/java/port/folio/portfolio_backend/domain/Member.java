package port.folio.portfolio_backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "member")
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_login_id")
    private String loginId;

    @Column(name = "member_login_password")
    private String loginPassword;
}
