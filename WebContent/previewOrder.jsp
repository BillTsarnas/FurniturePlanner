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
<link rel="stylesheet" href="css/previewOrder.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body>

<div class="container">
<form class="form-horizontal" role="form" method="post" action="">

  <h1>Preview of order</h1>
  
  <h2>For client #Client_id</h2>
  
        <% 
        //int num_ord = (Integer) request.getAttribute("totOrders");
        for (int i=0; i<= 2; i++) {
        %>
        
        <details>
           <summary>OrderId #1- lebes_kitch</summary>
           
           <table id="table2" class="table table-bordered">
                 <thead>
                    <th scope="row" style="color:green;">Box details</th>
                    <tr>
                       <th>Piece type</th>
                       <th>Height</th>
                       <th>Width</th>
                       <th>Depth</th>
                       <th>Num of pieces</th>
                       <th>Preview piece (3D)</th>
                    </tr>
                 </thead>
              <tbody>
                 <tr>
                    <td>Box type 1</td>
                    <td>12 cm</td>
                    <td>13 cm</td>
                    <td>4 cm</td>
                    <td>2</td>
                    <td width="10%">
                       <a class="Preview3D" title="Preview3D" data-toggle="tooltip" onclick="window.location.href='http://localhost:8080/FurniturePlanner/piece3D.jsp'"><i class="material-icons">&#xE84D;</i></a>
                                 <a href="#" class="btn btn-success btn-sm" data-toggle="modal" data-target="#basicModal">
                 <b>Register new Order for an existing Client</b>
              </a>

			  <div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
				aria-labelledby="basicModal" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Search Client by Name</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/SearchClient">
						<div class="modal-body">
							<div class="searchModal">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search..."
										id="searchClient" name="searchName"> <span class="input-group-btn">
										<input type="hidden" name = "hid_cln_val" value="0">
										<!-- button class="btn btn-default" type="button"
											data-toggle="modal" data-target="#searchClientModal">Go!</button-->
									</span>
								</div>
							</div>
						</div>
						<div class="modal-footer">
						   <button type="button" class="btn btn-default"
								data-dismiss="modal">Cancel</button>
						   <button type="submit" class="btn btn-success">Next</button>
						</div>
						</form>
					</div>
				</div>
			</div>
                    </td>
                 </tr>
                 <tr>
                    <td>Box type 2</td>
                    <td>19 cm</td>
                    <td>11 cm</td>
                    <td>12 cm</td>
                    <td>1</td>
                    <td width="10%"> 
                       <a class="Preview3D" title="Preview3D" data-toggle="tooltip" onclick="window.location.href='http://localhost:8080/FurniturePlanner/piece3D.jsp'"><i class="material-icons">&#xE84D;</i></a>
                    </td>
                 </tr>
              </tbody>
           </table>

           <table class="table table-bordered">
              <th scope="row" style="color:green;">Order details</th>
              <tr>
                 <th scope="row">Furniture type</th>
                 <td>Kitchen</td>
              </tr>
              <tr>
                 <th scope="row">Furniture name</th>
                 <td>lebes_kitch</td>
              </tr>
              <tr>
                 <th scope="row">Order Number</th>
                 <td>#24892105</td>
              </tr>
 
              <tr>
                 
                 <table id="table1" class="table table-bordered">
                    <thead>
                    <th scope="row" style="color:green;">Client details</th>
                       <tr>
                          <th>First Name</th>
                          <th>Last Name</th>
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
                            <td>Constantinos</td>
                            <td>Lebesis</td>
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
           </tr>
        </details>
        <%
           } 
        %>
        <div class="price_btn">
           <label>Total price</label>
           <p>3000.30&euro;</p>
        </div>

        <button type="button" class="btn btn-success" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Next</button>
        <button type="submit" class="btn btn-primary" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/installments.jsp'">Set installments</button>
        
           
</div>    
</form>
</body>
</html>   