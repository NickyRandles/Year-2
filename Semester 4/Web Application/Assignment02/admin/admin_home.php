<html>
<head>
</head>
<body>
<?php
session_start();
require_once("include/db_connect.php");
$db_link = db_connect("project");

$name = $_REQUEST['name'];
?>
<h1>Gamestop Database Adminstration</h1>
<p>
Welcome to the database administration area <?php echo $name?>
</p>
</body>
</html>