<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Installments</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/installments.css"/>
<link rel="stylesheet" href="googleapis.css"/>

<script src="jquery-1.12.1.min.js"></script>

<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascripts/installments.js"></script>



</head>
<body>
   
    <div class="container">
        <div class="table-wrapper">

            <div class="table-title">
                <div class="row">
                    <!--<div class="col-sm-8"><h2><b>Installment Details for <% out.print(request.getParameter("firstName")); %></b></h2></div>-->
                    <div class="col-sm-8"><h2><b>Installment Details for:</b> Nikos Lymperopoulos</h2></div>

                </div>
            </div>
            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterOrder">
             
             
              <table class="table table-bordered">
                  <tbody>
                      <tr>
                        <td width="20%"><b><p>Installments</b></p></td>
                        <td width="40%"><b><p>Amount</p></b></td>
                        <td width="40%"><b><p>Payment method</p></b></td>
                      </tr> 
                      <tr>
                        <td width="20%" ><input type="number" class="form-control" id="num_install"></td>
                        <td width="40%" ><input type="text" class="form-control" id="amount"></td>
                        <td width="40%" id="payment">  
                            <select class="form-control" id="sel_status data-width="100%">
                              <option >select...</option>
                              <option id="card">Debit/credit card</option>
                              <option id="cash">Cash</option>
                              <option id="check">Check</option>

                            </select>
                          </td>
                      </tr>
                  </tbody>
              </table>
  
              <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
              <button type="submit" class="btn btn-success" onclick="window.location.href='http://localhost:8080/FurniturePlanner/order.jsp'">Save</button>

             </form>
        </div>
    </div> 
</body>
</html>                          