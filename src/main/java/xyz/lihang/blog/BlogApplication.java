package xyz.lihang.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import xyz.lihang.blog.config.ApplicationConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


@SpringBootApplication
@AutoConfigureAfter(ApplicationConfig.class) //提前读取该配置 再扫描mapperscan
@MapperScan("xyz.lihang.blog.mvc.dao")
@EnableScheduling //定时任务
@EnableTransactionManagement    //事务
public class BlogApplication extends SpringBootServletInitializer {


	//生成web需要继承SpringBootServletInitializer
	//才能发布到web容器
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(BlogApplication.class);
	}



	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BlogApplication.class);
		springApplication.run(args);
	}
}
