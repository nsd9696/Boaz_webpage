package boaz.web.proto.boaz.common;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class DatabaseSequence{
    @Id
    private String id;
    private long seq;

}
