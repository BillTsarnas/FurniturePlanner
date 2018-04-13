<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.uniof.manchester.pattern.web.Client"
    import="org.uniof.manchester.pattern.web.Order"
    import="org.uniof.manchester.pattern.web.database.DatabaseManager"
    import="java.sql.Connection"
    import="javax.sql.DataSource"
    import="javax.annotation.Resource"
    import="javax.servlet.annotation.WebServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/home.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="javascript/jquery-1.12.1.min.js"></script>

<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascript/home.js"></script>


</head>


    <div class="productboxOne">
        <div class="producttitle">Register new Client</div>
        <div class="productprice">
          <div class="pull-right">
            <button type="button" class="btn btn-success btn-sm" onclick="location.href='http://localhost:8080/FurniturePlanner/regClient.jsp'">New</button>
          </div>
        </div>
    </div>
    <div class="productboxTwo">
        <div class="producttitle">Register new Order</div>
        <div class="productprice">
          <div class="pull-right">
              <a href="#" class="btn btn-success btn-sm" data-toggle="modal" data-target="#basicModal">
                 New
              </a>

			  <div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
				aria-labelledby="basicModal" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Available Clients</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">�</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="searchModal">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search..."
										id="searchClient"> <span class="input-group-btn">
										<button class="btn btn-default" type="button"
											data-toggle="modal" data-target="#searchClientModal">Go!</button>
									</span>
								</div>
							</div>

							<%
							    String name = "Costas";
							    Client client = new Client(0,  "test",  "test",  "test",  "test",  "test",
									"test");
								//Client clnt = hm.searchForClient(0);
							    //String name = client.getName();
							    
								if ( name == null) {
							%>

                            <p>The client: <%= name %> is not registered yet, please go back and select 
                            <b>Register new Client</b></p>


							<%
								} else {
							%>
							
							<div class="radio disabled">
								<label><input type="radio" name="optradio" disabled><%= name %>
								</label>
							</div>
														
							<%
								}
							%>

						</div>
						<div class="modal-footer">
						   <button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						   <button type="button" class="btn btn-success">Next</button>
						</div>
					</div>
				</div>
			</div>
		</div>
        </div>
    </div>


    <div class="searchOne">
        <h3>Search for Client</h3>
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search..." id="searchClient">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#searchClientModal">Go!</button>
          </span>
        </div>
    </div>

    <div class="searchTwo">
        <h3>Search for Order</h3>
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search..." id="searchOrder">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button" onclick="location.href='http://localhost:8080/FurniturePlanner/searchOrder.jsp'">Go!</button>
          </span>
        </div>
    </div>



</body>
</html>                            