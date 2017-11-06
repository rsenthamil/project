<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
body  {
    background-color:pink;
    }
</style>
<body>

<form:form>
<h1>List of Items</h1>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">Category ID</th>
<th width="15%">Category Name</th>
<th width="10%">Category Description</th>
<th width="10%">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="list" items="${lists}">
<tr>
    <td><c:out value="${list.id}"/></td>
    <td><c:out value="${list.name}"/></td>
    <td><c:out value="${list.desc}"/></td>
    <td>
    <button type="submit"  formaction="/Project/editcategory/${list.id}">Edit</button>
    <button type="submit" formmethod="post" formaction="/Project/delete1/${list.id}">Delete</button>
    </td>
</tr>
</c:forEach>
</tbody>
</table>
</form:form>

</body>