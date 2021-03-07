package boaz.web.proto.boaz.local.repository;

import boaz.web.proto.boaz.local.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioJPARepository extends JpaRepository<Portfolio,Long> {
}
