<html>
<head>
	<style>
		@import url("css/admin_insert.css");
	</style>
</head>
<body>
<?php
if (isset($_REQUEST['button'])) // submit was clicked
{
   add();
}
else
{
}
session_start();
$session = session_id();
if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
require_once("include/db_connect.php");
$db_link = db_connect("project");

   $productID = isset($_REQUEST['productID']) ? $_REQUEST['productID'] : '';
   $title = isset($_REQUEST['title']) ? $_REQUEST['title'] : '';
   $developer = isset($_REQUEST['developer']) ? $_REQUEST['developer'] : '';
   $year = isset($_REQUEST['year']) ? $_REQUEST['year'] : '';
   $price = isset($_REQUEST['price']) ? $_REQUEST['price'] : '';  
   $image = isset($_REQUEST['image']) ? $_REQUEST['image'] : '';  
?>

<form action="#" method="POST">
<h3>Please fill out the details of the game your adding</h3>
<table>
	<tr>
		<td>Product ID: </td>
		<td><input class="input" type="text" name="productID" value="<?php echo $productID ?>"></td>
	</tr>
	<tr>
		<td>Title: </td>
		<td><input class="input" type="text" name="title" value="<?php echo $title ?>"></td>
	</tr>
	<tr>
		<td>Developer:</td>
		<td><input class="input" type="text" name="developer" value="<?php echo $developer ?>"></td>
	</tr>
	<tr>
		<td>Year:</td>
		<td><input class="input" type="text" name="year" value="<?php echo $year ?>"></td>
	</tr>
	<tr>	
		<td>Price:</td>
		<td><input class="input" type="text" name="price" value="<?php echo $price ?>"></td>
	</tr>
	<tr>	
		<td>Image:</td>
		<td><input class="input" type="text" name="image" value="<?php echo $image ?>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="button" value="Insert">
		<input type="reset" name="button" value="Reset"></td>
	</tr>
</table>
</form>
</body>
</html>

<?php
function add()
{
   $productID = trim($_REQUEST['productID']);
   $title = trim($_REQUEST['title']);
   $developer = trim($_REQUEST['developer']);
   $year = trim($_REQUEST['year']);
   $price = trim($_REQUEST['price']);
   $image = trim($_REQUEST['image']);

	$sql = "INSERT INTO products(productID, title, developer, year, price, image) VALUES ('$productID', '$title','$developer', $year, 				$price,'$image')";
	$res = mysql_query($sql)or die ("could not be inserted");
}
?>



