<html>
<body>
<h1>Welcome human!</h1>
    <form method="post" action="/login">
        <label for="name">Type your name:</label>
        <input type="text" name="name" id="name" />
        <input type="submit"/>
        <br>
        <%
            if (request.getAttribute("error") != null) {
        %>
                <label style = "color:red">
                    <%=
                        request.getAttribute("error")
                    %>
                </label>
        <%
            }
        %>
    </form>
</body>
</html>