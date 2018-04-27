<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
    import="org.uniof.manchester.pattern.web.Order"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Available Orders</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>
<link rel="stylesheet" href="css/searchOrder.css"/>

<script src="jquery-1.12.1.min.js"></script>

<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascript/searchOrder.js"></script>


</head>
<body>

<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2><b>List of the Available orders under name "<% out.print(request.getParameter("searchName")); %>"</h2></div>
                    <!-- div class="labelAvail"><h2><b>Client:</b> Nikos Oikonomou</h2></div-->
                </div>
            </div>
            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/ForwardOrder">
            <table class="table table-bordered">
                <tbody>
                <!--% 
                    ArrayList<String> list = (ArrayList<String>) request.getAttribute("nameList");
                	Iterator<String> crunchifyIterator = list.iterator();
                	while (crunchifyIterator.hasNext()) {
                %-->
                <% 
                    ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("orderList");
                	Iterator<Order> crunchifyIterator = list.iterator();
                	while (crunchifyIterator.hasNext()) {
                		Order curr = crunchifyIterator.next();
                	
                %>
                    <tr>
                        <td width="90%">
                            <label class="radio"><%out.print(curr.getName()); %>
                                <input type="radio" checked="checked" name="orderIdName" value="<%out.print(curr.getOrderID());%>">
                                <span class="checkround"></span>
                            </label>
                        </td> 
                    </tr> 
					
                    <%} %>
                  
                </tbody>
            </table>
            
            <input type="hidden" name = "hid_ord_flag" value="${ord_val}">
            <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Back</button>
            <button type="submit" class="btn btn-success">Save</button>
			</form>
        </div>
    </div> 

</body>
</html>                            