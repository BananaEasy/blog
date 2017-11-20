package xyz.lihang.blog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement    //事务
@EnableCaching //缓存
public class BlogApplication extends SpringBootServletInitializer {

	//生成web需要继承SpringBootServletInitializer
	//才能发布到web容器
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(BlogApplication.class);
	}

//
//	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(BlogApplication.class);
//		springApplication.run(args);
//	}
}
