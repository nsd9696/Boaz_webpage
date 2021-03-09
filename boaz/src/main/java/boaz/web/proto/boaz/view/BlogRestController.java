package boaz.web.proto.boaz.view;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/test")
    public String testFile(BlogDto blogDto, HttpServletRequest request){
        System.out.println(blogDto.getThumbnail().getOriginalFilename());
        String result = filehandler.saveImage("test",blogDto.getThumbnail());
        System.out.println(result);
        return "good";
    }    
}
