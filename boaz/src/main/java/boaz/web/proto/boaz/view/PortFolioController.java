package boaz.web.proto.boaz.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import boaz.web.proto.boaz.local.domain.Blog;

@Controller
@RequestMapping("/portfolio")
public class PortFolioController {

    @GetMapping("")
    public String PortfolioPage(){
        //이 부분에 Portfolio 리스트 불러오기
        return "portfolio";
    }

    //이 부분 DB활용 필요
    @GetMapping("/{id}")
    public String PortfolioDetailPage(@PathVariable String id) {
        // 해당 ID인 portfolio 불러오기
        return "portfolio_detail";
    }

    @PostMapping("/post")
    public String UploadPortfolio(@RequestBody Blog blog ){
        return "portfolio";
    }

}
