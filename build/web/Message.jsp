
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="InsertMessage" class="fitbitpack.InsertMessage" />
<%
    request.setCharacterEncoding("UTF-8");
    String  table,user,message;
    table = request.getParameter("table");
    user = request.getParameter("user");
    message = request.getParameter("message");
     InsertMessage.senddata(table,user,message);

%>
