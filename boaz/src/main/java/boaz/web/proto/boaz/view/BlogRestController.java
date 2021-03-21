package boaz.web.proto.boaz.view;

import javax.servlet.http.HttpServletRequest;

import boaz.web.proto.boaz.local.service.BlogLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import boaz.web.proto.boaz.local.domain.BlogDto;
import boaz.web.proto.boaz.local.handler.FileHandler;

@RestController
public class BlogRestController {
    
    @Autowired
    private FileHandler filehandler;

    @Autowired
    private BlogLocalService blogLocalService;

    @PostMapping("/test")
    public String testFile(BlogDto blogDto, HttpServletRequest request){
        System.out.println(blogDto.getThumbnail().getOriginalFilename());
        System.out.println(blogDto.getAuthor());
        System.out.println(blogDto.getCkEditor());
        System.out.println(blogDto.getId());
        System.out.println(blogDto.getTags());
        System.out.println(blogDto.getTitle());
        //String result = filehandler.saveImage("test",blogDto.getThumbnail());
        //System.out.println(result);
        blogLocalService.insertBlog(blogDto);
        return "good";
    }

}
