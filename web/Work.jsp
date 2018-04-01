
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="SelectStatusList" class="fitbitpack.SelectStatusList" />
<%
    request.setCharacterEncoding("UTF-8");
    String user, date,value;
    user = request.getParameter("user");
    date = request.getParameter("date");
value = request.getParameter("value");
    String[][] json = SelectStatusList.getwork(user,date,value); 

%>
<h1>ClockIn/ClockOn List</h1>
<table style="border:3px #418fc6 solid;padding:5px;overflow:auto;width:40%;height:50%;margin-top:20px" rules="all" cellpadding='5'>
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

    <br/>
    