<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order</title>
    <link rel="stylesheet" type="text/css" href="OrderCSS.css">

</head>
<body>
<div class="header">
    <h1>Pizza Shop</h1>
</div>
<div class="box">
    <form class="form">

        <p>
            <label for="address">Address</label>
            <input type="text" id="address" name="address">
        </p>
        <p>
            <label for="PLZ">PLZ, City</label>
            <input type="number" id="PLZ" name="PLZ">
        </p>
        <p>
            <label for="tel">Phone Number</label>
            <input type="tel" id="tel" name="tel">
        </p>
    </form>
</div>
<div class="box">
    <form action="http://localhost:8080/pizzashop/confirmation">
        <button class="button" type="submit"><span class="nextButton">Abschliessen</span></button>
    </form>
</div>
</body>
</html>