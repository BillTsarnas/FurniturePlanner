<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
    import="org.uniof.manchester.pattern.web.Client"%>
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
<link rel="stylesheet" href="css/previewTotal.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body>

<div class="container">
<form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/PreviewOrder">

  <h1>Details and summary of the order</h1>
  
  <h2>For client #Client_id</h2>
  
        <% 

        //int num_ord = (Integer) request.getAttribute("totOrders");
        for (int i=0; i<= 2; i++) {

        %>
        <details>
           <table>
              <!--<summary><%=request.getAttribute("totOrders") %></summary>-->
              <summary>Order #24892105 - lebes_kitch</summary>
        
              <tr>
                 <th scope="row">Furniture type</th>
                 <td>Kitchen</td>
              </tr>
              <tr>
                 <th scope="row">Order Number</th>
                 <td>#24892105</td>
              </tr>
              <tr>
                 <th scope="row">Clients Name</th>
                 <td>Constantinos Lebesis</td>
              </tr>
              <tr>
                 <th scope="row"></th>
              </tr>
              <tr>
                 <th scope="row">Clients Address</th>
                 <!--<td>
                    1 Oxford road ,<br>
                    Manchester,<br>
                    United Kingdom
                 </td>-->
                 <table id="table1">
                    <thead>
                       <tr>
                          <th>City</th>
                          <th>Country</th>
                          <th>Postcode</th>
                          <th>Phone</th>
                          <th>Mobile Phone</th>
                          <th>Email</th>
                       </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Kalamata</td>
                            <td>Greece</td>
                            <td>24100</td>
                            <td>6976780560</td>
                            <td>2721091390</td>
                            <td>lebesis.c@gmail.com</td>
                        </tr>
                    </tbody>
                 </table>
              </tr>
           </table>
        </details>
        <%
           } 
        %>
</div>    
</form>
</body>
</html>   