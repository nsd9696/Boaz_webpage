package boaz.web.proto.boaz.view;

import boaz.web.proto.boaz.domain.Conference;
import boaz.web.proto.boaz.service.ConferenceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 12기 남궁찬
 */
@Controller
@RequestMapping("/conference")
public class ConferenceController {
    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("")
    public String ConferencePage(){
        return "portfolio";
    }

    @GetMapping("/{id}")
    public String PortfolioDetailPage(@PathVariable String id) {
        return "portfolio_detail";
    }

    @PostMapping("/post")
    public String UploadPortfolio(@RequestBody Conference conference){
        return "portfolio";
    }

}
