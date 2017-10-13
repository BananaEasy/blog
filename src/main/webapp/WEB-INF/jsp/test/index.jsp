<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
 
  
   <form action="<%= basePath %>test.action" method="post" >
   	id<input type="text" name="id"/><br/>
   	  	stuId<input type="text" name="stuId"/><br/>
   	  	stuName<input type="text" name="stuName"/><br/>
   	  	idCard<input type="text" name="idCard"/><br/>
   	  	sex<input type="text" name="sex"/><br/>
   	  	birthDate<input type="text" name="birthDate"/><br/>
   	  	school<input type="text" name="school"/><br/>
   	  	<input type="submit"/>
   </form>
  </body>
</html>
