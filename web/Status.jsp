
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="InsertStatus" class="fitbitpack.InsertStatus" />
<%
    request.setCharacterEncoding("UTF-8");
    String  status,user;
    status = request.getParameter("status");
    user = request.getParameter("user");
     InsertStatus.senddata(user,status);

%>
