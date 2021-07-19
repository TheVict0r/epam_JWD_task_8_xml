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
	<h2>
		<em>Mobile phone company tariffs</em>
	</h2>
	<br/>
	
	<p><em>Step 1.</em> Upload the <strong>XML</strong> file</p>
	
	<form action="controller" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="uploadfile" value="XML" />
		File: <input type="file" name="file" id="file" accept=".xml"/> 
		<br /> Enter the destination folder: <input type="text" value="/folder" name="destination" />
		<br /> <input type="submit" value="Upload" name="upload" id="upload" />
	</form>
	<br/>

	
	<p><em>Step 2.</em> Upload the <strong>XSD-schema</strong> file</p>
	
	<form action="controller" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="uploadfile" value="XSD" />
		File: <input type="file" name="file" id="file" accept=".xsd"/> 
		<br /> Enter the destination folder: <input type="text" value="/folder" name="destination" />
		<br /> <input type="submit" value="Upload" name="upload" id="upload" />
	</form>


	<br />
	<form action="controller" method="get">
		<input type="hidden" name="validate" value="perform_validation" />
		<p>
			<em>Step 3.</em> <strong>Validate</strong> the XML-file
		</p>
		<input type="submit" value="Validate" /><br />
	</form>
	<br>

	<p><em>Step 4.</em> <strong>Parse</strong> XML-file and send it <strong>to console.</strong></p>
	<p>Please, select parser:</p>	
	<form action="controller" method="get">
		<input type="hidden" name="parce" value="SAX" />
		<input type="submit" value="SAX " />
	</form>

	<form action="controller" method="get">
		<input type="hidden" name="parce" value="StAX" /> <br>
		<input type="submit" value="StAX" /><br>
	</form>

	<form action="controller" method="get">
		<input type="hidden" name="parce" value="DOM" /> <br>
		<input type="submit" value="DOM" /><br>
	</form>


</body>
</html>