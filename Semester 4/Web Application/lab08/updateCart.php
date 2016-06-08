<?php
	session_start();
	require_once("include/db_connect.php");
	$db_link = db_connect("project");

	$isbn = trim($_REQUEST['isbn']);
	$price= $_REQUEST['price'];
	$quantity=trim($_REQUEST['quantity']);
    $session_id = session_id();


   echo $price;
   echo "<br>";
   echo $isbn;
   echo "<br>";
   echo $quantity;
   echo "<br>";
   echo $session_id;
   
   
   $query = "INSERT INTO carts(session_id, isbn, quantity, price) VALUES ('$session_id', '$isbn','$price', '$quantity',)";
   
   $result= mysql_query($query)or die ("could not be inserted");
  
   

?>