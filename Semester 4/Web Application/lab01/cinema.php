<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Exercise 4</title>
</head>

<body>
<?php
$filmName = "Minority Report";
$cinema = "Blue Screen Mulitplex";
$screenNumber = 5;
$ticketCost = 7.50;
$todaysDate = date("l F d, Y");

echo "The film <b>$filmName</b> is showing in the <b>$cinema</b> on <b>$todaysDate</b>", "<br/><br/>";

echo "ScreenNumber : <b>$screenNumber</b>", "<br/><br/>";

echo "Tickets cost <b>$ticketCost</b> each";

?>
</body>
</html>
