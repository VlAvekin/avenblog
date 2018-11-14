function copyValueTo(fromElem, toElemId) {
    var input = fromElem.value;

    res(input);

    //document.getElementById(toElemId).innerHTML = input;
}

function res(input) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/");
    //xhr.send("key=" + encodeURIComponent(key));
}