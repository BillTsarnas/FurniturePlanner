<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/regClient.css">
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>

<title>Order Details</title>
</head>
<body>

<div class="container">
    <div class="table-wrapper">
      <div class="row">
          <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterClient">
            <fieldset>

              <legend>Furniture App v1.0</legend>
              <div class="panel panel-default">
                <div class="panel-body">
                    Order for new User
                </div>
              </div>
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">OrderID</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="#31234" class="form-control" disabled="disabled" >
                </div>
              </div>
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">First Name</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="First Name" class="form-control" name="firstName">
                </div>
              </div>
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Last Name</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Last Name" class="form-control" name="lastName">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Address</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Address" class="form-control" name="address">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">City</label>
                <div class="col-sm-4">
                  <input type="text" placeholder="City" class="form-control" name="city">
                </div>

                <label class="col-sm-2 control-label" for="textinput">Postcode</label>
                <div class="col-sm-4">
                  <input type="text" placeholder="Postcode" class="form-control" name="postCode">
                </div>
              </div>

				<div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Country</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Country" class="form-control" name="country">
                </div>
              </div>

              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Phone</label>
                <div class="col-sm-4">
                  <input type="text" placeholder="Phone" class="form-control" name="phone">
                </div>

                <label class="col-sm-2 control-label" for="textinput">Mobile Phone</label>
                <div class="col-sm-4">
                  <input type="text" placeholder="Mobile Phone" class="form-control" name="mphone">
                </div>
              </div>

              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Email</label>
                <div class="col-sm-10">
                  <input type="text" placeholder="Email" class="form-control" name="email">
                </div>
              </div>

              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="pull-right">
                    <button type="submit" class="btn btn-default">Cancel</button>
                    <button type="button" class="btn btn-success" onclick="window.location.href='http://localhost:8080/FurniturePlanner/order.jsp'">Save</button>
                  </div>
                </div>
              </div>

            </fieldset>
          </form>
        </div>
    </div>
    </div>
</body>
</html>