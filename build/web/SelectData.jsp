
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="SelectData" class="fitbitpack.SelectData" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date, table;
    user = request.getParameter("user");
    date = request.getParameter("date");
    table = request.getParameter("table");
    String[][] json = SelectData.getdata(user, date, table); 

%>
<table style="border:3px #418fc6 solid;padding:5px;" rules="all" cellpadding='5'>
    <%    for (int i = 0; i < json.length; i++) {
        /*if(json[i][0].equals("User_ID")){
            continue;
        }*/
    %>
    <tr>
        <%
            for (int j = 0; j < json[i].length; j++) {
        %>
        <td><%
            out.print(json[i][j]);%>
        </td><%
                }
                out.print("\n");
            }

        %>
</table>