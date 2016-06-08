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