<html>
<head>
	<style>
		@import url("css/admin_login.css");
		@import url("css/basic.css");
	</style>
</head>
<body>
<?php
session_start();
?>
<form action = "#" method = "post">
<h1>Please enter in your login details</h1>
<table>
	<tr>
		<td>Username:</td>
		<td><input type = "text" name="username"></td>
	</tr>
		<tr>
		<td>Password:</td>
		<td><input type = "text" name="password"></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" name="button" value="Login">
			<input type="reset" name="button" value="Clear">
		</td>
	</tr>
</table>
<?php
require_once("include/db_connect.php");
if (isset($_REQUEST['button'])) // submit was clicked
{
$db_link = db_connect("project");
$username = trim($_REQUEST['username']);
$password = trim($_REQUEST['password']);
// create the SQL query
$query = "select * from users ";
// execute the query
$result = @mysql_query( $query )
or die( "Could not execute SQL query" );
// loop through all records & display in a HTML table
while ($row = mysql_fetch_array( $result) )
{
	if($username == $row["name"] && $password == $row["password"])
	{
		$_SESSION['name'] = $row['name'];
    		$name = $_SESSION['name'];
		echo "<span id=\"enter\"><a href='admin_home.php?name=".$name."'>Access granted! Press here to enter</a></span>";	
	}
	
	else
	{
		echo "<span id=\"error\">Access Denied!</span>";
	}
}
}

?>
</form>
</body>
</html>

