<style>
body {
    background-color:light pink;
    }
    </style>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>

<form:form>
<h1>List of Items</h1>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">Product ID</th>
<th width="15%">Product Name</th>
<th width="10%">Percentage Discount</th>
<th width="10%">Product Prize</th>
<th width="10%">Product Description</th>
<th width="10%">Product Category</th>
<th width="10%">Image</th>
<th width="10%">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="list" items="${lists}">
<tr>
    <td><c:out value="${list.pid}"/></td>
    <td><c:out value="${list.pName}"/></td>
    <td><c:out value="${list.pPer}"/></td>
    <td><c:out value="${list.pPrize}"/></td>
    <td><c:out value="${list.pDes}"/></td>
    <td><c:out value="${list.category.name}"/></td>
    
    <td>
    <img src="${pageContext.request.contextPath}/images/${list.pid}.png" height="200" width="200"></td>
    <td>
    <button type="submit"  formaction="/Project/editproduct/${list.pid}">Edit</button>
    <button type="submit" formmethod="post" formaction="/Project/delete/${list.pid}">Delete</button>
    </td>
</tr>
</c:forEach>
</tbody>
</table>
</form:form>

</body>