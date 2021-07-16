<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML verification and parsing</title>

<style type="text/css">
body {
	background-color: #F5DEB3;
	margin-left: 10%;
	margin-right: 10%;
	padding: 30px 10px 10px 10px;
	font-family: sans-serif;
}
</style>

</head>
<body>
	<h1>EPAM JWD - Task 8. XML-file verification and parsing</h1>
	<h2><em>Mobile phone company tariffs</em></h2>
	<br>


	<form action="controller" method="get">
		<input type="hidden" name="validate" value="perform_validation" />
		<p>
			<strong>Please, verify the XML-file</strong>
		</p>
		<input type="submit" value="Validate" /><br />
	</form>
	<br>
	<br>
	
	<form action="controller" method="get">
		<input type="hidden" name="parce" value="SAX_parcing" />
		<p> <strong>Parse XML-file and send it to console.</strong> </p>
		<p> Please, select parser:</p>
		
		<input type="submit" value="SAX " /><br>
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="parce" value="StAX_parcing" />
		<br><input type="submit" value="StAX" /><br>
	</form>

	<form action="controller" method="get">
		<input type="hidden" name="parce" value="DOM_parcing" />
		<br><input type="submit" value="DOM" /><br>
	</form>


</body>
</html>