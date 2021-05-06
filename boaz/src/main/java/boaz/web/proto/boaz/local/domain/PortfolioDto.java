package boaz.web.proto.boaz.local.domain;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PortfolioDto {
    private Long id;
    private String title;
    private String slideShareUrl;
    private String youtubeUrl;
    private String session;
    private String ckEditor;
    private MultipartFile file;

    @Builder
    public PortfolioDto(Long id, String title, String slideShareUrl, String youtubeUrl, String session, String ckEditor, MultipartFile file) {
        this.id = id;
        this.title = title;
        this.slideShareUrl = slideShareUrl;
        this.youtubeUrl = youtubeUrl;
        this.session = session;
        this.ckEditor = ckEditor;
        this.file = file;
    }
}
