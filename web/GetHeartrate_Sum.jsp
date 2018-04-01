<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetHeartRateSum" class="fitbitpack.GetHeartRateSum" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date, period;
    user = request.getParameter("user");
    date = request.getParameter("date");
    period = request.getParameter("period");


    String json = GetHeartRateSum.getdata(user, date, period);
    if ("" != json) {
        out.print(json);
    } else {
        out.print("empty");
    }
%>