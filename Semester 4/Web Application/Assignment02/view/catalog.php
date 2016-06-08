<html>
<head>
	<style>
		@import url("css/catalog.css");
	</style>
</head>
<body>
<?php
session_start();

if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
require_once("include/db_connect.php");
if(isset($_POST['add']))
{
enter();
}
?>
<h3>
Enter a quantity or click Add an item(s) to your Shopping Cart. Click an image to view details.
</h3>
<form action="" method="POST">
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
// create the SQL query
$query = "select * from products";
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
		<td>
		<img src = './images/<?php echo $row["image"]?>'>
		</td>
		<td>
		<input type="number" name="quantity" min = "1" max = "100" value="<?php echo $quantity ?>">
		</td>
		<?php
		   $_SESSION['team'] = $row['productID'];
    		$productID = $_SESSION['team'];
	    	echo "<td><a href='detailProduct.php?productID=".$productID."'>Add</a></td>";
			?>
	</tr>
<?php
} // end loop
?>
</table>
</form>
</body>
</html>

<?php
function enter()
{

$productID = $_REQUEST['team'];
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