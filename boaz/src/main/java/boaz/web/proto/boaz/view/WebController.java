package boaz.web.proto.boaz.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @GetMapping("/")
    public String HomePage(){
        return "user/index";
    }

    @GetMapping("/index")
    public String IndexPage() {
        return "user/index";
    }

    @GetMapping("about")
    public String AboutPage(){
        return "user/about";
    }
    @GetMapping("service")
    public String ServicePage(){
        return "user/service";
    }

    @GetMapping("team")
    public String TeamPage(){
        return "user/team";
    }



    @GetMapping("/contact")
    public String ContactPage() {
        return "user/contact";
    }


}
