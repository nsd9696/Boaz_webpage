package boaz.web.proto.boaz.local.repository;
import boaz.web.proto.boaz.local.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogJPARepository extends JpaRepository<Blog, Long> {

}
