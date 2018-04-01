<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetHeartRateDetail" class="fitbitpack.GetHeartRateDetail" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date, period,sttime,endtime;
    user = request.getParameter("user");
    date = request.getParameter("date");
    period = request.getParameter("period");
    sttime = request.getParameter("starttime");
    endtime = request.getParameter("endtime");

    String json = GetHeartRateDetail.getdata(user, date, period,sttime,endtime);
    if ("" != json) {
        out.print(json);
    } else {
        out.print("empty");
    }
%>