<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetActDetail" class="fitbitpack.GetActDetail" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date, period,sttime,endtime,id;
    user = request.getParameter("user");
    date = request.getParameter("date");
    period = request.getParameter("period");
    sttime = request.getParameter("starttime");
    endtime = request.getParameter("endtime");
    id=request.getParameter("actid");

    String json = GetActDetail.getdata(user, date, period,sttime,endtime,id);
    if ("" != json) {
        out.print(json);
    } else {
        out.print("empty");
    }
%>