package xyz.lihang.blog.mvc.quartz;

import xyz.lihang.blog.mvc.dao.AccessRecordMapper;
import xyz.lihang.blog.mvc.entity.AccessRecord;
import xyz.lihang.blog.tool.utils.UUIDUtils;
import xyz.lihang.blog.tool.ToolWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by LiHang on 2017/8/6.
 *
 * 访问日志入库
 */
@Component
public class AccessRecordQuartz {

    @Resource
    private AccessRecordMapper accessRecordMapper;

    private   Logger log = LoggerFactory.getLogger(((getClass())));

    private static  Queue<AccessRecord> queue = new ConcurrentLinkedDeque<>();


    public AccessRecordQuartz(){
        log.info("创建访问日志入库定时任务");
    }

    public static void add(AccessRecord ar){
        // 将指定元素插入此队列的尾部
        queue.offer(ar);
    }

    public static  AccessRecord getAccessRecord(){
        // 获取并移除此队列的头，如果此队列为空，则返回 null
        return queue.poll();
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void startSaveAccessRecord(){
        try{
            if(queue.size() > 0){
                for(int i=0; i<10; i++){
                    AccessRecord ac = getAccessRecord();
                    if(null != ac){
                        if((!ac.getRequestpath().contains("admin"))&& (!ac.getRequestpath().contains("error"))
                           && (!ac.getRequestpath().contains("login"))
                                ){
                            log.info(" accessRecord\tsave:\t" + ac.toString());
                            accessRecordMapper.insert(ac);
                        }
                    } else{
                        break;
                    }
                }
            }

        }catch (Exception e){
           log.error(e.getMessage());
           e.printStackTrace();
        }
    }


    /**
     * 创建日志对象,并初始化一些属性值
     * @param request
     * @return
     */
    public static void createAccessRecord(HttpServletRequest request){
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
            add(ar);
        }




}
