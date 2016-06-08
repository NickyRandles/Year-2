<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Exercise 3</title>
</head>

<body>
<?php
$tablet = 350;
$tax = $tablet / 100 * 20;
$quantity = 15;

echo "You purchased 15 tablets at a cost of €$tablet each." , "<br/>", "With tax, the total comes to ", ($tablet + $tax) * $quantity;
?>
</body>
</html>
