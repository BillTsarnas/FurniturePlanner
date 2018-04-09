<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="css/searchPage.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="jquery-1.12.1.min.js"></script>

<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascript/searchPage.js"></script>


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
            <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">New</button>

              <!-- Modal -->
              <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                
                  <!-- Modal content-->
                  <div class="modal-content">
    
                    <div class="modal-body">
                        <h3>Please give client's name</h3>
                        <div class="input-group">
                          <input type="text" class="form-control" placeholder="Search..." id="searchOrder">
                          <span class="input-group-btn">
                            <button class="btn btn-default" onclick="searchNames()" type="button">Search</button>
                          </span>


                        </div>

                        <div id="target"></div>

                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-success" data-dismiss="modal">Save</button>
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
            <button class="btn btn-default" type="button">Go!</button>
          </span>
        </div>
    </div>

    <div class="searchTwo">
        <h3>Search for Order</h3>
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search..." id="searchOrder">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button">Go!</button>
          </span>
        </div>
    </div>



</body>
</html>                            