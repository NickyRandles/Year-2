<html>
<head>
	<style>
		@import url("css/index.css");
	</style>
</head>
<body>
<?php
session_start();
if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
require_once("include/db_connect.php");



?>
<h1>
Welcome to the official GameStop webiste.
</h1>

<h3>
Check out this weeks most popular games
</h3>

<?php
$db_link = db_connect("project");
// create the SQL query
$query = "select * from products order by rand() limit 3";
// execute the query
$result = @mysql_query( $query )
or die( "Could not execute SQL query" );
// loop through all records & display in a HTML table
while ($row = mysql_fetch_array( $result) )
{
?>
<table border = "1" cellpadding = "10">
	<tr>
		<?php
		   $_SESSION['team'] = $row['productID'];
    		$productID = $_SESSION['team'];
	    	echo "<td><a href='detailProduct.php?productID=".$productID."'><img src = 'images/". $row['image']. "'></a></td>";
			?>

	</tr>
	<tr>
		<td>
		<strong>Title:</strong>
		<?php 
		echo $row["title"]; ?>
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
		<strong>Price:</strong>
		<?php 
		echo $row['price']; 
		
		?>
		</td>
	</tr>
	
</table>
<br>
<?php
} // end loop
?>


</body>
</html>