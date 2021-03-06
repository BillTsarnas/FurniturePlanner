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
<body background="img/background.jpg">

<div class="container">
    <div class="productboxOne">
        <button type="button" class="btn btn-success btn-sm" onclick="location.href='http://localhost:8080/FurniturePlanner/regClient.jsp'" >
        <b>Register new Order for new Client</b>
        </button>
    </div>
    <div class="productboxTwo">
          <!--button type="button" class="btn btn-success btn-sm" onclick="location.href='http://localhost:8080/FurniturePlanner/.jsp'" style="heigh:100px">
            <b>Register new Order for an existing Client</b>
            </button-->
              <button href="#" class="btn btn-success btn-sm" data-toggle="modal" data-target="#basicModal">
                 <b>Register new Order for an existing Client</b>
              </button>

			  <div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
				aria-labelledby="basicModal" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Search Client by Name</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">�</span>
							</button>
						</div>
						<form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/SearchClient">
						<div class="modal-body">
							<div class="searchModal">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search..."
										id="searchClient" name="searchName" required> <span class="input-group-btn">
										<input type="hidden" name = "hid_cln_val" value="0">
										<!-- button class="btn btn-default" type="button"
											data-toggle="modal" data-target="#searchClientModal">Go!</button-->
									</span>
								</div>
							</div>

							<!-- %
							    String name = "Costas";
							    Client client = new Client(0,  "test",  "test",  "test",  "test",  "test",
									"test");
								//Client clnt = hm.searchForClient(0);
							    //String name = client.getName();
							    
								if ( name == null) {
							%-->

                            <!--p>The client: <!--%= name %> is not registered yet, please go back and select 
                            <b>Register new Client</b></p-->


							<!--%
								} else {
							%-->
							
							<!--div class="radio disabled">
								<label><input type="radio" name="optradio" disabled><!--%= name %>
								</label>
							</div-->
														
							<!--%
								}
							%-->

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
		</div>

    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/SearchClient">
    <div class="searchOne">
        <h3>Preview details of the client</h3>
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Insert clients name.." id="searchClient" name="searchName" required>
          <input type="hidden" name = "hid_cln_val" value="1">
          <span class="input-group-btn">
            <button class="btn btn-default" type="submit" data-toggle="modal" data-target="#searchClientModal">Go!</button>
          </span>
        </div>
    </div>
    </form>

    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/SearchOrder">
    <div class="searchTwo">
        <h3>Preview details of the order</h3>
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Insert order name.." id="searchOrder" name="searchName" required>
          <input type="hidden" name = "hid_ord_val" value="2">
          <span class="input-group-btn">
            <button class="btn btn-default" type="submit" onclick="location.href='http://localhost:8080/FurniturePlanner/searchOrder.jsp'">Go!</button>
          </span>
        </div>
    </div>
    </form>


</div>
</body>
</html>                            