package boaz.web.proto.boaz.local.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@Entity
@NoArgsConstructor
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String slideShareUrl;
    private String youtubeUrl;
    private String session;
    private String ckEditor;
    private String file;

    @Builder
    public Portfolio(Long id, String title, String slideShareUrl, String youtubeUrl, String session, String ckEditor, String file) {
        this.id = id;
        this.title = title;
        this.slideShareUrl = slideShareUrl;
        this.youtubeUrl = youtubeUrl;
        this.session = session;
        this.ckEditor = ckEditor;
        this.file = file;
    }
}
