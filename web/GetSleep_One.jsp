<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetSleepOneDay" class="fitbitpack.GetSleepOneDay" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date ;
    user = request.getParameter("user");
    date = request.getParameter("date");

    String json = GetSleepOneDay.getdata(user, date);
    if ("" != json) {
        out.print(json);
    } else {
        out.print("empty");
    }
%>