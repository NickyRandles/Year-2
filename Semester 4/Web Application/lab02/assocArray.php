<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Exercise 2</title>
</head>

<body>
<!-- a)	Use print_r() to display the values in the $prices array. -->
<h2>Display array using print_r()</h2>
<?php
$prices = array( 'Apples' => 2.50, 'Pears' => 3.50, 'Oranges' => 4.50, 'Strawberries' => 5.50);
print_r($prices);
?>

<!-- b)	Display the price of some fruit, as follows: The price of the fruit must come from the array -->
<h2>Display the price of some fruit</h2>
<?php
echo "Apples cost: ", '&euro;', number_format($prices['Apples'], 2), "<br/>";
echo "Pears cost: ", '&euro;', number_format($prices['Pears'], 2), "<br/>";
echo "Oranges cost: ", '&euro;', number_format($prices['Oranges'], 2), "<br/>";
echo "Strawberries cost: ", '&euro;', number_format($prices['Strawberries'], 2);
?>

<!-- c)	Using a TABLE, display the prices of all of the fruit. All the data in the table must come from the array. Use a foreach loop which accesses the keys and the values in the array. -->
<h2>Display fruit and price in table</h2>
<table border = "1">
	<tr>
		<th>Fruit</th>
		<th>Price</th>
	</tr>
<?php foreach($prices as $key => $value){ ?>
	<tr>
		<td><?php echo $key; ?></td>
		<td><?php echo '&euro;', number_format($value, 2); ?></td>
	</tr>
<?php } ?>



</body>
</html>
