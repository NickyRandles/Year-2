<?php
session_start();
require_once("include/db_connect.php");
$db_link = db_connect("project");

$productID = $_REQUEST['productID'];
$query = "SELECT * FROM products WHERE productID = '$productID'";

$result = mysql_query($query);
if(isset($_POST['button']))
{
enter();
}
$quantity = isset($_REQUEST['quantity']) ? $_REQUEST['quantity'] : '';
?>
<html>
<head>
	<style>
		@import url("css/index.css");
	</style>
</head>
<body>
<form action="#" method="POST">

<table border = "4">

<?php

$result = mysql_query($query) or die ("Query could not be executed");

while ($row = mysql_fetch_array( $result) )
{
?>	
<table border = "1" cellpadding = "10">
	<tr>
	   <td><img src = './images/<?php echo $row["image"]?>'></td>
	</tr>
	<tr>
		<td>
		<strong>Product ID:</strong>
		<?php echo $row["productID"];?>
		</td>
	</tr>
	<tr>
		<td>
		<strong>Title:</strong>
		<?php 
		echo $row["title"];
		 ?>
		</td>
	</tr>
	<tr>
		<td>
		<strong>Developer:</strong>
		<?php echo $row["developer"]; ?>
		</td>
	</tr>
	<tr>
		<td>
		<strong>Year:</strong>
		<?php echo $row["year"]; ?>
		</td>
	</tr>
	<tr>
		<td>
		<strong>Price:</strong>
		<?php echo $row["price"];
		?>
		</td>
	</tr>
	<tr>
		<td>
		<strong>Quantity:</strong>
		<input type="number" name="quantity" min = "1" max = "100" value="<?php echo $quantity ?>">
		</td>
	</tr>
		<tr>
		<td>
		<input type="submit" name="button" value="Add">
		</td>
	</tr>	
<?php	
?>
</table>
<?php
}
?>
</form>
</body>
</html>
<?php
function enter()
{

$productID = $_REQUEST['productID'];
$sql1= "SELECT * FROM products WHERE productID = '$productID'";

$res1 = mysql_query($sql1);

$res1 = mysql_query($sql1) or die ("Query could not be executed");

while ($row = mysql_fetch_array( $res1) )
{
$sessionID = session_id();
$name = $row["title"];
$price = $row["price"];
$developer = $row["developer"];
$year = $row["year"];
$quantity = trim($_REQUEST['quantity']);
$price = $row["price"];

$sql = "INSERT INTO cart(productID, sessionID, title, developer, year, quantity, price, subtotal) VALUES ('$productID', '$sessionID','$name', '$developer', '$year','$quantity', '$price', '0')";
$res = mysql_query($sql)or die ("could not be inserted");
}

}
?>