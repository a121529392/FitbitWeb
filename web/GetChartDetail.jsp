
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetChartManyData" class="fitbitpack.GetChartManyData" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date, table;
    String value;
    user = request.getParameter("user");
    date = request.getParameter("date");
    table = request.getParameter("table");
    value = request.getParameter("value");
    String[][] ans = GetChartManyData.getdata(user, date, table,value);
    if (ans.length != 0) {

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (j == ans[i].length - 1) {
                    out.println(ans[i][j] + "?");
                } else {
                    out.println(ans[i][j]);
                }
            }
        }
    }
%>
