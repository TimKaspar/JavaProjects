function calculateTotal(pizzaOrderings) {
    let total = 0;
    for (i=0; i<pizzaOrderings.length; i++) {
        total += pizzaOrderings[i].price;
    }
    return total;
}
function addZeroes( num ) {
    var value = Number(num);
    var res = num.split(".");
    if(res.length == 1 || (res[1].length < 3)) {
        value = value.toFixed(2);
    }
    return value
}