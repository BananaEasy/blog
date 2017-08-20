package com.blog.filter;

import com.blog.quartz.AccessRecordQuartz;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
 */
public class HtmlFilter implements Filter {

    static final Log log = LogFactory.getLog(HtmlFilter.class);

    static Map<String,String> urlrewrite ;


    private void urlrewriteRegister(){

        urlrewrite = new LinkedHashMap<String,String>();

        //搜索
        urlrewrite.put("^/s/search\\.html$","/item.action");


        //按指定条件
        //匹配按标签,类别
        urlrewrite.put("^/c/([a-zA-Z]+?)/([a-zA-Z0-9\\-]+)\\.html$","/item.action?$1=$2");

        //匹配文章显示
        //显示指定ID文章
        urlrewrite.put("^/([0-9]+)\\.html$","/article.action?id=$1");

        //匹配分页
        //对列表文章进行分页
        urlrewrite.put("^/([a-zA-Z]+)-([0-9]+)\\.html$","/$1.action?p=$2");


        //匹配留言
        urlrewrite.put("^/message/([a-zA-Z]+)\\.html$","/message/$1.action");


        //匹配所有的 /*.html
        urlrewrite.put("^/([a-zA-Z]+?)\\.html$","/$1.action");

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
