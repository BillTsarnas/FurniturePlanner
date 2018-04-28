<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
    import="org.uniof.manchester.pattern.web.Piece"
    import="org.uniof.manchester.pattern.web.Furniture"
    import="org.uniof.manchester.pattern.web.Order"
    import="org.uniof.manchester.pattern.web.Box"
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

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>

<body>


<form class="form-horizontal" role="form" method="post" action="">

  <% 
    //Order
    Order order = (Order) request.getAttribute("order");
    
    //Client
    Client cln_obj = (Client) request.getAttribute("client");
    int st = order.getStatus();

    String status = "";
    
    if (st == 1) {
    	status = "Active";
    }else {
    	status = "Offer";
    }
    
	//set up furniture list
	ArrayList<Furniture> furList = order.getFurnitures();
	//set up furniture iterator
	Iterator<Furniture> furnIt = furList.iterator();
	
	//set up box list
	ArrayList<Box> boxList = new ArrayList<Box>();
	//set up box iterator
	Iterator<Box> boxIt;
	
	//set up piece list
	ArrayList<Piece> pieceList = new ArrayList<Piece>(); 
	//set up piece iterator
	Iterator<Piece> pieceIt;
  %>
  
  <div class="container">
  <h1>Preview of order</h1>
  <div class="col-xs-6">
  
            <table class="table">
              <thead>
                <tr>
                  <th class="col-md-1">Name</th>
                  <th class="col-md-1">Surname</th>
                  <th class="col-md-2">Order name</th>
                  <th class="col-md-3">Order status</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="col-md-1"><%out.print(cln_obj.getName()); %></td>
                  <td class="col-md-1"><%out.print(cln_obj.getSurname()); %></td>
                  <td class="col-md-2"><%out.print(order.getName()); %></td>
                  <td class="col-md-3"><%out.print(order.getStatus()); %></td>
                </tr>

              </tbody>
            </table>
        
  </div>
  <div class="col-xs-6">
    
            <table class="table">
              <thead>
                <tr>
                  <th class="col-md-1">Installments</th>
                  <th class="col-md-2">Amount</th>
                  <th class="col-md-3">Payment</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="col-md-1">4</td>
                  <td class="col-md-2">1.000</td>
                  <td class="col-md-3">Cash</td>
                </tr>
              </tbody>
            </table>
  </div>
  </div>
<div class="container">

        <% 
        double temp_h = 0;
        double temp_w = 0;
        while (furnIt.hasNext()) {

			Furniture currF = furnIt.next();
			boxList = currF.getBoxes();
 			boxIt = boxList.iterator();
        %>
        <details>
           <summary>Furniture #<%out.print(currF.getName()); %></summary>
           <% 
           while (boxIt.hasNext()) {

				Box currB = boxIt.next();
				pieceList = currB.getPieces();
				pieceIt = pieceList.iterator();
				
				
           %>
           <table class="table table-bordered">
              <thead>
              <th scope="row" style="color:green;"><%out.print(currB.getName()); %></th>
                 <tr>
                    <td><b>Number of Pieces</b></td> 
                    <td><b>Height</b></td> 
                    <td><b>Width</b></td> 
                    <td><b>Material</b></td> 
                    <td><b>Colour</b></td> 
                    <td><b>Thickness</b></td> 
                 </tr>
              </thead>
              <tbody>
              <% 
              boolean typeNum = false;
              while (pieceIt.hasNext()) {

	 				Piece currP = pieceIt.next();
	 				
					//
					
					if ( temp_h == currP.getHeight() ){
						if ( temp_w == currP.getHeight() ){
							typeNum = true;							
						}
					}
					temp_h = currP.getHeight();
					temp_w = currP.getHeight();
              
              
              %>
                 <tr>
                    <td>to_fulfill</td>
                    <td><%out.print(currP.getHeight()); %></td> 
                    <td><%out.print(currP.getWidth()); %></td> 
                    <td><%out.print(currP.getMaterial().getName()); %></td> 
                    <td><%out.print(currP.getColour()); %></td>  
                    <td><%out.print(currP.getThickness()); %></td> 
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
           <p><%out.print(order.getTotalcost()); %>&pound;;</p>
        </div>
        
        <button type="submit" class="btn btn-danger" style="float: left;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
        <button type="button" class="btn btn-success" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Next</button>
        <button type="submit" class="btn btn-primary" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/installments.jsp'">Set new installment</button>
        
           
</div>    
</form>
</body>
</html>