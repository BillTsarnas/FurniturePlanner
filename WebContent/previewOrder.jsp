<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Preview order</title>


<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/previewOrder.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body>

<div class="container">

<form class="form-horizontal" role="form" method="post" action="">

  <h1>Full order details for order #lebes_kitch</h1>

        <table class="table table-bordered">

           <summary>orderID - #1</summary>
              <tr>
                 <th scope="row">Status</th>
                 <td>Active</td>
              </tr>
              <tr>
                 <th scope="row">Kind of furniture</th>
                 <td>Kitchen</td>
              </tr>
              <tr>
                 <th scope="row">Box</th>
                 <td>TEST</td>
              </tr>
              <tr>
                 <th scope="row">Height</th>
                 <td>123</td>
              </tr>
              <tr>
                 <th scope="row">Width</th>
                 <td>239</td>
              </tr>
              <tr>
                 <th scope="row">Depth</th>
                 <td>34</td>
              </tr>
              <tr>
                 <th scope="row">Number of shelves</th>
                 <td>4</td>
              </tr>
              <tr>
                 <th scope="row">Melimine colour</th>
                 <td>Red</td>
              </tr>
              <tr>
                 <th scope="row">Door colour</th>
                 <td>Green</td>
              </tr>
              
              
              
              <!-- innner table - table1 -->
              <table id="table1" class="table table-bordered">
                 <thead>
                    <tr>
                       <th>First Name</th>
                       <th>Last Name</th>
                       <th>Address</th>
                       <th>Manchester</th>
                       <th>Country</th>
                       <th>Postal code</th>
                       <th>Phone</th>  
                       <th>Mobile Phone</th> 
                       <th>Email</th> 
                    </tr>
                 </thead>
                 <tbody>
                    <tr>
                       <td>Constantinos</td>
                       <td>Lebesis</td>
                       <td>1 Oxford road</td>
                       <td>Manchester</td>
                       <td>Greece</td>
                       <td>M1 5NR</td>
                       <td>27121091390</td>
                       <td>6946780560</td>
                       <td>lebesis.c@gmail.com</td>
                    </tr>  
                 </tbody>
              </table>
              <!-- end inner table1 -->
        </table>
        
        <div class="price_btn">
           <label>Total price</label>
           <p>3000.30€</p>
        </div>

        <button type="submit" class="btn btn-success">Ok</button>
           
</div>    
</form>
</body>
</html>  