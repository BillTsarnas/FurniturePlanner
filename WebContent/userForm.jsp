<%@page import="org.uniof.manchester.pattern.web.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis equipos de trabajo</title>
<link rel="STYLESHEET" type="text/css" href="css/banxico_styles.css">

</head>

<body>
	<div style="float: left; width: 14%; height: 900px; border: 1px solid #D8D8D8; background-color: #F8F8F8">
		<p class='tituloscont'>
			<a href="http://www.yahoo.com">Regresar a Webinterno</a>
		</p><br/>
			<%
				//recuperar de la sesión últimos sitios accedidos para mostrarlos en la columna izquierda
				
				User usuario = (User) request.getAttribute("user");
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getName()+"</a></p>");
				System.out.println( "Name:" + usuario.getName());
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getSurname()+"</a></p>");
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getUserId()+"</a></p>");
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getHphone()+"</a></p>");
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getMphone()+"</a></p>");
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getEmail()+"</a></p>");
				out.print("<p class='link00Blue'><a href='www.yahoo.com'>"+usuario.getAddress()+"</a></p>");
				
			%>

	</div>
	
</body>
</html>
