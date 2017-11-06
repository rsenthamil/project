<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
  <title>ADD PRODUCT</title>  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
    background-color: lightblue;
    }
    </style>
<body>


  <form:form class="form-horizontal" action="AddProduct" commandName="AddProduct" enctype="multipart/form-data">

  <fieldset>
    <div id="legend">
   
      <legend class="">ADD PRODUCT</legend>
    
    </div>
    
      <div class="control-group">
      <!-- Productname -->
      <label class="control-label" for="productname">PRODUCT NAME</label>
      <div class="controls">
        <form:input type="text" id="productname" path="pName" name="productname" placeholder="productname" class="input-xlarge"/>
        <p class="help-block"></p>
      </div>
    </div>
 
     <div class="control-group">
      <!--productPrize -->
      <label class="control-label" for="productPrice">PRODUCT PRICE</label>
      <div class="controls">
        <form:input type="text" id="productPrize" path="pPrize" name="productPrize" placeholder="price" class="input-xlarge"/>
        <p class="help-block"></p>
      </div>
    </div>
 
    <div class="control-group">
      <!--productDescription -->
      <label class="control-label" for="productdescription">PRODUCT DESCRIPTION</label>
      <div class="controls">
        <form:input type="text" id="productdescription" path="pDes" name="productdescription" placeholder="Description" class="input-xlarge"/>
        <p class="help-block"></p>
      </div>
    </div>
 
         <div class="control-group">
      <!-- percentagediscount -->
      <label class="control-label"  for="percentagediscount">PERCENTAGE DISCOUNT</label>
      <div class="controls">
        <form:input type="text" path="pPer" id="percentagediscount" name="percentagediscount" placeholder="Discount" class="input-xlarge"/>
        <p class="help-block"></p>
      </div>
    </div>
 <br>
<div class="form-group">
  <label class="col-md-4 control-label" for="productcategory">PRODUCT CATEGORY</label>  
  <div class="col-md-4">
  <c:forEach items="${categories}" var="c">
   <form:radiobutton path="category.id" value="${c.id}"/>${c.name}
</c:forEach>
</div>
</div>
<br>

<div class="form-group">
  <label class="col-md-4 control-label" for="filebutton">Image</label>
  <div class="col-md-4">
    <form:input id="filebutton" name="filebutton" class="input-file" type="file" path="image"></form:input>
  </div>
</div>
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">SUBMIT</button>
      </div>
    </div>
    
  </fieldset>
</form:form>



