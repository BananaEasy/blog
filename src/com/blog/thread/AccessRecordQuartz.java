package com.blog.thread;

import com.blog.mvc.dao.AccessRecordMapper;
import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.utils.UUIDUtils;
import com.blog.tool.ToolWeb;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Lazy;
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
@Lazy(false)
public class AccessRecordQuartz {

    @Resource
    private AccessRecordMapper accessRecordMapper;

    private   Log log = LogFactory.getLog(getClass());

    private static  Queue<AccessRecord> queue = new ConcurrentLinkedDeque<AccessRecord>();


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
                    AccessRecord ar = getAccessRecord();
                    if(null != ar){
                        log.info("保存系统日志到数据库");
                        accessRecordMapper.insert(ar);
                    } else{
                        break;
                    }
                }
            }

        }catch (Exception e){
           log.error(e.getMessage());
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
