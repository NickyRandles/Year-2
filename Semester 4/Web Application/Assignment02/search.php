<?php
//--------------------------------------------------
//-------------- generate the 'view' ---------------
//--------------------------------------------------

// reset all nav styles
include('view/INCLUDE_default_nav_styles.php');

// set variables for page header / nav
$pageName = 'search';
$searchLinkStyle =  'class="current_page"';

// include page body
include('view/INCLUDE_HTML_header.php');
include('view/INCLUDE_HTML_nav.php');
include('view/search.php');
