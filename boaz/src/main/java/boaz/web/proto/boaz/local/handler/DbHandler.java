package boaz.web.proto.boaz.local.handler;


import boaz.web.proto.boaz.common.DatabaseSequence;
import boaz.web.proto.boaz.local.repository.DataSequenceJPAReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DbHandler {

    @Autowired
    private DataSequenceJPAReposirory dataSequenceJPARepository;


    //데이터 번호 생성
    public long generateSequence(String seqName) {
    Optional<DatabaseSequence> dbseq = dataSequenceJPARepository.findById(seqName);

    return dbseq.get().getSeq();
    }
}
