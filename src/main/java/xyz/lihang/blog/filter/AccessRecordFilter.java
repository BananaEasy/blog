package xyz.lihang.blog.filter;


import org.springframework.stereotype.Component;
import xyz.lihang.blog.mvc.quartz.AccessRecordQuartz;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AccessRecordFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        AccessRecordQuartz.createAccessRecord(req);
    }

    @Override
    public void destroy() {

    }
}
