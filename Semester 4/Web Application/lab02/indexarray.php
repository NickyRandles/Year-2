<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Exercise 1</title>
</head>
<body>
<!-- a)	Use print_r() to display the contents of the array. -->
<h2>Display array using print_r()</h2>
<?php
$extraToppings = array("mushrooms", "anchovies", "chocolate");
print_r($extraToppings);
?>

<!-- b)	Sort the array in ascending sequence. -->
<h2>Sort the array and print using print_r()</h2>
<?php
sort($extraToppings);
print_r($extraToppings);
?>
<!-- C) Use a foreach loop to display all the items in the array as a bulleted list. -->
<h2>Use foreach loop to display items in the array as a bulleted list</h2>
<ul>
  <?php foreach($extraToppings as $extraTopping){ ?>
  <li><?php echo $extraTopping; ?></li>
  <?php } ?>
</ul>

</body>
</html>
