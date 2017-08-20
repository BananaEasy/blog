package com.blog.redis.mvc.service;

import com.blog.model.Message;
import com.blog.mvc.exception.MyException;
import com.blog.tool.ToolString;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LiHang on 2017/8/20.
 */
@Service
public class MessageHandle extends RedisBaseService<Message> {

    private Log log = LogFactory.getLog(getClass());

    private String listKey() {
        return className + "_List";
    }

    public Message add(Message message) {

        if (StringUtils.isBlank(message.getName()) || StringUtils.isBlank(message.getContent()) || StringUtils.isBlank(message.getEmail())) {
            throw new MyException(" 请将内容填写完整");
        }

        //校验用户名
        if (!ToolString.regExpVali(message.getName(), ToolString.regExp_userName)) {
            throw new MyException("  昵称不规范,请使用如下规范\n(2-7)个汉字或者(3-10)个字母");
        }

        //校验邮箱
        if (!ToolString.regExpVali(message.getEmail(), ToolString.regExp_email)) {
            throw new MyException("  邮箱格式不正确，请正确填写");
        }
        message.setId(getKey());
        message.setDate(new Date());
        log.info("添加留言" +message);
        listOperations.leftPush(listKey(), message);
        return message;
    }

    private int size  = 10;

    public List<Message> list(int page) {
        int start = (page-1) * size ;
        int stop =  start + size;
        List<Message> list = listOperations.range(listKey(), start, stop);
        log.info("start:" + start + "---stop:" + stop + "----" +list);
        if(list.size() == 0){
            throw new MyException("无更多内容");
        }
        return list;
    }

}
