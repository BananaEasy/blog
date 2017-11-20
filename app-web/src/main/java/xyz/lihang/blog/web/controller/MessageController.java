package xyz.lihang.blog.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.common.tool.annotation.RenderJsonInvok;
import xyz.lihang.blog.mapper.dto.MessageDto;
import xyz.lihang.blog.mapper.model.Message;
import xyz.lihang.blog.service.exception.MyException;
import xyz.lihang.blog.service.redis.MessageHandle;
import xyz.lihang.blog.common.tool.ToolWeb;
import xyz.lihang.blog.common.tool.utils.RenderJson;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController  extends BaseController{

    @Resource
    private MessageHandle messageHandle;

    /**
     * 留言板
     * @return
     */
    @RequestMapping(value="/message" ,method={RequestMethod.GET})
    public String message(){
        return "blog/message.ftl";
    }


    /**
     * 留言
     */
    @RenderJsonInvok
    @RequestMapping(value="/message/commont", method = RequestMethod.POST)
    @ResponseBody
    public RenderJson messageCommont(HttpServletRequest request, Message message){
        RenderJson renderJson = RenderJson.Instance();
        if(message == null){
            throw new MyException("参数错误");
        }
        message.setIp(ToolWeb.getIpAddr(request));
        Message m = messageHandle.add(message);
        return renderJson.SUCCESS().setMessage("留言成功").setObj(m);
    }


    /**
     * 留言列表
     */
    @RenderJsonInvok(errorMsg = "获取失败")
    @RequestMapping(value="/message/commontList",method = RequestMethod.POST)
    @ResponseBody
    public RenderJson messageCommontList(Integer p){
        RenderJson renderJson = RenderJson.Instance();
        p = p == null || p<= 0 ? 1: p;
        List<Message> list = messageHandle.list(p,10);
        List<MessageDto> dtoList = new ArrayList<>();
        for(Message m : list){
            MessageDto messageDto = new MessageDto();
            BeanUtils.copyProperties(m,messageDto);
            dtoList.add(messageDto);
        }
        return renderJson.SUCCESS().setList(dtoList);
    }





}
