<html>
<head><title>Forgot Password</title></head>
<body>
<form action="forgot_password" method="post">
    <label for="email">Enter your email:</label>
    <input type="email" id="email" name="email"><br><br>
    <input type="submit" value="Submit">
</form>
<%
    if (request.getAttribute("errorMessage") != null) {
        out.println("<p style='color:red'>" + request.getAttribute("errorMessage") + "</p>");
    } else if (request.getAttribute("message") != null) {
        out.println("<p style='color:green'>" + request.getAttribute("message") + "</p>");
    }
%>
</body>
</html>
