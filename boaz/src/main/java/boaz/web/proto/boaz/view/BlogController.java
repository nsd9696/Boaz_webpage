package boaz.web.proto.boaz.view;

import boaz.web.proto.boaz.local.domain.Blog;
import boaz.web.proto.boaz.local.domain.BlogDto;


import java.util.List;
import java.util.Optional;

import boaz.web.proto.boaz.local.handler.DbHandler;
import boaz.web.proto.boaz.local.service.BlogLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogLocalService blogLocalService;
    @Autowired
    private DbHandler dbHandler;



    @GetMapping("")
        public String BlogPage(Model model) {
            List<Blog> blogList = blogLocalService.getBlogList();
            model.addAttribute(blogList);
            return "user/blog";
        }

        @GetMapping("/{idx}")
        public ModelAndView BlogPage(@PathVariable("idx") Long blogId){
            Optional<Blog> blog = blogLocalService.getBlog(blogId);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("user/blog_detail");
            mav.addObject("blog",blog.orElse(null));
        return mav;
    }

    @PostMapping("/post")
    public String BlogPostPage(BlogDto blogDto){
        try {
            System.out.println(blogDto.toString());
            String tags = String.join(" ", blogDto.getTags());
            Long id = dbHandler.generateSequence("blog");
            blogDto.setId(id);

        }catch(Exception e){
            System.out.println("falseddddddd");
        }
        blogLocalService.insertBlog(blogDto);
        return "user/blog";
    }

    @GetMapping("/modify/{idx}")
    public ModelAndView BlogModifyPage(@PathVariable("idx") Long blogId) {
        Optional<Blog> blog = blogLocalService.getBlog(blogId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/blog_detail");
        mav.addObject("blog", blog.orElse(null));
        return mav;
    }

    @PostMapping("/modify")
    public String BlogModifyPage(BlogDto blogDto){
        try {
            blogLocalService.insertBlog(blogDto);
        }catch(Exception e){
            System.out.println("falseddddddd");
        }
        return "user/blog";
    }

    @DeleteMapping("/delete/{idx}")
    public String DeleteBlogPage(@PathVariable("idx") Long blogId) {
        Optional<Blog> blog = blogLocalService.getBlog(blogId);
        if (isNull(blog)) {
            System.out.println("cannot find blog");
            return "user/blog";
        }
        blogLocalService.deleteBlog(blogId);
        return "user/blog";
    }
}
