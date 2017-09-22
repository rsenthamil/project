
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

    <head>
<style>
body  {
    background:"D:\footwear\img-9.jpg";

    background-color:lightpink;
    }
</style>
</head>
<!-- Form Name -->
<div align="center">
<h1>ADD PRODUCT</h1>
</div>
<form:form action="Addproduct" commandName="Addproduct" method="POST" onsubmit="return validate">
<div class="logo-fixed"><img src="D:\footwear\img-9.jpg" width="650" height="400" ></div>

<!-- Text input-->
<div align="center">

<div class="form-group">
  <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
  <div class="col-md-4">
  <form:input id="product_name" name="product_name" placeholder="Product Name" path="pName" class="form-control input-md"  type="text"></form:input>>
    </div>
  </div>
</div>
<br>
<div align="center">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name_fr">PRODUCT PRIZE</label>  
  <div class="col-md-4">
  <form:input id="product prize" name="product prize" placeholder="Product Prize" path="pPrize" class="form-control input-md" type="number"></form:input>>
    
  </div>
</div>
</div>
<br>
<div align="center">

<!-- Text input -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_categorie">PRODUCT DESCRIPTION </label>
  <div class="col-md-4">
  <form:input id="product Description" name="product Description" placeholder="Description" path="pDes" class="form-control input-md" required="" type="text"></form:input>
  </div>
</div>
</div>
<br>

<br>
<div align="center">
<!-- Text input -->
<div class="form-group">
  <label class="col-md-4 control-label" for="percentage discount">PERCENTAGE DISCOUNT</label>
  <div class="col-md-4"> 
  <form:input id="Percentage Discount" name="Percentage Discount" placeholder="Percentage Discount" path="pPer" class="form-control input-md" required="" type="text"></form:input>>                    
    </div>
  </div>
</div>
<div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">submit</button>
      </div>
    </div>
 </form:form> 