<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="OperacaoServlet" method="post">
		Digite o numero da conta que deseja efetuar a operação
		<br/>
		<br/>
		Numero da Conta: <input type="text" name="numeroConta"/>
		<br/>
		<br/>
		Valor: <input type="text" name="valor"/>
		<br/>
		<br/>
		Sacar: <input type="radio" name="tipoOperacao"  value="DEBITO">
		<br/>
		<br/>
		Depositar: <input type="radio" name="tipoOperacao" value="CREDITO" >	
		<br/>
		<br/>
		<input type="submit">	
	</form>
</body>
</html>