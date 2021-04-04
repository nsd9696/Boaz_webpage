package boaz.web.proto.boaz.view;

import boaz.web.proto.boaz.local.domain.Blog;
import boaz.web.proto.boaz.local.handler.DbHandler;
import boaz.web.proto.boaz.local.service.BlogLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BlogLocalService blogLocalService;
    @Autowired
    private DbHandler dbHandler;

    @GetMapping("/")
    public String FormIndexPage(){
        return "admin/index";
    }

    @GetMapping("form_blog")
    public String FormBlogPage() {
        return "admin/form_blog";
    }

    @GetMapping("form_blog_mod")
    public String FormBlogModPage() {
        return "admin/form_blog_mod";
    }

    @GetMapping("blog_table")
    public String BlogTablePage(){
        return "admin/blog_table";
    }

    @GetMapping("conference_table")
    public String ConferenceTablePage(){
        return "admin/conference_table";
    }

    @GetMapping("form_conference")
    public String FormConferencePage(){
        return "admin/form_conference";
    }

    @GetMapping("form_conference_mod")
    public String FormConferenceModPage(){
        return "admin/form_conference_mod";
    }

    @GetMapping("login")
    public String GetLoginPage(){
        return "admin/login";
    }
}
