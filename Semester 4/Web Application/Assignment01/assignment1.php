<?php
//Student name: Nicky Randles
//Student number: B00058026
//Assignment: 1
error_reporting(E_ALL ^ E_NOTICE);
echo "The following form entries are incorrect or incomplete:";
if(isset($_REQUEST['button'])) //action performed when submit button is pressed
{
	process_form();
}

else //display form page
{
	display_form_page('');
}
?>

<?php
//display the form page with the current errors
function display_form_page($error)
{
   $self = $_SERVER['PHP_SELF'];
   $first_name = isset($_REQUEST['firstName']) ? $_REQUEST['firstName'] : '';
   $last_name = isset($_REQUEST['lastName']) ? $_REQUEST['lastName'] : '';
   $phone_number = isset($_REQUEST['phoneNumber']) ? $_REQUEST['phoneNumber'] : '';
   $email_address = isset($_REQUEST['emailAddress']) ? $_REQUEST['emailAddress'] : '';
   $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
   $type = isset($_REQUEST['type']) ? $_REQUEST['type'] : '';
   $performance = isset($_POST['performance']) ? $_POST['performance'] : '';
   $horse_name = isset($_POST['horseName']) ? $_REQUEST['horseName'] : '';
   $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
   $age = isset($_POST['age']) ? $_REQUEST['age'] : '';
   $height = isset($_POST['height']) ? $_REQUEST['height'] : '';
   $breed = isset($_POST['breed']) ? $_REQUEST['breed'] : '';
   $comments = isset($_POST['comments']);
?>

<?php
if($error)
{
   echo "$error\n";
}
?>

<html>
<head>
<title>Horse Sale</title>
<style>
	@import url("assignment1.css");
</style>
</head>

<body>
<form action="<?php echo $self ?>" method="POST">
<h1>Horse Sale - Entry Form</h1>
<img src = "horse.jpg" alt = "horse picture" height = "80" width = "85">
<fieldset>
<legend>Owner Details</legend>
<label for = "firstName" class = "details">First Name:</label>
	<input type = "text" name = "firstName" id = "firstName" value = "<?php echo $first_name ?>">
<label for = "lastName" class = "textMove">Last Name:</label> 	
	<input type = "text" name = "lastName" id = "lastName" value = "<?php echo $last_name ?>">
<br>
<label for = "emailAddress" class = "details">Email Address:</label>
	<input type = "text" name = "emailAddress" value = "<?php echo $email_address ?>">
<label for = "phoneNumber" class = "textMove">Phone Number:</label>
	<input type = "text" name = "phoneNumber"  id = "phoneNumber" value = "<?php echo $phone_number ?>">
	<span>(e.g.123-1234567)</span>
<br>	
<label for = "address" class = "details">Address:</label>
	<input type = "text" name = "address" id = "address"  size = "45" value = "<?php echo $address ?>">	
</fieldset>
<fieldset>
<legend>Tick Selection</legend>
<input type = "radio" name = "type" value="gelding" <?php check($type, "gelding") ?>>Gelding
<input type = "radio" name = "type" value="colt" <?php check($type, "colt") ?>>Cost
<input type = "radio" name = "type" value="filly" <?php check($type, "filly") ?>>Filly
<input type = "radio" name = "type" value="mare" <?php check($type, "mare") ?>>Mare
</fieldset>
<fieldset>
<legend>Performance - Check all that apply</legend>
<input type = "checkbox" name = "performance[]" value = "broken" <?php performance($performance, "broken") ?>>Broken and Riding
<input type = "checkbox" name = "performance[]" value = "pony" <?php performance($performance, "pony") ?>>Pony Clubbed
<input type = "checkbox" name = "performance[]" value = "lunging" <?php performance($performance, "lunging") ?>>Lunging
<input type = "checkbox" name = "performance[]" value = "unbroken" <?php performance($performance, "unbroken") ?>>Unbroken
</fieldset>
<fieldset>
<legend>Details of Horse</legend>
<table border = "2" width = "750">
	<tr>
		<td>
			<label for = "horseName">Name</label>
			<input type = "text" name = "horseName" class = "center" value = "<?php echo $horse_name ?>"></td>
		</td>
		<td>
			<label for = "colour">Colour</label>	
			<select name="colour[]" class = "center">
				<option value="blank" selected disabled></option>
				<option <?php colour($colour, "Bay") ?>>Bay</option>
				<option <?php colour($colour, "Chestnut") ?>>Chestnut</option>
				<option <?php colour($colour, "Piebald") ?>>Piebald</option>
				<option <?php colour($colour, "White") ?>>White</option>
			</select>
		</td>
		<td>
			<label for = "age">Age</label>
			<input type = "number" name="age" min=1 max=100 class = "center" value = "<?php echo $age ?>">
		</td>
		<td>
			<label for = "height">Height</label>
			<input type = "number" name="height" min=1 max=300 class = "center" value = "<?php echo $height ?>">
		</td>
			<td><label for = "breed">Breeding Recorded?</label>
			<input type = "radio" name = "breed" value = "yes" <?php check($breed, "yes") ?> id = "radioCenter" >Yes
			<input type = "radio" name="breed" value = "no" <?php check($breed, "no")?>>No
		</td>
	</tr>
</table>
</fieldset>
<fieldset>
<legend>Additional Information</legend>
<table border = "2" width = "750">
	<tr>
		<td>
			<label for = "comments">Additonal Performance Details</label>
			<textarea rows = "4" wrap = "physical" name = "comments" id = "comments" <?php echo $comments ?>></textarea>
		</td>
		<td>
			<label for = "fileUpload">Upload images or video (optional)</label>
			<input type = "file" name = "upload" id="upload">
		</td>
	</tr>	
</table>
</fieldset>
<div id = "buttons">
<input type = "submit" name = "button" value = "Enter details">
<input type = "reset" value="Clear fields">
</div>
</form>
</body>
</html>
<?php
}
?>

<?php
// If $group has the value $val then check this radio button
function check($group, $val)
{
   if ($group === $val)
   {
      echo 'checked = "checked"';
   }
}
?>

<?php
// If $val is in the $performance array then check this checkbox 
function performance($performance, $val)
{
   if (is_array($performance) and in_array($val, $performance))
   {
      echo 'checked = "checked"';
   }
 }
?>

<?php
 //If $group has the value $val then select this list item 
function colour($colour, $val)
{
   if (is_array($colour) and in_array($val, $colour))
   {
     echo 'selected = "selected"';
   }
}
?>


<?php
function process_form()
{
	$error = validate_form();
	if ($error)
	{
		display_form_page($error);
	}
	else
	{
		display_output_page();
	}
}
?>

<?php
//Will return an error message if there is an error. Will return nothing if there is not an error.
function validate_form()
{
   $first_name = trim($_REQUEST['firstName']);
   $last_name = trim($_REQUEST['lastName']);
   $address = trim($_REQUEST['address']);
   $email_address = trim($_REQUEST['emailAddress']);
   $phone_number = trim($_REQUEST['phoneNumber']);
   $type = isset($_REQUEST['type']) ? $_REQUEST['type'] : '';
   $performance = isset($_POST['performance']) ? $_REQUEST['performance'] : '';
   $horse_name = isset($_REQUEST['horseName']) ? $_REQUEST['horseName'] : '';
   $colour = isset($_POST['colour']) ? $_POST['colour'] : '';
   $age = isset($_POST['age']) ? $_REQUEST['age'] : '';
   $height = isset($_POST['height']) ? $_REQUEST['height'] : '';
   $brecorded = isset($_POST['brecorded']) ? $_REQUEST['brecorded'] : '';
   $comments = trim($_REQUEST["comments"]); 
   
	$error = '';
	//Our defiinition of a valid name is a name containing letters, hyphens and apostrophe's
   $reg_exp = '/^[a-zA-Z\-\']+$/';
   $reg_exp2 = '/[,!@#$%*a-zA-Z0-9]/';
   $reg_exp3 = "/[0-9]{2,3}-[0-9]{7}/";

	
echo "<ol>";
	if(! preg_match($reg_exp, $first_name))
	{
		$error .= "<li> <span class=\"error\">First name is invalid (letters, hyphens, ', only)</span></li>";
	}
	
	if(! preg_match(reg_exp, $last_name))
	{
		$error .= "<li> <span class=\"error\">Last name is invalid (letters, hyphens, ', only)</span></li>";
	}
	
	if(!filter_var($email_address, FILTER_VALIDATE_EMAIL))
	{
		$error .= "<li> <span class=\"error\">Email is invalid (Format as xxx@yyy.ie)</span></li>";
	}
	
	if(! preg_match(reg_exp3, $phone_number))
	{
		$error .= "<li> <span class=\"error\">Phone number is invalid (Format as 999-9999999)</span></li>";
	}	
	
	if(! preg_match(reg_exp2, $address))
	{
		$error .= "<li> <span class=\"error\">Address is invalid (………)</span></li>";
	}
	
	if(empty($_POST['type']))
	{
		$error .= "<li> <span class=\"error\">Please select the sex of the horse</span></li>";
	}	
	
	if(!isset($_POST['performance']))
	{
		$error .= "<li> <span class=\"error\">Tick a box in the Performance section</span></li>";
	}	
	
	if(! preg_match($reg_exp, $horse_name))
	{
		$error .= "<li> <span class=\"error\">Name of the horse in invalid  (letters, hyphens, ', only)</span></li>";
	}
	
	if(empty($_POST['colour']))
	{
		$error .= "<li> <span class=\"error\">Select colour of horse</span></li>";
	}
	
	if(empty($_POST['age']))
	{
		$error .= "<li> <span class=\"error\">Enter Age correctly</span></li>";
	}
	
	if(empty($_POST['height']))
	{
		$error .= "<li> <span class=\"error\">Enter Height correctly</span></li>";
	}
	
	if(empty($_POST['breed']))
	{
		$error .= "<li> <span class=\"error\">State whether the Breeding is recorded</span></li>";
	}
	
	if($comments == "")
	{
		$error .= "<li> <span class=\"error\">Enter additional Performance Details </span></li>";
	}
	
	
	return $error;

}
echo "</ol>";

?>

<?php
function display_output_page()
{
	$first_name = trim($_REQUEST['firstName']);
	$last_name = trim($_REQUEST['lastName']);
	$email_address = trim($_REQUEST['emailAddress']);
	$phone_number = trim($_REQUEST['phoneNumber']);
	$address = trim($_REQUEST['address']);
	$type = isset($_REQUEST['type']) ? $_REQUEST['type'] : '';
	$performance = isset($_POST['performance']) ? $_REQUEST['performance'] : '';
	$horse_name = trim($_REQUEST['horseName']);
	$colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
	$age = isset($_POST['age']) ? $_REQUEST['age'] : '';
	$height = isset($_POST['height']) ? $_REQUEST['height'] : '';
	$breed = isset($_POST['breed']) ? $_REQUEST['breed'] : '';
	$comments = trim($_REQUEST['comments']);
	$date = date("l F d, Y");
	$file_upload = trim($_REQUEST["upload"]);
?>

<html>
<head>
	<title>Form Results</title>
	<style>@import url("submissionStyle.css");</style>
</head>
<body>
<h1>Form Entries Submitted</h1>
<h3>Please review your entries you made on <?php echo "$date" ?></h3>
<form action = "mailto:b00058026@student.itb.ie?subject= Form entry submission details" method = "POST">
<textarea rows = "17" cols = "70" wrap = "physical" name = "comments" id = "comments">
<?php
echo "Name     :\t\t $first_name $last_name \n";
echo "Address  :\t\t $address \n";
echo "Email    :\t\t $email_address \n";
echo "Phone    :\t\t $phone_number \n";
echo "Name of horse :\t\t $horse_name \n";
echo "Breeding recorded :\t $breed \n";
echo "Sex of Horse:\t\t $type \n";
echo "Colour:";
	foreach($colour as $value)
	{
		echo "\t\t\t $value \n";
	}
echo "You selected the following in 3 of the performance sections:\n";
	foreach($performance as $value)
	{
		echo "\t\t\t $value \n";
	}
echo "Comment  :\t\t $comments \n";
echo "File uploaded:\t\t $file_upload \n";
?>
</textarea>
<br>
<input type = "submit" id = "button" value = "Send Thru Email">
</form>
<a href="assignment1.php"> Return to Entry Form </a>
</body>
</html>

<?php
}
?>

