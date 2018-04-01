<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="UpdateDB" class="fitbitpack.UpdateDB" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date,table ;
    user = request.getParameter("user");
    date = request.getParameter("date");
    table = request.getParameter("table");
    UpdateDB.update(user, date,table);
%>

