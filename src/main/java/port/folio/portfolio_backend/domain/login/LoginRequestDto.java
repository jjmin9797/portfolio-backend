package port.folio.portfolio_backend.domain.login;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequestDto {

    private String loginId;
    private String loginPassword;
}
