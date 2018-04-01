
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetChart" class="fitbitpack.GetChart" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date, table;
    user = request.getParameter("user");
    date = request.getParameter("date");
    table = request.getParameter("table");
    String[][] ans = GetChart.getdata(user, date, table);
    if (ans.length != 0) {

        for (int i = 0; i < ans.length; i++) {
            if(ans[i].length==0){
                out.println("?");
            }
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
