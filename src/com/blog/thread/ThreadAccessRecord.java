package com.blog.thread;

import com.blog.mvc.dao.AccessRecordMapper;
import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.utils.UUIDUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by LiHang on 2017/8/6.
 */
@Component
public class ThreadAccessRecord {

    @Resource
    private AccessRecordMapper accessRecordMapper;

    private  final Log log = LogFactory.getLog(ThreadAccessRecord.class);

    private static boolean threadRun = true;

    private  Queue<AccessRecord> queue = new ConcurrentLinkedDeque<AccessRecord>();

    public  void setThreadRun(boolean threadRun) {
        ThreadAccessRecord.threadRun = threadRun;
    }

    public void add(AccessRecord ar){
        // 将指定元素插入此队列的尾部
        queue.offer(ar);
    }

    public  AccessRecord getAccessRecord(){
        // 获取并移除此队列的头，如果此队列为空，则返回 null
        return queue.poll();
    }

    public void startSaveDbThread(){
        try{
            for(int i=0; i<10; i++){
                Thread insertDbThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (threadRun){
                            try{
                                AccessRecord ar = getAccessRecord();
                                if(null == ar){
                                    Thread.sleep(200);
                                } else {
                                    log.info("保存系统日志到数据库start......");
                                    accessRecordMapper.insert(ar);
                                    log.info("保存操作日志到数据库end......");
                                }
                            } catch (InterruptedException e) {
                                log.error("保存系统日志到数据库异常：" + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }
                });

                insertDbThread.setName("Thread-SysLog-insertDb-" + (i + 1));
                insertDbThread.start();
            }
        }catch (Exception e){
            throw new RuntimeException("ThreadSysLog new Thread Exception");
        }
    }
}
