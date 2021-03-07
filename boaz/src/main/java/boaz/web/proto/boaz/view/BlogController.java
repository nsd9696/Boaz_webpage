package boaz.web.proto.boaz.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    
    @GetMapping("/")
    public String BlogPage(){
        //blog 리스트 만들기
        return "blog";
    }

    @GetMapping("/{id}")
    public String BlogDetailPage(@PathVariable String id){
        //해당 ID인 blog 데이터 불러오기
        return "blog_detail";
    }
}
