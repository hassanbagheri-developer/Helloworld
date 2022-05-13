<html>
<head>
    <title>Hello World!</title>
</head>
<body>
    <h1>Hello World!</h1>
    <h3>Version 21</h3>
    <p>
        It is now
        <%= new java.util.Date()%>
    </p>
    <p>

        You are coming from
<%--        <%= request.getRemoteAddr() %>--%>
        <%= request.getLocalAddr() %>
    </p>

</body>
</html>
