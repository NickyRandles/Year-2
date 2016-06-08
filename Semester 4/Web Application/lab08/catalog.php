<?php
   	session_start();		//start a session
if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
	?>




<?php require_once("include/db_connect.php"); ?>
<html>
<head><title>Displaying Image files using PHP</title></head>
<body>
<h1>Displaying Images from an Image table using PHP</h1>


<?php


// Connect to server and select a database

$db_link = db_connect("project");

// Retrieve table properties

$fields = mysql_list_fields("project", "books");
$num_columns = mysql_num_fields($fields);

// Make a simple database query to select all columns and rows

$query = "SELECT * FROM books";
$result = mysql_query($query) or die("SQL query failed");


// Display results as an HTML table. Note how mysql_field name
// uses the $fields object to extract the column names

echo '<table border="3" cellpadding = "20" >';

// Display the column names

echo "<tr>";
for ($i = 0; $i < $num_columns; $i++)
{
   echo "<th>", mysql_field_name($fields, $i), "</th>";
}
    echo "<th>Quantity</th>";    
    echo "<th>Add</th>";
echo "</tr>";

// Loop over the rows of the table.
// $row contains the information for each row
// Refer to the names of the fields in the table
// Must ahow the path where the image files are held
 
while ($row = mysql_fetch_assoc($result))
{  
   $_SESSION['team'] = $row['isbn'];
    $isbn = $_SESSION['team'];
   echo "<tr>";
   echo "<td>". $row['isbn']. "</td>";
   echo "<td>". $row['title']."</td>";
   echo "<td>". $row['author']. "</td>";
   echo "<td>". $row['pub']."</td>"; 
   echo "<td>". $row['year']. "</td>";
   echo "<td>". $row['price']."</td>";    
   echo "<td><a href='detailBook.php?isbn=".$isbn."'><img src = 'images/". $row['image']. "'></a></td>";

   echo "<td><form><input type='text' name='quantity' value='1' size='2'></form></td>";
   echo "<td><form><input type='Button' name='add' value='add'></form></td>";
}

 echo "</tr>";
echo "</table>";
   echo  session_id() ;

// Free the resources and close the connection

mysql_free_result($result);
mysql_close($db_link);
?>
