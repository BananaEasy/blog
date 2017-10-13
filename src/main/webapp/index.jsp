<%--
  Created by IntelliJ IDEA.
  User: LiHang
  Date: 2017/8/6
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
    dispatcher .forward(request, response);
%>
