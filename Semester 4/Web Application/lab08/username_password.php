<?php
//
// Program asks the user to enter 2 pieces of data - firstname and email address
// It accepts the input and searches a database for matching records
// It displays the matching records in a table, if they exist
// Otherwise, it displays an error message

// This program could be modified to ask a user to enter their username & password
// and search a user table to see if they were registered

require_once("include/db_connect.php");
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
		<title>Search the users table</title>
			<style type="text/css">
				.error { color: #ff0000 }
			</style>
</head>
<body>

<h1>Search the users table using PHP</h1>


<?php

// Connect to server and select a database --- Call the function db_connect() in db_connect(External File)

    $db_link = db_connect("project");
    $self = $_SERVER['PHP_SELF'];
	if (isset($_POST['Submit']))
	{
		$username = trim(isset($_REQUEST['username'])) ? $_REQUEST['username'] : '';
	    $password = trim(isset($_REQUEST['password'])) ? $_REQUEST['password'] : '';

		$query = "SELECT * FROM users WHERE username = '$username'"
		         ." AND password = '$password'";
		// echo $query. "<p>";

		$result = mysql_query($query);



// If a match exists (my_sql_num rows function > 0,
	if (mysql_num_rows($result) > 0)
		{
		 echo "You are now logged on";
		}
// Else -- State there are no records

		else
		{
			echo 'You are not logged on';
		}
		mysql_close();
	}
else // if have not clicked on submit button
	{
?>
<h2>Please Enter Your UserName And Password Please</h2>

<form action= "<?php echo $self ?>"method="post" >
User Name :	<input name = "username" type="text"><br>
Password: <input  name = "password" type="text"><br>
<input type="submit" name="Submit" value="Submit">

</form>

<?php
	}
?>