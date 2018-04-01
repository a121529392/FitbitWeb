<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetSleepMoreDays" class="fitbitpack.GetSleepMoreDays" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date,enddate ;
    user = request.getParameter("user");
    date = request.getParameter("date");
    enddate = request.getParameter("enddate");
    
    String json = GetSleepMoreDays.getdata(user, date,enddate);
    if ("" != json) {
        out.print(json);
    } else {
        out.print("empty");
    }
%>