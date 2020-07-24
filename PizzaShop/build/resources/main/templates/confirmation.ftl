<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
    <link rel="stylesheet" type="text/css" href="confirmationCSS.css">
</head>
<body>
<div class="header">
    <h1>Pizza Shop</h1></div>
<div class="box">
    <div class="grid">
        <img src="Img/Prosciutto_et_Funghi.jpg" alt="Pizza Prosciutto et Funghi" class="grid-item"/>
        <div class="grid-item">Pizza Prosciutto et Funghi</div>
        <div class="grid-item">16x</div>
        <div class="grid-item">139.45</div>
    </div>
</div>

<#assign totalAmount = 0>
<#list pizzaOrders as pizzaOrder>
    <#assign totalAmount = totalAmount + 1>
<#-- pizzaName = ${pizzas[pizzaOrder.pizza_id]}> -->
    <div class="box">
        <div class="grid">
            <img src="Img/${pizzas[pizzaOrder.pizza_id]}.jpg" alt="Pizza ${pizzas[pizzaOrder.pizzaId]}"
                 class="grid-item"/>
            <div class="grid-item">Pizza ${pizzas[pizzaOrder.pizzaId]}</div>
            <div class="grid-item">${pizzaOrder.amount}</div>
            <div class="grid-item">${order.totalPrice}</div>
        </div>
    </div>
</#list>

<div class="box">
    <div class="grid">
        <div></div>
        <div class="grid-item">Total</div>
        <div class="grid-item">${totalAmount}</div>
        <div class="grid-item">${order.totalPrice}</div>
    </div>
</div>
<div class="box">
    <form action="http://localhost:8080/pizzashop/pizza">
        <button class="button" type="submit"><span class="nextButton">Nochmals Bestellen</span></button>
    </form>
</div>

</body>
</html>