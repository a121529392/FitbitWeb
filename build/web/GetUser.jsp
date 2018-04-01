<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetUser" class="fitbitpack.GetUser" />
<%

    String[] json = GetUser.getdata();
    for(int i=0;i<json.length;i++){
        out.println(json[i]);
    }
%>
