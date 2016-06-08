<!-- start table for displaying DVD details -->
<h2>Lists of DVDs and their average votes</h2>

<table>
    <tr>
        <th> ID </th>
        <th> title </th>
        <th> category </th>
        <th> price </th>
        <th> vote average </th>
        <th> num votes </th>
    </tr>

    <?php
        // -------------- HTML for dvd items ------------------
        echo $dvdTableHTML;
    ?>

</table>

</body>
</html>