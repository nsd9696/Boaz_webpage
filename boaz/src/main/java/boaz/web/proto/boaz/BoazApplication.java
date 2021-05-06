package boaz.web.proto.boaz;

import boaz.web.proto.boaz.impl.service.BlogServiceImpl;
import boaz.web.proto.boaz.local.service.BlogLocalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoazApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoazApplication.class, args);
	}

	public BlogServiceImpl selectBlogService(){
		//server
		//local
		return new BlogLocalService();
	}
}
