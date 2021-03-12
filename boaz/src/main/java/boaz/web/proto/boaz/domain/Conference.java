package boaz.web.proto.boaz.domain;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

import java.net.URL;

/**
 * @author 12기 남궁찬
 */
@Data
@AllArgsConstructor
public class Conference {
    private final long id;
    private final String title;
    private final URL slideShareUrl;
    private final URL youtubeUrl;
    private final BoazSession session;
    private final String content; // ckEditor 와 동일한 것 같음
    private final MultipartFile file;
}