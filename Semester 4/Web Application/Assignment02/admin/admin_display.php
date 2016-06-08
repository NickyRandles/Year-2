<html>
<head>
	<style>
		@import url("css/admin_display.css");
	</style>	
</head>
<body>
<?php
session_start();
require_once("include/db_connect.php");
$db_link = db_connect("project");
?>
<h1>Book database display</h1>
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
		<?php echo $row["image"]?>
		</td>
	</tr>
<?php
} // end loop
?>
</table>

</body>
</html>