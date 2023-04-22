package port.folio.portfolio_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import port.folio.portfolio_backend.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByLoginId(String loginId);
}
