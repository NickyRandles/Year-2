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
            <a href="index.php" <?php echo $indexLinkStyle; ?>>Home</a>
        </li>
        <li>
            <a href="about.php" <?php echo $aboutLinkStyle; ?>>About Us</a>
        </li>
		<li>
            <a href="catalog.php" <?php echo $catalogLinkStyle; ?>>Catalog</a>
        </li>
		<li>
            <a href="search.php" <?php echo $searchLinkStyle; ?>>Search</a>
        </li>
        <li>
            <a href="shoppingCart.php" <?php echo $cartLinkStyle; ?>>Shopping cart</a>
        </li>
		<li>
            <a href="checkout.php" <?php echo $checkoutLinkStyle; ?>>Checkout</a>
        </li>
        <li>
            <a href="contact.php" <?php echo $contactLinkStyle; ?>>Contact Us</a>
        </li>

        <li>
            <a href="sitemap.php" <?php echo $sitemapLinkStyle; ?>>Site Map</a>
        </li>
    </ul>
</nav>
