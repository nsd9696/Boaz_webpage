package boaz.web.proto.boaz.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Blog {
    //변수는 무조건 카멜케이스로 작성하기
    private Long id;
    private String title;
    private String author;
    private MultipartFile thumbnail; 
    private List<String> tags;
    private String ckEditor;
}
