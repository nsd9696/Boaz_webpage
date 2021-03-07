package boaz.web.proto.boaz.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Portfolio {
    private String title;
    private String slideShareUrl;
    private String youtubeUrl;
    private String session;
    private String ckEditor;
    private MultipartFile file;
}