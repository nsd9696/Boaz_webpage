package boaz.web.proto.boaz.local.repository;

import boaz.web.proto.boaz.common.DatabaseSequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSequenceJPAReposirory extends JpaRepository<DatabaseSequence,String> {

}
