package boaz.web.proto.boaz.local.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
public class BlogDto {
    //변수는 무조건 카멜케이스로 작성하기
    private Long id;
    private String title;
    private String author;
    private MultipartFile thumbnail;
    private List<String> tags; // , 연결해서 진행
    private String ckEditor;

    @Builder
    public BlogDto(Long id, String title, String author, MultipartFile thumbnail, List<String> tags, String ckEditor) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.thumbnail = thumbnail;
        this.tags = tags;
        this.ckEditor = ckEditor;
    }
}
