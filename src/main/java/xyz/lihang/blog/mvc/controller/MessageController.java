package xyz.lihang.blog.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.annotation.RenderJsonInvok;
import xyz.lihang.blog.model.Message;
import xyz.lihang.blog.mvc.exception.MyException;
import xyz.lihang.blog.mvc.service.impl.MessageHandle;
import xyz.lihang.blog.tool.ToolWeb;
import xyz.lihang.blog.tool.utils.RenderJson;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        if(p == null || p<= 0){
            p = 1;
        }
        List<Message> list = messageHandle.list(p,10);
        return renderJson.SUCCESS().setList(list);
    }

}
