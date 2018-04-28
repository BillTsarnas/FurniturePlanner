<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
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

  <div class="container">
  <h1>Preview of order</h1>
  <div class="col-xs-6">
  
            <table class="table">
              <thead>
                <tr>
                  <th class="col-md-1">Name</th>
                  <th class="col-md-1">Lastname</th>
                  <th class="col-md-2">Order name</th>
                  <th class="col-md-3">Order status</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="col-md-1">Constantinos</td>
                  <td class="col-md-1">Lebesis</td>
                  <td class="col-md-2">#lebes_order</td>
                  <td class="col-md-3">Active</td>
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
<form class="form-horizontal" role="form" method="post" action="">



  <% 
    //Order
    Order ord_obj = (Order) request.getAttribute("order");
    
    //Client
    Client cln_obj = (Client) request.getAttribute("client");
    int st = ord_obj.getStatus();

    String status = "";
    
    if (st == 1) {
    	status = "Active";
    }else {
    	status = "Offer";
    }
    
    //Furnitures
    ArrayList<Furniture> frn_obj = (ArrayList<Furniture>) request.getAttribute("furniture");
	System.out.println("Furnitures:");
	Iterator<Furniture> crunchifyIterator = frn_obj.iterator();
	ArrayList<String> furnIdList = new ArrayList<String>();
	while (crunchifyIterator.hasNext()) {
		Furniture curr = crunchifyIterator.next();
		furnIdList.add(curr.getName());
		//System.out.println(curr.getName());
	}
	
	//Boxes
	ArrayList<String> box_obj = (ArrayList<String>) request.getAttribute("box_list");
	Iterator<String> crunchifyIteratorBox = box_obj.iterator();
	//Araaylists of each value
	//+curr.getColour()+" "+curr.getDepth()+" "+curr.getDoor_colour()+" "+curr.getHeight()+" "+curr.getWidth());
	ArrayList<String> boxNameList = new ArrayList<String>();
	ArrayList<String> thicknessList = new ArrayList<String>();
	ArrayList<String> colourList = new ArrayList<String>();
	ArrayList<String> depthList = new ArrayList<String>();
	ArrayList<String> door_colourList = new ArrayList<String>();
	ArrayList<String> heightList = new ArrayList<String>();
	ArrayList<String> widthList = new ArrayList<String>();
	while (crunchifyIteratorBox.hasNext()) {
		String curr = crunchifyIteratorBox.next();
		String[] to_split = curr.split(",");
		boxNameList.add(to_split[0]);
		thicknessList.add(to_split[1]);
		colourList.add(to_split[2]);
		depthList.add(to_split[3]);
		door_colourList.add(to_split[4]);
		heightList.add(to_split[5]);
		widthList.add(to_split[6]);	
		/*
		System.out.println("boxNameList"+boxNameList + "size="+boxNameList.size());
		System.out.println("thicknessList"+thicknessList + "size="+thicknessList.size());
		System.out.println("colourList"+colourList + "size="+colourList.size());
		System.out.println("depthList"+depthList + "size="+depthList.size());
		System.out.println("door_colourList"+door_colourList + "size="+door_colourList.size());
		System.out.println("heightList"+heightList + "size="+heightList.size());
		System.out.println("widthList"+widthList + "size="+widthList.size());*/
		//System.out.println(to_split[0]);
	}
	
  %>

  
        <% 
        for (int i=0; i< furnIdList.size(); i++) {
        %>
        <details>
           <summary>Furniture #<%out.print(furnIdList.get(i)); %></summary>
           <% 
           for (int j=0; j< boxNameList.size(); j++) {
           %>
           <table class="table table-bordered">
              <thead>
              <th scope="row" style="color:green;"><%out.print(boxNameList.get(j)); %></th>
                 <tr>
                    <td><b>Number of Pieces</b></td> 
                    <td><b>Height</b></td> 
                    <td><b>Width</b></td> 
                    <td><b>Depth</b></td> 
                    <td><b>Material</b></td> 
                    <td><b>Colour</b></td> 
                    <td><b>Thickness</b></td> 
                 </tr>
              </thead>
              <tbody>
              <% 
              //for (int s=0; s<= 2; s++) {
              %>
                 <tr>
                    <td>4</td> 
                    <td><%out.print(heightList.get(j)); %></td> 
                    <td><%out.print(widthList.get(j)); %></td> 
                    <td><%out.print(depthList.get(j)); %></td> 
                    <td><%out.print(colourList.get(j)); %></td> 
                    <td>TEST</td> 
                    <td><%out.print(thicknessList.get(j)); %></td> 
                 </tr> 
              </tbody>
              <%
              //} 
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
           <p>3000.30&euro;</p>
        </div>
        
        <button type="submit" class="btn btn-danger" style="float: left;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
        <button type="button" class="btn btn-success" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Next</button>
        <button type="submit" class="btn btn-primary" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/installments.jsp'">Set new installment</button>
        
           
</div>    
</form>
</body>
</html>