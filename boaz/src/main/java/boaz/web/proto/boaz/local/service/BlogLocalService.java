package boaz.web.proto.boaz.local.service;

import boaz.web.proto.boaz.local.domain.BlogDto;
import boaz.web.proto.boaz.local.handler.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;

import boaz.web.proto.boaz.impl.service.BlogServiceImpl;
import boaz.web.proto.boaz.local.domain.Blog;
import boaz.web.proto.boaz.local.repository.BlogJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogLocalService implements BlogServiceImpl {

    @Autowired
    private BlogJPARepository blogJPARepository;
    @Autowired
    private FileHandler fileHandler;

    public Optional<Blog> getBlog(Long id){
        Optional<Blog> blog = blogJPARepository.findById(id);
        return blog;
    }

    public void insertBlog(BlogDto blogDto){
        String fileSrc =  fileHandler.saveImage("test",blogDto.getThumbnail());
        String tags = String.join(",",blogDto.getTags());
        Blog blog = Blog.builder()
                .author(blogDto.getAuthor())
                .tags(tags)
                .id(blogDto.getId())
                .ckEditor(blogDto.getCkEditor())
                .thumbnail_src(fileSrc)
                .title(blogDto.getTitle())
                .build();
        blogJPARepository.save(blog);
    }

    public void deleteBlog(Long id){
        try {
            blogJPARepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("\n >> " + e.toString() + "\n >> There isn't a blog no." + id);
        }
    }

    public void modify(BlogDto blogDto){
        String fileSrc =  fileHandler.saveImage("test",blogDto.getThumbnail());
        Blog blog = Blog.builder()
                .author(blogDto.getAuthor())
                .tags(blogDto.getTags().toString())
                .id(blogDto.getId())
                .ckEditor(blogDto.getCkEditor())
                .thumbnail_src(fileSrc)
                .title(blogDto.getTitle())
                .build();
        blogJPARepository.save(blog);
    }

    public List<Blog> getBlogList() {
        List<Blog> blogList = blogJPARepository.findAll();
        return blogList;
    }
}
