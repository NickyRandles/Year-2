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

$query = "SELECT * from books order by rand() limit 3";
$result = mysql_query($query) or die("SQL query failed");


// Display results as an HTML table. Note how mysql_field name
// uses the $fields object to extract the column names


// Display the column names

// Loop over the rows of the table.
// $row contains the information for each row
// Refer to the names of the fields in the table
// Must ahow the path where the image files are held
$isbn = "Isbn";
$author="Author";
$price="Price";
while ($row = mysql_fetch_assoc($result))
{
echo '<table border="3">';

	echo"<tr >";
		echo"<th rowspan='30'> <img src = 'images/". $row['image']. "'></th>";
   echo "<td>".$isbn.": ". $row['isbn']. "</td>";		
   echo "</tr>";

   echo"<tr>";
            echo "<td>".$author.": ". $row['author']. "</td>";
	echo"<tr>";

   echo"<tr>";
        echo "<td>".$price.": ". $row['price']."</td>";    
   echo"<tr>";
echo "</table>";

}



// Free the resources and close the connection

mysql_free_result($result);
mysql_close($db_link);
?>
