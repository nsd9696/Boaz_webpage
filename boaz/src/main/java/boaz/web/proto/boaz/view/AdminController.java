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
public class AdminController {
    @GetMapping("/admin")
    public String FormIndexPage(){
        return "admin/index";
    }

    @GetMapping("/admin/form_blog")
    public String FormBlogPage() {
        return "admin/form_blog";
    }

    @GetMapping("/admin/form_blog_mod")
    public String FormBlogModPage() {
        return "admin/form_blog_mod";
    }

    @GetMapping("/admin/blog_table")
    public String BlogTablePage(){
        return "admin/blog_table";
    }

    @GetMapping("admin/conference_table")
    public String ConferenceTablePage(){
        return "admin/conference_table";
    }

    @GetMapping("admin/form_conference")
    public String FormConferencePage(){
        return "admin/form_conference";
    }

    @GetMapping("admin/form_conference_mod")
    public String FormConferenceModPage(){
        return "admin/form_conference_mod";
    }

    @GetMapping("admin/login")
    public String GetLoginPage(){
        return "admin/login";
    }
}
