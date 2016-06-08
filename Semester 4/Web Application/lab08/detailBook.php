<?php
session_start();
require_once("include/db_connect.php");
$db_link = db_connect("project");

$isbn = $_REQUEST['isbn'];
$query = "SELECT * FROM books WHERE isbn = '$isbn'";

$result = mysql_query($query);
?>
<html><head></head>
<body>
<form action='updateCart.php' method = 'post'>
<table border = "4">
<?php

$self = $_SERVER['PHP_SELF'];
$sessionid = session_id();
$fields = mysql_list_fields("project", "books");
$num_columns = mysql_num_fields($fields);
$result = mysql_query($query) or die ("Query could not be executed");

if ($row = mysql_fetch_assoc($result)) {
	$title = $row['title'];
	$author =$row['author'];
	$price = $row['price'];
	$pub = $row['pub'];
	$isbn = trim($row["isbn"]); 
	
echo "<tr>";
echo "<td rowspan = '4'><img src='images/". $row['image']. "'></td>";
echo "<td><strong>Title:</strong>". $title. "</td>";
echo "</tr>";
echo "<tr>";
echo "<td><strong>author:</strong>". $author. "</td>";
echo "</tr>";
echo "<tr>";
echo "<td><strong>price:</strong>". $price. "</td>";
echo "</tr>";
echo "<td><strong>Publisher:</strong>". $pub. "</td>";
}
else
echo "<font color=red>Error! details". $isbn ."not found in database!";
?>
<input type = "text" name="quantity" value = "1" size="3">
<input type = "submit" name = "add" value="add">
<input type = "hidden" name = "isbn" value = "<?php echo $isbn?>">
<input type = "hidden" name = "price" value = "<?php echo $price?>">
</form>
</table>
</body>
</html>