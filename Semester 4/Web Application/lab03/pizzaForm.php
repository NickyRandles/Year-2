<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>

</head>

<body>
 <img src="pizza.jpg" width="400" height="44">
 <br />
<?php
	$name = $_REQUEST['name'];	
	$crust = $_REQUEST['crust'];
	$toppings = $_REQUEST['toppings'];
	$comments = $_REQUEST['comments'];
	
	if($name != null)
	{
		echo ("Thanks for your selection $name <hr>");
	}
	
	if(($crust != null) && ($toppings != null))
	{
		echo "You placed the following order for a Pizza: <br>";
		echo "<b>Crust :</b>", $crust, "<br>";
		echo "<b>Toppings/(s)</b> <br>";
		
		if (is_array($toppings))
		{
			foreach($toppings as $topping)
			{
				echo "<li>$topping</li>";
			}
		}
	}

	if($comments != null)
	{
		echo "<b>Comments</b> <br/> $comments";
	}


?>
</body>
</html>
