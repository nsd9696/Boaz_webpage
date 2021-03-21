package boaz.web.proto.boaz.view;

import boaz.web.proto.boaz.local.domain.Blog;
import boaz.web.proto.boaz.local.domain.BlogDto;
import boaz.web.proto.boaz.local.service.BlogLocalService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogLocalService blogLocalService;

    @GetMapping("")
    public String BlogPage(Model model) {
        List<Blog> blogList = blogLocalService.getBlogList();
        model.addAttribute(blogList);

        return "blog";
    }

    @GetMapping("/{idx}")
    public ModelAndView BlogPage(@PathVariable("idx") Long blogId){
        Optional<Blog> blog = blogLocalService.getBlog(blogId);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("blog_detail");
        mav.addObject("blog",blog.orElse(null));

        return mav;
    }

    @PostMapping("/post")
    public String BlogPostPage(BlogDto blogDto){
        try {
            System.out.println(blogDto.toString());
            String tags = String.join(" ", blogDto.getTags());
            //file 저장하기
            Blog blog = Blog.builder()
                    .author(blogDto.getAuthor())
                    .ckEditor(blogDto.getCkEditor())
                    .id(1L)
                    .tags(tags)
                    .thumbnail_src("")
                    .title(blogDto.getTitle())
                    .build() ;
        }catch(Exception e){
            System.out.println("falseddddddd");
        }
        return "blog";
    }
}
