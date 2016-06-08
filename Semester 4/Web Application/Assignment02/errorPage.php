<?php
// enable access to session variables
session_start();

// get values from session
$errorMessage = $_SESSION['errorMessage'];
$errorCategory = $_SESSION['errorCategory'];

// set variables for page header / nav
$pageName = "Error";

// include page body
require('include/INCLUDE_HTML_header.php');
require('include/INCLUDE_HTML_nav.php');
include('view/errorPage.php');
?>

<h1> ERROR detected</h1>

<p>
    The following error has been detected - try again or report to us via the Contacts page
</p>

<hr/>
<strong>Error category:</strong>
<?php
print $errorCategory;
?>

<hr/>
<!-- use PRE so can see line breaks in string ... -->
<pre>

<?php
print $errorMessage;
?>

</pre>


</body>
</html>