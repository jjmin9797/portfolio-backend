package port.folio.portfolio_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import port.folio.portfolio_backend.LoginService;
import port.folio.portfolio_backend.domain.login.LoginRequestDto;
import port.folio.portfolio_backend.domain.login.LoginResponseDto;
import port.folio.portfolio_backend.util.JwtTokenUtil;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        String token = loginService.login(loginRequestDto.getLoginId(), loginRequestDto.getLoginPassword());
        if (token == null) {
            LoginResponseDto loginResponseDto = new LoginResponseDto(HttpStatus.BAD_REQUEST.value(), "로그인 실패", "");
            return ResponseEntity.ok(loginResponseDto);
        }
        LoginResponseDto loginResponseDto = new LoginResponseDto(HttpStatus.OK.value(), "로그인 성공", token);
        return ResponseEntity.ok(loginResponseDto);
    }

    @GetMapping
    public String dummy() {
        loginService.createDummy();
        return "OK";
    }
}
