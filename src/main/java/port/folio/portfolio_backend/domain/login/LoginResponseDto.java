package port.folio.portfolio_backend.domain.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class LoginResponseDto {

    private int status;
    private String message;
    private String token;
}
