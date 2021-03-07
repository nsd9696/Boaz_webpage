package boaz.web.proto.boaz.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String HomePage(){
        return "index";
    }

    @GetMapping("/index")
    public String IndexPage() {
        return "index";
    }

    @GetMapping("about")
    public String AboutPage(){
        return "about";
    }
    @GetMapping("service")
    public String ServicePage(){
        return "service";
    }

    @GetMapping("team")
    public String TeamPage(){
        return "team";
    }
}
