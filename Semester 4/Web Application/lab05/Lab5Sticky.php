<?php
// -----------------------------------------------------------------------------
// This version generates the form and prcessess the form.
// If the submit button is undefined then the form is displayed
// else the form is processed.
// Error checking is also performed on the names
// The form is also sticky: previous values are shown for error correction
// -----------------------------------------------------------------------------

echo "<u>Forms with ERROR CHECKING & STICKY INPUT on TEXT BOXES </u> <p>";

if (isset($_REQUEST['button'])) // submit was clicked
{
   process_form();
}
else // display form for first time
{
   display_form_page('');
}
?>

<?php
// Display the form page and the error message
// An empty error message indicates valid data
function display_form_page($error)
{
   $self = $_SERVER['PHP_SELF'];
   $first_name = isset($_REQUEST['firstname']) ? $_REQUEST['firstname'] : '';
   $last_name = isset($_REQUEST['lastname']) ? $_REQUEST['lastname'] : '';
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
   $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
   $foods = isset($_REQUEST['foods']) ? $_REQUEST['foods'] : '';
?>
<html>
<head>
<link rel="stylesheet" type="text/css" href="input.css"/>
<title>Forms, Sticky Input</title>
<style type="text/css">
.error
{ 
	color: #ff0000;
}

body
{
	border-style:solid;
	border-width:5px;
	height: 80%;
	width: 50%;
	margin-left: 25%;
}

form
{
	border-style:solid;
	border-width:1px;
	border-color:red;
	background-color: pink;
	margin: 5%;
}

h1
{
	text-align: center;
}

#buttons
{
	margin-left: 35%;
}
  
</style>
</head>
<body>
<form action="<?php echo $self ?>" method="POST">
<h1>Forms, Sticky Input</h1>

In this version the form is generated by the PHP script
using error checking and sticky input fields.

<?php
if ($error)
{
   echo "<p>$error</p>\n";
}
?>

<p>First  name: <input class="input" type="text" name="firstname"
   value="<?php echo $first_name?>"></p>
<p>Last name: <input class="input" type="text" name="lastname"
   value="<?php echo $last_name?>"></p>
<p>Age: <input class="input" type="number" name="age" min=1 max=100
	value="<?php echo $age?>"></p>
<p>
Male: <input type="radio" name="sex" value="male" <?php check($sex,"male") ?>>
Female: <input type="radio" name="sex" value="female" <?php check($sex,"female") ?>>
</p>
<p>
Select favourite colour:
<select name="colour[]">
   <option <?php check($colour,"red")?>>Red</option>
   <option <?php check($colour,"blue")?>>Blue</option>
   <option <?php check($colour,"green")?>>Green</option>
   <option <?php check($colour,"yellow")?>>Yellow</option>
</select>
</p>
<p>
Choose your favorite food:
Beans <input type="checkbox" name="foods[]" value="beans" <?php check($foods,"beans")?>>
Crisps <input type="checkbox" name="foods[]" value="crisps" <?php check($foods,"crisps")?>>
Lemons <input type="checkbox" name="foods[]" value="lemons" <?php check($foods,"lemons")?>>
</p>
<p id="buttons">
<input type="submit" name="button" value="Submit Name">
<input type="reset" name="button" value="Reset">
</p>
</form>
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
// Return an error string that is empty if there were no errors.
// Otherwise it contains an error message.
function validate_form()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
   $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
   $foods = isset($_REQUEST['foods']) ? $_REQUEST['foods'] : '';

   $error = '';

   // Our definition of a valid name is one containing letters, hyphens,
   // and apostrophe's

   $reg_exp = '/^[a-zA-Z\-\']+$/';

   if (! preg_match($reg_exp, $first_name))
   {
      $error .= "<span class=\"error\">First name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (! preg_match($reg_exp, $last_name))
   {
       $error .= "<span class=\"error\">Last name is invalid (letters, hyphens, ', only)</span><br>";
   }
   if (strlen($age) == 0)
   {
      $error .= "<span class=\"error\">Please enter a valid age</span><br>";
   }
   if (strlen($sex) == 0)
   {
      $error .= "<span class=\"error\">Select a sex</span><br>";
   }
   	if (strlen($colour) == 0)
   {
      $error .= "<span class=\"error\">You must select your favourite colour</span></br>";
   }
   if (! is_array($foods))
   {
      $error .= "<span class=\"error\">You must select at least one food</span></br>";
   }   
   return $error;
}
?>


<?php
function display_output_page()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $age = isset($_REQUEST['age']) ? $_REQUEST['age'] : '';
   $sex = isset($_REQUEST['sex']) ? $_REQUEST['sex'] : '';
   $foods = isset($_REQUEST['foods']) ? $_REQUEST['foods'] : '';
   $colour = isset($_REQUEST['colour']) ? $_REQUEST['colour'] : '';
?>
   <html>
   <head><title>Form Results</title></head>
   <body>
   <h1>Form Results</h1>
   <?php
   		echo "Firstname: ", "$first_name", "<br/>"; 
		echo "Lastname: ", "$last_name", "<br/>"; 
		echo "Age: ", "$age", "<br/>"; 
		echo "Sex: ", "$sex", "<br/>"; 
		echo "Fav colour: ", "$colour", "<br/>"; 
		if (is_array($foods))
		{
			echo "Favorite foods are: ";
			foreach ($foods as $food)
			{
				echo $food, ", ";
			}
		}
	?>
   </body>
   </html>
<?php
}
?>
