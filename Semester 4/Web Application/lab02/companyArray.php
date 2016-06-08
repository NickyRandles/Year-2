<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Exercise 3</title>
</head>

<body>
<h2>My Company Listing</h2>
<ul>
	<?php 
	$companies = array("ibm", "oracle", "ryanair", "sybase", "aerlingus", "channel4", "fox", "sky");
	foreach($companies as $company)
	{ 
		echo "<li><a href= 'http://www." .$company." .com'>" . $company.  "</a> </li>";
	}
	 ?>
	 
</ul>
</body>
</html>
