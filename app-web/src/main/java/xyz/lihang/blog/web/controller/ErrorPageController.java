package xyz.lihang.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorPageController implements ErrorController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public String index(HttpServletRequest request , HttpServletResponse response) {
        int status = response.getStatus();
        log.error("uri:" + request.getRequestURI() + "\tcode；" + status);
        if(status == 500){
            log.error("errorUri: " + request.getAttribute("javax.servlet.error.request_uri"));
            log.error("errorType: " +request.getAttribute("javax.servlet.error.exception_type")
                    +  " \terrorMessage: " + request.getAttribute("javax.servlet.error.message"));
        }
        return "/404.htm";
    }
}
