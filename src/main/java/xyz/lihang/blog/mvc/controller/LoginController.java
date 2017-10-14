package xyz.lihang.blog.mvc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.lihang.blog.model.LoginUser;
import xyz.lihang.blog.mvc.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController extends BaseController{

    /**
     * 登陆页面
     */
    @RequestMapping(value="/login" )
    public String login(){
        return "login.jsp";
    }


    /**
     * 登陆
     */
    @RequestMapping(value="/loginAdmin" )
    public void loginAdmin(HttpServletRequest request, HttpServletResponse response, String name, String password) throws IOException {
        if(!(StringUtils.isBlank(name) || StringUtils.isBlank(password))){
            LoginUser loginUser = new LoginUser(name,password);
            log.info("登陆User:" + loginUser);
            if(Constant.getUsers().contains(loginUser)){
                request.getSession().setAttribute("userLogin",loginUser);
            }
        }
        response.sendRedirect("/admin/index.action");
    }
}
