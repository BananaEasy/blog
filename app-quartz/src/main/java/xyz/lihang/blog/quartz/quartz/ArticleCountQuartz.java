package xyz.lihang.blog.quartz.quartz;

import xyz.lihang.blog.mapper.dao.ArticleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by LiHang on 2017/8/7.
 *
 * 文章浏览次数自增任务类
 */
@Component
public class ArticleCountQuartz {

    @Resource
    private ArticleMapper articleMapper;

    Logger log = LoggerFactory.getLogger(((getClass())));

    public ArticleCountQuartz(){
        log.info("创建文章浏览次数自增定时任务");
    }


    private static  Queue<Integer> articleIds = new ConcurrentLinkedDeque<Integer>();

    public static void addArticleId (Integer id){
        articleIds.add(id);
    }


    // 获取并移除此队列的头，如果此队列为空，则返回 null
    public static Integer getAarticleId(){
        return articleIds.poll();
    }

    @Scheduled(cron = "0/5 * * * * ? ")//每隔1s执行一次
    //每次处理五个任务
    public void addCount (){
        if( articleIds.size() > 0){
            for(int i=0;i<5;i++){
                Integer aarticleId = getAarticleId();
                if( null != aarticleId ){
                    try{
                        articleMapper.addArticleCount(aarticleId);
                        log.info("文章浏览次数+1 ----- ID:" + aarticleId );
                    }catch (Exception e){
                        log.error("文章Id不存在,...");
                    }
                }else {
                    break;
                }
            }
        }
    }

}
