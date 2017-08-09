package com.blog.mvc.controller;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import com.github.sd4324530.fastweixin.util.SignUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiHang on 2017/8/9.
 */
@RestController
@RequestMapping("/weixin.action")
public class WeixinController extends WeixinSupport {
    private Log log = LogFactory.getLog(getClass());

    private static final String TOKEN = "a123520";
    private static final String APPID = "wxfae1691a49b0dd80";
    private static final String AESKEY = "rbwUul1BPGeaNsyA6mgqHjd3VfouDLJmWZY2D3vibis";

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public void bind(HttpServletRequest request, HttpServletResponse response) {
        bindServer(request, response);
    }

    //设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken() {
        return TOKEN;
    }
    //使用安全模式时设置：APPID
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAppId() {
        return APPID;
    }
    //使用安全模式时设置：密钥
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAESKey() {
        return AESKEY;
    }
    //重写父类方法，处理对应的微信消息
    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        log.debug("用户发送到服务器的内容:{}"+ content);
        return new TextMsg("服务器回复用户消息!");
    }
    /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
     *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
     *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
     */
    @Override
    protected List<MessageHandle> initMessageHandles() {
        List<MessageHandle> handles = new ArrayList<MessageHandle>();
        //handles.add(new MyMessageHandle());
        return handles;
    }
    //1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
    @Override
    protected List<EventHandle> initEventHandles() {
        List<EventHandle> handles = new ArrayList<EventHandle>();
        //handles.add(new MyEventHandle());
        return handles;
    }

    @Override
    protected boolean isLegal(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        boolean legal = super.isLegal(request);

        log.info(signature + "-------" + timestamp + "-------" + nonce + "---------" + legal);
        return legal;
    }
}
