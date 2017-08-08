package com.blog.filter;

import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.utils.UUIDUtils;
import com.blog.thread.ThreadAccessRecord;
import com.blog.tool.ToolWeb;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
public class HtmlServlet extends HttpServlet {

    static final Log log = LogFactory.getLog(HtmlServlet.class);

    static ThreadAccessRecord threadAccessRecord = null;

    static Map<String,String> urlrewrite ;



    @Override
    public void init() throws ServletException {
        //线程入库
        threadRegister();
        //url转发规则
        urlrewriteRegister ();
        super.init();
    }
    private void urlrewriteRegister(){
        urlrewrite = new LinkedHashMap<String,String>();

        //搜索
        urlrewrite.put("^/s/search\\.html$","/item.action");
        //按指定条件
        urlrewrite.put("^/c/([a-zA-Z]+?)/([a-zA-Z0-9\\-]+)\\.html$","/item.action?$1=$2");

        //匹配文章显示
        urlrewrite.put("^/([0-9]+)\\.html$","/article.action?id=$1");

        //匹配所有的 /*.html
        urlrewrite.put("^/([a-zA-Z]+?)\\.html$","/$1.action");

        //urlrewrite.put("","");
        //urlrewrite.put("","");
    }
    private void threadRegister() {
        try {
            ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            if(null == ac2){
                log.info("日志线程启动失败，日志功能不可用");
            }else{
                threadAccessRecord = (ThreadAccessRecord)ac2.getBean("threadAccessRecord");
                threadAccessRecord.startSaveDbThread();
                log.info("日志线程启动成功");
            }
        }catch (Exception e){
            log.info("日志线程启动失败，日志功能不可用");
            log.info(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hanld(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hanld(req,resp);
    }

    public void hanld (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取path
        String fromUrl = req.getRequestURI();
        log.info("requestURI:"+fromUrl);
        String toUrl = "index.action";

        for(Map.Entry<String,String> set :urlrewrite.entrySet()){
            String furl = set.getKey();
            Pattern p = Pattern.compile(furl);
            Matcher m = p.matcher(fromUrl);
            boolean b = m.matches();
            if(true == b){
                String turl = set.getValue();
                toUrl = fromUrl.replaceAll(furl,turl);
                log.info("TOURL :" + toUrl);
                //转发到指定页面
                req.getRequestDispatcher(toUrl).forward(req, resp);
                //处理连接情况
                createAccessRecord(req);
                return;
            }
        }

        if(fromUrl.lastIndexOf("/") ==  fromUrl.length()-1){
            req.getRequestDispatcher(fromUrl + "index.action").forward(req, resp);
        }
    }

    /**
     * 创建日志对象,并初始化一些属性值
     * @param request
     * @return
     */
    public void createAccessRecord(HttpServletRequest request){
        if(threadAccessRecord != null){
            String requestPath = ToolWeb.getRequestURIWithParam(request);
            String ip = ToolWeb.getIpAddr(request);
            String referer = request.getHeader("Referer");
            String userAgent = request.getHeader("User-Agent");
            String cookie = request.getHeader("Cookie");
            String method = request.getMethod();
            String xRequestedWith = request.getHeader("X-Requested-With");
            String host = request.getHeader("Host");
            String acceptLanguage = request.getHeader("Accept-Language");
            String acceptEncoding = request.getHeader("Accept-Encoding");
            String accept = request.getHeader("Accept");
            String connection = request.getHeader("Connection");

            AccessRecord ar = new AccessRecord();
            ar.setIps( ip);
            ar.setRequestpath( requestPath);
            ar.setReferer( referer);
            ar.setUseragent( userAgent);
            ar.setCookie( cookie);
            ar.setMethod( method);
            ar.setXrequestedwith( xRequestedWith);
            ar.setHost( host);
            ar.setAcceptlanguage( acceptLanguage);
            ar.setAcceptencoding( acceptEncoding);
            ar.setAccept( accept);
            ar.setConnection( connection);
            ar.setId(UUIDUtils.getUUID());
            threadAccessRecord.add(ar);
        }

    }
}
