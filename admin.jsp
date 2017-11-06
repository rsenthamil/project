<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.bs-example{
    	margin: 200px;
    }
</style>
</head>
<body>

<div class="jumbotron text-center">
<h1> ADMIN </h1>


<br>
<br>

<div class="admin">
    <!--Default buttons with dropdown menu-->
    
    <!--Primary buttons with dropdown menu-->
    <div class="btn-group">
        <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">PRODUCT <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="AddProduct">ADD PRODUCT</a></li>
            <li><a href="viewproduct">VIEWPRODUCT</a></li>
        </ul>
    </div>
    <!--Info buttons with dropdown menu-->
    <div class="btn-group">
        <button type="button" data-toggle="dropdown" class="btn btn-info dropdown-toggle">CATEGORY <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="Category">ADD CATEGORY</a></li>
            <li><a href="viewcategory">VIEW CATEGORY</a></li>
        </ul>
    </div>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
    <div class="container">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="" class="active"></li>
      <li data-target="#myCarousel" data-slide-to=""></li>
      <li data-target="#myCarousel" data-slide-to=""></li>
     
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="img/img-8888.png" alt="" style="width:100%;">
      </div>

      <div class="item">
        <img src="img/img-1111.png" alt="" style="width:100%;">
      </div>
      
    </div>
    </div> 
    
</div>>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
 
<!--footer start from here-->

<div class="copyright">
  <div class="container">
    <div class="col-md-6">
      <p>© 2017 - All Rights with Footwear</p>
    </div>
   </div>
</div>
</body>
</body>
</html>
    
</body>
</html>  