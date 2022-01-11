<%@ page import = "java.util.List" %>
<%@ page import = "ru.gb.entity.lesson1.Product" %>
<%@ page contentType = "text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Products</title>
    </head>

    <body>
        <h1>Products</h1>
        <hr>
        <ul>
        <% for (Product value: (List<Product>)request.getAttribute("products")) { %>
            <li>id: <%=value.getId()%>; title: <%=value.getTitle()%>; cost: <%=value.getCost()%></li>
        <% } %>
        </ul>
        <hr>
    </body>
</html>
