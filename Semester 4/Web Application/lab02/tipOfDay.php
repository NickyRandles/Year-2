<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
<h2>Tip of the Day Program</h2>
<?php
$tip[0] = "Develop With Error Reporting On";
$tip[1] = "Learn some shortcut keys";
$tip[2] = "Use PHP's Inbuilt Functions";
$tip[3] = "Protect Your Database";
$tip[4] = "Draw Before You Code";
$tip[5] = "Understand Your Project";
$tip[6] = "Join Open Source Projects";

$random = rand(0,6);
echo "Tip of the day is: ", $tip[$random];
?>
</body>
</html>
