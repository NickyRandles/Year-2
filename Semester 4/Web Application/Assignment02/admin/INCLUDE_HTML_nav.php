<?php
// NOTE - variable for link to highlight with CSS class 'current_page" should be set before including this file
//
// defaults (set by 'INCLUDE_default_nav_styles.php') set all variables to empty string:
//  $indexLinkStyle = '';
//  $aboutLinkStyle = '';
//  $listLinkStyle = '';
//  $contactLinkStyle = '';
//  $sitemapLinkStyle = '';
//
// e.g. to highlight 'about' in nav bar, set variable as follows before including this file
//      $aboutLinkStyle =  'class="current_page"';
?>
<nav>
    <ul>
	 	<li>
            <a href="admin_home.php" <?php echo $homeLinkStyle; ?>>Home</a>
        </li>
        <li>
            <a href="admin_display.php" <?php echo $displayLinkStyle; ?>>Display</a>
        </li>
        <li>
            <a href="admin_insert.php" <?php echo $insertLinkStyle; ?>>Insert</a>
        </li>
		<li>
            <a href="admin_delete.php" <?php echo $deleteLinkStyle; ?>>Delete</a>
        </li>
		<li>
            <a href="admin_logout.php" <?php echo $logoutLinkStyle; ?>>Logout</a>
        </li>
    </ul>
</nav>
