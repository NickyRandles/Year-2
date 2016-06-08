<html>
<head>
	<style>
		@import url("css/catalog.css");
	</style>
</head>
<body>
<?php
echo session_id();
if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
require_once("include/db_connect.php");
?>
<h3>
Enter a quantity or click Add an item(s) to your Shopping Cart. Click an image to view details.
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
			Price
		</th>
		<th>
			Image
		</th>
		<th>
			Quantity
		</td>
		<th>
			Add
		</th>
	</tr>
<?php
$db_link = db_connect("project");
$sessionID = session_id();
// create the SQL query
$query = "select * from cart where sessionID = $sessions";
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
			<?php echo $row["price"]; ?>
		</td>
		<?php
			$_SESSION['team'] = $row['productID'];
			$productID = $_SESSION['team'];
			echo "<td><a href='detailProduct.php?productID=".$productID."'><img src = 'images/". $row['image']. "'></a></td>";
		?>
		<td>
			<input type="text" name="quanity" size="5">
		</td>
		<td>
			<div id = "button">
			<input type="button" name="button" value="Add">
			</div>
		</td>
	</tr>
<?php
} // end loop
?>
</table>

</body>
</html>