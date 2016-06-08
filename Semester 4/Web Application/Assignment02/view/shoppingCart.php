<html>
<head>
	<style>
		@import url("css/shoppingCart.css");
	</style>
</head>
<body>
<?php
session_start();
$session = session_id();
if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
require_once("include/db_connect.php");
?>
<h3>
Contents of shopping cart
</h3>
<table border = "1" cellpadding = "10">
<tr>
		<th>
			Product ID
		</th>
		<th>
			Title
		</th>
		<th>
			Developer
		</th>
		<th>
			Year
		</th>
		<th>
			Quantity
		</th>
		<th>
			Price
		</th>
		<th>
			Subtotal
		</th>
		<th>
			Quantity
		</td>
		<th>
			Update
		</th>
	</tr>
<?php
$db_link = db_connect("project");
// create the SQL query
$query = "SELECT * FROM cart WHERE sessionID = '$session'";
// execute the query
$result = @mysql_query( $query )
or die( "Could not execute SQL query" );
// loop through all records & display in a HTML table
while ($row = mysql_fetch_array( $result) )
{
?>
	<tr>
		<td>
			<?php echo $row["productID"]; ?>
		</td>
		<td>
			<?php echo $row["title"]; ?>
		</td>
		<td>
			<?php echo $row["developer"]; ?>
		</td>
		<td>
			<?php echo $row["year"]; ?>
		</td>
		<td>
			<?php echo $row["quantity"]; ?>
		</td>
		<td>
			<?php echo $row["price"]; ?>
		</td>
		<td>
			<?php echo $row["price"] * $row["quantity"]; ?>
		</td>
		<td>
			<input type="number" name="quanity" min="1" max="100">
		</td>
		<td>
			<div id = "button">
			<input type="button" name="button" value="Update">
			</div>
		</td>
	</tr>
<?php
} // end loop
?>
</table>
<p><a href = "catalog.php">Continue Shopping</a></p>
<p><a href = "checkout.php">Checkout Now</a></p>
</body>
</html>