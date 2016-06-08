<?php
//--------------------------------------------------
//-------------- generate the 'view' ---------------
//--------------------------------------------------

// reset all nav styles
include('admin/INCLUDE_default_nav_styles.php');

// set variables for page header / nav
$pageName = 'Delete';
$deleteLinkStyle =  'class="current_page"';

// include page body
include('admin/INCLUDE_HTML_header.php');
include('admin/INCLUDE_HTML_nav.php');
include('admin/admin_delete.php');
include('admin/INCLUDE_HTML_footer.php');

