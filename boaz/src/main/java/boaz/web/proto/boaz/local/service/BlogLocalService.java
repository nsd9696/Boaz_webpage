package boaz.web.proto.boaz.local.service;

import org.springframework.beans.factory.annotation.Autowired;

import boaz.web.proto.boaz.impl.service.BlogServiceImpl;
import boaz.web.proto.boaz.local.domain.Blog;
import boaz.web.proto.boaz.local.repository.BlogJPARepository;
import java.util.List;

public class BlogLocalService implements BlogServiceImpl {

    @Autowired
    private BlogJPARepository blogJPARepository;

    public List<Blog> getBlogList() {
        List<Blog> blogList = blogJPARepository.findAll();
        return blogList;
    }


}
