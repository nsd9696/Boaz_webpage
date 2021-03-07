package boaz.web.proto.boaz.local.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class Portfolio {
    private String title;
    private String slideShareUrl;
    private String youtubeUrl;
    private String session;
    private String ckEditor;
    private String file;

    @Builder
    public Portfolio(String title, String slideShareUrl, String youtubeUrl, String session, String ckEditor, String file) {
        this.title = title;
        this.slideShareUrl = slideShareUrl;
        this.youtubeUrl = youtubeUrl;
        this.session = session;
        this.ckEditor = ckEditor;
        this.file = file;
    }
}
