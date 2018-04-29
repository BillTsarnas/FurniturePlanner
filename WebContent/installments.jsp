<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.uniof.manchester.pattern.web.Order"
    import="org.uniof.manchester.pattern.web.Client"%>
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
   
   <% 
    //Order id
    Order order = (Order) request.getAttribute("order");
    
    //Client id 
    Client client = (Client) request.getAttribute("client");
    
    //current number of installments
    String numInst = (String) request.getAttribute("numInst");
    
    %>
   
    <div class="container">
        <div class="table-wrapper">

            <div class="table-title">
                <div class="row">
                    <!--<div class="col-sm-8"><h2><b>Installment Details for <% out.print(request.getParameter("firstName")); %></b></h2></div>-->
                    <div class="col-sm-8"><h2><b>Installment Details</b></h2>
                    <h4>Order Name: <% out.print(order.getName()); %></h4>
                    <h4>Order Id: <% out.print(order.getOrderID()); %></h4>
                    <h4>Client Name: <% out.print(client.getName()); %> <% out.print(client.getSurname()); %></h4>
                    <h4>Client Id: <% out.print(client.getClientId()); %></h4>
                    </div>

                </div>
            </div>
            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterInstallment">
             
             
              <table class="table table-bordered">
                  <tbody>
                      <tr>
                        <td width="34%"><b><p>Installment number</b></p></td>
                        <td width="33%"><b><p>Amount</p></b></td>
                        <td width="33%"><b><p>Payment method</p></b></td>
                      </tr> 
                      <tr>
                        <td width="34%" ><input type="text" value="<% out.print(Integer.parseInt(numInst+1)); %>" class="form-control" id="num_install" disabled></td>
                        <td width="33%" ><input type="text" class="form-control" id="amount" name="amount" required></td>
                        <td width="33%" id="payment">  
                            <select class="form-control" id="sel_status data-width="100%" name="payMethod">
                              <option >select...</option>
                              <option id="card">Debit/Credit card</option>
                              <option id="cash">Cash</option>
                              <option id="check">Check</option>

                            </select>
                          </td>
                      </tr>
                  </tbody>
              </table>
  			  <input type="hidden" name = "orderId" value="<% out.print(order.getOrderID()); %>">
              <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
              <button type="submit" class="btn btn-success">Save</button>

             </form>
        </div>
    </div> 
</body>
</html>                          