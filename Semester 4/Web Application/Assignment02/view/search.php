<html>
<head>
	<style>
		@import url("css/search.css");
	</style>
</head>
<body>
<?php
require_once("include/db_connect.php");


?>
<form action = "#" method = "post">
<h1>Search for an item</h1>
<div id = "searchBar">
<input type = "text" name="search" size = "40" maxlength="50">
<input type="submit" name="button" value="Search">
<input type="reset" name="button" value="Clear">
</div>
</form>
<?php
if (isset($_REQUEST['button'])) // submit was clicked
{
   results();
 }
else // display form for first time
{
}
?>
</body>
</html>
<?php
function results(){
	$search = trim($_REQUEST['search']);
?>

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
$query = "select * from products where title like '%$search%'";
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
}
?>