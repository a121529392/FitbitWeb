
<%@page import="fitbitpack.GetDriver"%>
<%@ page contentType="text/html;"  pageEncoding="Big5" language="java" %>
<jsp:useBean id="GetDriver" class="fitbitpack.GetDriver" />
<%
    request.setCharacterEncoding("UTF-8");
    String  user;
    user = request.getParameter("user");
    String[] ans = GetDriver.getonedriver(user);
    if (ans.length != 0) {

        for (int i = 0; i < ans.length; i++) {

                    out.println(ans[i]);
                    out.println("?");
            }
    }
%>
