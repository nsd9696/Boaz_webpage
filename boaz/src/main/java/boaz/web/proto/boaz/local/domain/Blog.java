package boaz.web.proto.boaz.local.domain;

import java.util.List;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Blog {
    //변수는 무조건 카멜케이스로 작성하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String thumbnail_src;
    private String tags;
    private String ckEditor;

    @Builder
    public Blog(Long id, String title, String author, String thumbnail_src, String tags, String ckEditor) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.thumbnail_src = thumbnail_src;
        this.tags = tags;
        this.ckEditor = ckEditor;
    }
}
