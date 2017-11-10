package xyz.lihang.blog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import xyz.lihang.blog.filter.AccessRecordFilter;
import xyz.lihang.blog.filter.HtmlFilter;
import xyz.lihang.blog.filter.ManagerFilter;

import javax.servlet.MultipartConfigElement;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootConfiguration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    //转发设置
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("forward:/index");
        registry.addViewController("/admin/").setViewName("forward:/admin/index.action");
    }

    //文件上传
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("10MB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("512KB");
        // Sets the directory location where files will be stored.
        // factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }


    //jsp视图解析
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix("");
        internalResourceViewResolver.setViewNames("*.jsp");
        internalResourceViewResolver.setOrder(1);
        return internalResourceViewResolver;
    }
    //freemarker 视图解析
    @Bean
    public ViewResolver freeMarkerViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setExposeRequestAttributes(true);
        freeMarkerViewResolver.setExposeSessionAttributes(true);
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setSuffix("");
        freeMarkerViewResolver.setViewNames("*.ftl");
        freeMarkerViewResolver.setOrder(0);
        return  freeMarkerViewResolver;
    }

    //解码
    @Bean
    public FilterRegistrationBean CharacterEncodingFilterRegistrationBean(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(characterEncodingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }

    //权限限制过滤器
    @Bean
    public FilterRegistrationBean ManagerFilterRegistrationBean(ManagerFilter managerFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(managerFilter);
        filterRegistrationBean.addUrlPatterns("/admin/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    //Html后缀  过度百度索引问题
    @Bean
    public FilterRegistrationBean HtmlFilter(HtmlFilter htmlFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(htmlFilter);
        filterRegistrationBean.addUrlPatterns("*.html");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }


    //json
    @Bean(name = "httpMessageConverter")
    public HttpMessageConverter MappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(HttpMessageConverter httpMessageConverter){
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
        requestMappingHandlerAdapter.setMessageConverters(Arrays.asList(httpMessageConverter));
        return requestMappingHandlerAdapter;
    }






}
