<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Entities List</title>
</head>
<body>

<%-- LIST OF BREADS --%>
<h2>Bakery List</h2>
<c:forEach items="${bakeries}" var="ba"> <%-- For(each) loop that loops through each bakery entity and calls its toString method to show it on the page --%>
    <ul> <%-- bullet point list --%>
        <li>${ba.toString()}</li> <%-- bullet point list item --%>
    </ul> <%-- end of bullet point list --%>
</c:forEach>

<h2>Bread List</h2>
<c:forEach items="${breads}" var="br">
    <ul>
        <li>${br.toString()}</li>
    </ul>
</c:forEach>

<h2>Ingredient List</h2>
<c:forEach items="${ingredients}" var="i">
    <ul>
        <li>${i.toString()}</li>
    </ul>
</c:forEach>
</body>
</html>