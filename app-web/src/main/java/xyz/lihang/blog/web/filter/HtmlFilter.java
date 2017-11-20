package xyz.lihang.blog.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xyz.lihang.blog.quartz.quartz.AccessRecordQuartz;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiHang on 2017/8/6.
 * 为了过度百度建立索引的问题
 */
@Component
public class HtmlFilter implements Filter {

    static final Logger log = LoggerFactory.getLogger(HtmlFilter.class);

    static Map<String,String> urlrewrite ;


    private void urlrewriteRegister(){
        urlrewrite = new LinkedHashMap<>();
        ///c/cid/8.html
        urlrewrite.put("^/c/cid/([0-9]+)\\.html$","/category/$1");
        //匹配文章显示
        //显示指定ID文章
        urlrewrite.put("^/([0-9]+)\\.html$","/article/$1");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //url转发规则
        urlrewriteRegister ();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        //获取path
        String fromUrl = req.getRequestURI();
        String toUrl = "index.action";

        for(Map.Entry<String,String> set :urlrewrite.entrySet()){
            String furl = set.getKey();
            Pattern p = Pattern.compile(furl);
            Matcher m = p.matcher(fromUrl);
            boolean b = m.matches();
            if(true == b){
                String turl = set.getValue();
                toUrl = fromUrl.replaceAll(furl,turl);
                log.info( "requestURI:"+fromUrl + "----------"  + "forwardURL :" + toUrl);
                //转发到指定页面
                req.getRequestDispatcher(toUrl).forward(req, resp);
                //处理连接情况
                AccessRecordQuartz.createAccessRecord(req);
                return;
            }
        }

        if(fromUrl.lastIndexOf("/") ==  fromUrl.length()-1){
            req.getRequestDispatcher(fromUrl + "index.action").forward(req, resp);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }


    @Override
    public void destroy() {

    }
}
