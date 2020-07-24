<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pizza</title>
    <link rel="stylesheet" type="text/css" href="PizzaCSS.css">
</head>
<body>
<#-- Grid wrapper for whole Page -->
<div class="grid">
    <#assign itemCounter = 0>
    <#-- all idividual values from flex-items (Pizza Selection)-->
    <#assign itemCounts = [32,16,8,4,2,1]>
    <#assign flexItems = ["flex-item1","flex-item2","flex-item3","flex-item4","flex-item5","flex-item6"]>
    <#assign ingredints = ["Schinken, Ruccola, Tomaten, Mozorella","Schinken, Ananas, Tomaten, Mozorella", "Tomaten, Mozorella, Basilikum","Schinken, Champignon, Tomaten, Mozorella","Ton, Zwiebeln, Tomaten, Mozorella","Salami, Tomaten, Mozorella"]>

    <#-- Title-->
    <h1>Pizza Shop</h1>

    <#-- Pizza Selection -->
    <div class="flex-container">
        <#list itemCounts as itemCount>
            <form action="<#assign itemCounter += itemCount>">
                <button class="hvr-sweep-to-top flex-item" id="${flexItems[itemCount_index]}">
                    <span class="pizzaName">${pizzas[itemCount_index].name}</span>
                    <span class="ingredients">Zutaten</span>
                    <p><span class="ingredients" id="pizzaInfoContent">${ingredints[itemCount_index]}</span></p>
                </button>
            </form>
        </#list>
    </div>

    <#-- functions -->
    <#macro cartItem pizzaName>
        <p>
            <label for="amount">${pizzaName}</label>
            <input type="number" id="amount" name="amount" min="0" max="50" value="1">
        </p>
    </#macro>
    <#macro loadCart>
    <#-- all possible outcomes of itemCounter: [1,2,3,4,5,6,8,9,10,12,16,17,18,20,24,32,33,36,40,48]-->
    <#-- all idividual values from flex-items (Pizza Selection)-->
        <#assign itemCounts = [32,16,8,4,2,1]>
    <#-- loop to cycle which Pizzas where clicked on (itemCounter value)-->
        <#list itemCounts as itemCount>
            <#if itemCounter / itemCount gt 1 || itemCounter / itemCount == 1>
                <#assign itemCounter = itemCounter% itemCount>
                <@cartItem pizzas[itemCount?index].name/>
            </#if>
        </#list>
    </#macro>

    <#-- Shopping Cart -->
    <div class="grid-item-shoppingcart">
        <ul class="cart-wrapper">
            <li class="cart-header"> Wahrenkorb</li>
            <form action="confirmation" class="form">
                <li class="cart-checkout">
                    <@loadCart/>
                    <br>
                    <p>
                        <label for="address">Addresse</label>
                        <input class="orderInput" type="text" id="address" name="address">
                    </p>
                    <p>
                        <label for="tel">Telefon Nummber</label>
                        <input class="orderInput" type="tel" id="tel" name="tel">
                    </p>
                    <button class="button" type="submit"><span class="nextButton">Bestellen</span></button>
            </form>
            </li>
        </ul>
    </div>

</div>
</body>
</html>