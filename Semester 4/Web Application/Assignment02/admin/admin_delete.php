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
   delete();
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
?>

<form action="#" method="POST">
<h3>Please enter the id of the product you want to delete</h3>
<table>
	<tr>
		<td>Product ID: </td>
		<td><input class="input" type="text" name="productID" value="<?php echo $productID ?>"></td>
	</tr>

	<tr>
		<td></td>
		<td><input type="submit" name="button" value="Delete">
		<input type="reset" name="button" value="Reset"></td>
	</tr>
</table>
</form>
</body>
</html>

<?php
function delete()
{
   $productID = trim($_REQUEST['productID']);

	$sql = "Delete from products where productID = '$productID'";
	$res = mysql_query($sql)or die ("could not be inserted");
}
?>



