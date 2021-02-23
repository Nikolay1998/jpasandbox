<%@ page import="com.kraynov.jpasandbox.services.LoginService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<%
    Object invalidUsername = session.getAttribute("invalidUsername");
%>
    <H2>
        Welcome! Please login fellow kids
    </H2>
    <form action="login" method="post">
        <table>
            <% if (invalidUsername != null) {%>
            <font color="red">Invalid username or password. Please reenter</font>
            <% }%>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password"/></td>
            </tr>
        </table>
        <input type="submit" value="login">
    </form>
</body>
</html>
