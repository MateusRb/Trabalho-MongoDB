<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CadastroServlet" method="post">
		<br/> Nome:<input type="text" name="nome" required="required"/>
		<br/> 
		<br/> CPF:<input type="text"name="cpf"  required="required"/> 
		<br/> 
		<br/> Renda:<input type="text" name="renda"  required="required"/> 
		<br/> 
		<br/> Número da Conta:<input type="text" name="numeroConta"  required="required"/> 
		<br/> 
		<br/> <input type="submit" value="Enviar"/>
		<br/>
	</form>

</body>
</html>