package port.folio.portfolio_backend;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import port.folio.portfolio_backend.domain.Member;
import port.folio.portfolio_backend.repository.MemberRepository;
import port.folio.portfolio_backend.util.JwtTokenUtil;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String login(String loginId, String loginPassword) {
        try {
            Member loginMember = memberRepository.findByLoginId(loginId);
            if (passwordEncoder.matches(loginPassword, loginMember.getLoginPassword())) {
                System.out.println(JwtTokenUtil.generateToken(loginMember.getLoginId()));
                return JwtTokenUtil.generateToken(loginMember.getLoginId());
            }
            return null;
        }catch (Exception e) {
            return null;
        }
    }
    @Transactional
    public void createDummy() {
        Member member = new Member();
        member.setLoginId("jjmin9797");
        member.setLoginPassword(passwordEncoder.encode("1234"));
        member.setMemberName("JM");
        memberRepository.save(member);
    }
}
