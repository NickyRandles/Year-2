<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Employment Registration</title>
<style>
form
{
	background-color: cyan;
	border: 2px solid gray;
}

label
{	display: block;
	color: blue;
	width: 100px;
	float: left;
}

#mandatory
{
	color: red;
	font-weight: bold;
}
</style>
</head>

<body>
<form action = "<?php echo $self ?>" method = "POST">
<h1>
Employment Registration Form
</h1>
<table>
<tr>
<td>
<label>First Name:</label>
</td>
<td>
	<input type = "text" name = "firstName">
</td>
</tr>
<label>Surname:</label>
	<input type = "text" name = "surname">
<label>Password:</label>
	<input type = "password" name = "password"><span id = "mandatory">(Mandatory)</span>
<label>Sex:</label>
	 Male:<input type = "radio" name = "sex" value = "male"> Female: <input type = "radio" name = "sex" value = "female" checked = "checked">
<label>Hobbies</label>
	Sailing:<input type = "checkbox" name = "hobbies[]" value = "sailing">
	PHP:<input type = "checkbox" name = "hobbies[]" value = "php">
	Painting:<input type = "checkbox" name = "hobbies[]" values = "painting" checked = "checked">.
<label>Country of Origin:</label> 
	<select name = "origin">
	<option>USA</option>
	<option>IRL</option>
	<option>Other</option>
	</select>
<label>Countr(y)(ies) of Residence</label>	
	<select name = "origin" size = "4">
	<option>UK</option>
	<option>USA</option>
	<option>IRL</option>
	<option>Other</option>
	</select>
<label>Work Experience</label>
	<textarea rows = "5" cols = "20" wrap = "physical" name = "experience">
	</textarea>
		
<input type = "submit" name = "button" value = "Submit">
<input type = "reset" name = "button" value = "Reset">
</form>
</body>
</html>
