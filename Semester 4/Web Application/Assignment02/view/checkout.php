<html>
<head>
	<style>
		@import url("css/checkout.css");
	</style>
</head>
<body>
<?php
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
	session_start();
$session = session_id();
if (! isset($_SESSION['countItems']))$_SESSION['countItems'] = 0;
	else $_SESSION['countItems']++;
	$Items = $_SESSION['countItems'];	
require_once("include/db_connect.php");

   $self = $_SERVER['PHP_SELF'];
   $first_name = isset($_REQUEST['firstname']) ? $_REQUEST['firstname'] : '';
   $last_name = isset($_REQUEST['lastname']) ? $_REQUEST['lastname'] : '';
   $address = isset($_REQUEST['address']) ? $_REQUEST['address'] : '';
   $delivery = isset($_REQUEST['delivery']) ? $_REQUEST['delivery'] : '';
   $card = isset($_REQUEST['card']) ? $_REQUEST['card'] : '';  
?>
<h3>
Contents of shopping cart
</h3>
<table border = "1" cellpadding = "2" id = "info">
<tr>
		<th>
			Product ID
		</th>
		<th>
			Title
		</th>
		<th>
			Quantity
		</th>
		<th>
			Price
		</th>
		<th>
			Subtotal
		</th>
	</tr>
<?php
$db_link = db_connect("project");
// create the SQL query
$query = "SELECT * FROM cart WHERE sessionID = '$session'";
// execute the query
$result = @mysql_query( $query )
or die( "Could not execute SQL query" );
// loop through all records & display in a HTML table
while ($row = mysql_fetch_array( $result) )
{
?>
	<tr>
		<td>
			<?php echo $row["productID"]; ?>
		</td>
		<td>
			<?php echo $row["title"]; ?>
		</td>
		<td>
			<?php echo $row["quantity"]; ?>
		</td>
		<td>
			<?php echo $row["price"]; ?>
		</td>
		<td>
			<?php echo $row["price"] * $row["quantity"];?>
		</td>
	</tr>
<?php
} // end loop
?>
</table>

<form action="<?php echo $self ?>" method="POST">
<h3>Please complete the customer order form</h3>
<?php
if ($error)
{
   echo "<p>$error</p>\n";
}
?>
<table id="form">
	<tr>
		<td>First  name: </td>
		<td><input class="input" type="text" name="firstname" value="<?php echo $first_name?>"></td>
	</tr>
	<tr>
		<td>Last name: </td>
		<td><input class="input" type="text" name="lastname" value="<?php echo $last_name?>"></td>
	</tr>
	<tr>
		<td>Address:</td>
		<td><input class="input" type="text" name="address" value="<?php echo $address?>"></td>
	</tr>
	<tr>
		<td>Delivery Address:</td>
		<td><input class="input" type="text" name="delivery" value="<?php echo $delivery?>"></td>
	</tr>
	<tr>	
		<td>Credit card no: </td>
		<td><input class="input" type="text" name="card"value="<?php echo $card?>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="button" value="Submit">
		<input type="reset" name="button" value="Reset"></td>
	</tr>
</table>
</form>
<?php
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
</body>
</html>
<?php
// Return an error string that is empty if there were no errors.
// Otherwise it contains an error message.
function validate_form()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $address = trim($_REQUEST['address']);
   $delivery = trim($_REQUEST['delivery']);
   $card = trim($_REQUEST['card']);
  
   $error = '';

   // Our definition of a valid name is one containing letters, hyphens,
   // and apostrophe's

   $reg_exp = '/^[a-zA-Z]+$/';

   if (! preg_match($reg_exp, $first_name))
   {
      $error .= "<span class=\"error\">Please do not leave first name blank</span><br>";
   }
   
   if (! preg_match($reg_exp, $last_name))
   {
      $error .= "<span class=\"error\">Please do not leave last name blank</span><br>";
   }
   
  if (! preg_match($reg_exp, $address))
   {
      $error .= "<span class=\"error\">Please do not leave address blank</span><br>";
   }
   
   if (! preg_match($reg_exp, $delivery))
   {
      $error .= "<span class=\"error\">Please do not leave delivery address blank</span><br>";
   }
   
   if (! preg_match($reg_exp, $card))
   {
      $error .= "<span class=\"error\">Please do not leave card no blank</span><br>";
   }


   return $error;
}
?>

<?php
function display_output_page()
{
   $first_name = trim($_REQUEST['firstname']);
   $last_name = trim($_REQUEST['lastname']);
   $address = trim($_REQUEST['address']);
   $delivery = trim($_REQUEST['delivery']);
   $card = trim($_REQUEST['card']);
?>
   <html>
   <head><title>Thank you</title></head>
   <body>
   <h1>Thank you for your order.</h1>
   <p>
   Your order reference number is: <?php echo uniqid('ORDER_' );?>
   </p>
   <p>
   The sum of 400 will be deducted from your account
   </p>
   <p>
   We have recorded your details, as follows:
   </p>
   <hr>
	<p><label>First Name: <?php echo $first_name?></label></p>
	<p><label>Last Name: <?php echo $last_name?></label></p>
	<p><label>Address: <?php echo $address?></label></p>
	<p><label>Delivery Address: <?php echo $delivery?></label></p>
	<p><label>Card No: <?php echo $card?></label></p>
	</body>
	</html>
<?php 
}
?>
