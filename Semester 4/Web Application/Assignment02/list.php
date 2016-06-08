<?php
//--------------------------------------------------
//-------------- DB model functions ----------------
//--------------------------------------------------
require('include/db_model.php');

//--------------------------------------------------
//----------- functions for this page --------------
//--------------------------------------------------

// given an array of dvd items, return HTML for table rows
function dvdArrayHTML($movieArray){
    $dvdArrayHTML = '';
    foreach($movieArray as $dvd)
    {
        $dvdArrayHTML .= dvdRowHTML($dvd);
    }

    return $dvdArrayHTML;
}

// given a dvd item, return HTML for that product
function dvdRowHTML($row){
    $tableRowHTML ='';

    $id = $row['id'];
    $title = $row['title'];
    $category = $row['category'];
    $price = $row['price'];
    $voteAverage = $row['voteAverage'];
    $numVotes = $row['numVotes'];

    // multiply by 100 to get a percentage
    $numVotes *= 100;

    // append percent sign
    $numVotesString = "$numVotes %";

    $tableRowHTML .= "<tr>";
    $tableRowHTML .=  "<td>$id</td>";
    $tableRowHTML .=  "<td>$title</td>";
    $tableRowHTML .=  "<td>$category</td>";
    $tableRowHTML .=  "<td>$price</td>";
    $tableRowHTML .=  "<td>$voteAverage</td>";
    $tableRowHTML .=  "<td>$numVotes</td>";
    $tableRowHTML .=  "</tr>";

    return $tableRowHTML;
}

//--------------------------------------------------
//----------------- main PHP section ---------------
//--------------------------------------------------

// get array of DVD items from DB
$movieArray = get_all_movies();

// get string for HTML rows for each DVD item
$dvdTableHTML = dvdArrayHTML($movieArray);

//--------------------------------------------------
//-------------- generate the 'view' ---------------
//--------------------------------------------------

// reset all nav styles
include('view/INCLUDE_default_nav_styles.php');

// set variables for page header / nav
$pageName = 'DVD listings';
$listLinkStyle =  'class="current_page"';

// include page body
include('view/INCLUDE_HTML_header.php');
include('view/INCLUDE_HTML_nav.php');
include('view/list.php');
include('view/INCLUDE_HTML_footer.php');
