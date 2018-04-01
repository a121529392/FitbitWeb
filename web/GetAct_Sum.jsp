<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetActSum" class="fitbitpack.GetActSum" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date ;
    user = request.getParameter("user");
    date = request.getParameter("date");


    String json = GetActSum.getdata(user, date);
    if ("" != json) {
        out.print(json);
    } else {
        out.print("empty");
    }
%>