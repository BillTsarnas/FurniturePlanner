<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
    import="org.uniof.manchester.pattern.web.Order"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Preview of order</title>


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

  <h1>Preview of order</h1>
  
  <!-- client details table -->
  <table class="table table-bordered">
     <thead>
     <th scope="row" style="color:blue;">Client details</th>
        <tr>
           <td width="20%"><b>For client</b></td> 
           <td width="20%"><b>Order name</b></td> 
           <td width="10%"><b>Order status</b></td> 
        </tr>
     </thead>
     <tbody>
        <tr>
           <td>Constantinos Lebesis</td> 
           <td>#1</td> 
           <td>Active</td>   
        </tr>
     </tbody>
   </table>
   
   <!-- installments table -->
   <table class="table table-bordered">
     <thead>
     <th scope="row" style="color:blue;">Installment details</th>
        <tr>
           <td width="40%"><b>Installments</b></td> 
           <td width="30%"><b>Amount</b></td> 
           <td width="30%"><b>Payment method</b></td> 
        </tr>
     </thead>
     <tbody>
        <% 
        for (int c=0; c<= 1; c++) {
        %>
        <tr>
           <td>4</td> 
           <td>300&euro;</td> 
           <td>Credit/Debit card</td> 
        </tr>
        <%
        } 
        %>
     </tbody>
   </table>
        <% 
        for (int i=0; i<= 2; i++) {
        %>
        <details>
           <summary>Furniture #Kitchen_1</summary>
           <% 
           for (int j=0; j<= 2; j++) {
           %>
           <table class="table table-bordered">
              <thead>
              <th scope="row" style="color:green;">Box with 3 shelves</th>
                 <tr>
                    <td><b>Number of Pieces</b></td> 
                    <td><b>Height</b></td> 
                    <td><b>Width</b></td> 
                    <td><b>Depth</b></td> 
                    <td><b>Material</b></td> 
                    <td><b>Colour</b></td> 
                    <td><b>Thickness</b></td> 
                 </tr>
              </thead>
              <tbody>
              <% 
              for (int s=0; s<= 2; s++) {
              %>
                 <tr>
                    <td>4</td> 
                    <td>10.32 cm</td> 
                    <td>13.45 cm</td> 
                    <td>12.04 cm</td> 
                    <td>Wood</td> 
                    <td>Red</td> 
                    <td>40.90 cm</td> 
                 </tr> 
              </tbody>
              <%
              } 
              %>
           </table>

           <%
           } 
           %>
        </details>
        <%
        } 
        %>
        <div class="price_btn">
           <label>Total price</label>
           <p>3000.30&euro;</p>
        </div>
        
        <button type="submit" class="btn btn-danger" style="float: left;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
        <button type="button" class="btn btn-success" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Next</button>
        <button type="submit" class="btn btn-primary" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/installments.jsp'">Set installments</button>
        
           
</div>    
</form>
</body>
</html>