function addAmount(id) {
    var element = document.getElementById(id);
    if (!element) {
        throw "No such element: " + id;
    }
    if (!element.value) { // falls leer
        element.value = 1;
    } else {
            var count = parseInt(element.value);
            element.value = count + 1;
    }
}
function addZeroes( num ) {
    var value = Number(num);
    var res = num.split(".");
    if(res.length == 1 || (res[1].length < 3)) {
        value = value.toFixed(2);
    }
    return value
}