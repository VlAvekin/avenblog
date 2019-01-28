
// TODO to remake

function counter(val) {
    document.getElementById('editor-textarea').style.height = "1px";
    var size =document.getElementById('editor-textarea').scrollHeight;
    if (size >= val*25) {
        document.getElementById('editor-textarea').style.height = (25+size)+"px";
    } else{
        document.getElementById('editor-textarea').style.height = val*25 + "px";
    }

    var text = document.getElementById('editor-textarea').value;
    document.getElementById('editor-result').innerHTML = edit(text  + "\n");

}

window.onload = function() {
    var text = document.getElementById('result').innerHTML;
    document.getElementById('result').innerHTML = edit(text + "\n");

    var text1 = document.getElementById('editor-textarea').value;
    document.getElementById('editor-result').innerHTML = edit(text1 + "\n");
};

function edit(text) {
    var array = [[]];
    var col = 0;
    var leng = 1;
    for (var i = 0; i < text.length; i++) {
        if (text.charAt(i) == '#') {
            if (text.charAt(i+1) != ' ') {
                leng ++;
            } else {
                array[col] = ['#', i, leng];
                col++;
                leng = 1;
            }
        }
        if (text.charAt(i) == '*') {
            if (text.charAt(i+1) != ' ' && text.charAt(i+1) != '\n') {
                leng ++;
            } else {
                array[col] = ['*', i, leng];
                col++;
                leng = 1;
            }
        }
        if (text.charAt(i) == '\n') {
            array[col] = ['\n', i];
            col++;
        }
        if (text.charAt(i) == '+') {
            array[col] = ['+', i];
            col++;
        }
        if (text.charAt(i) == '~') {
            array[col] = ['~', i];
            col++;
        }
        if (text.charAt(i) == '!') {
            array[col] = ['!', i];
            col++;
        }
        if (text.charAt(i) == '[') {
            array[col] = ['[', i];
            col++;
        }
        if (text.charAt(i) == ']') {
            array[col] = [']', i];
            col++;
        }
        if (text.charAt(i) == '(') {
            array[col] = ['(', i];
            col++;
        }
        if (text.charAt(i) == ')') {
            array[col] = [')', i];
            col++;
        }
    }
    var buf = '';
    var res = text;
    for (var i = 0; i < array.length - 1; i++) {
        // them
        if(array[i][0] == '#' && array[i+1][0] == '\n'){
            buf = text.substring(array[i][1] - array[i][2], array[i+1][1]);
            if (array[i][2] == 1) {
                res = res.replace(buf, '<h' + array[i][2] + '>' +
                    buf.substring(array[i][2] + 1) +
                    '</h' + array[i][2] + '>');
            } else {
                res = res.replace(buf, '<h' + array[i][2] + '>' +
                    buf.substring(array[i][2] + 2) +
                    '</h' + array[i][2] + '>');
            }
        }
        // bullet
        if(array[i][0] == '+' && array[i+1][0] == '\n'){
            buf = text.substring(array[i][1], array[i+1][1]);
            res = res.replace(buf,'&#8226;' + buf.substring(1));
        }
        if(array[i][0] == '~' && array[i+1][0] == '\n'){
            buf = text.substring(array[i][1], array[i+1][1]);
            res = res.replace(buf,'☼' + buf.substring(1));
        }
        //
        if(array[i][0] == '*' && array[i+1][0] == '*'){
            if (array[i][2] == 1) {
                buf = text.substring(array[i][1] - array[i][2],
                    array[i+1][1] + array[i][2]);
                res = res.replace(buf,'<b>' + buf.substring(array[i][2] + 1,
                    buf.length - array[i][2] - 1) + '</b>');
            }
            if (array[i][2] == 2) {
                buf = text.substring(array[i][1] - array[i][2],
                    array[i+1][1] + array[i][2] - 1);
                res = res.replace(buf,'<i>' + buf.substring(array[i][2] + 1,
                    buf.length - array[i][2] - 1) + '</i>');
            }
            if (array[i][2] == 3) {
                buf = text.substring(array[i][1] - array[i][2],
                    array[i+1][1] + array[i][2] - 1);
                res = res.replace(buf,' <u>' + buf.substring(array[i][2] + 2,
                    buf.length - array[i][2] - 2) + '</u> ');
            }
        }
        //
        if (array[i][0] == '!' ){
            if (array[i+1][0] == '[' ) {
                if (array[i+2][0] == ']' ) {
                    if (array[i+3][0] == '(' ) {
                        if (array[i+4][0] == ')' ) {
                            var link = text.substring(array[i+3][1] + 1, array[i+4][1]);
                            var name = text.substring(array[i+1][1] + 1, array[i+2][1]);
                            var mas = name.split('_');
                            if (mas.length == 1) {
                                res = res.replace('!['+ name +"](" + link + ')',
                                    '<div><img src="' + link + '"class="rounded float-'+name+'" alt=""></div>');
                            } else {
                                res = res.replace('!['+ name +"](" + link + ')',
                                    '<div><img ' + 'style="width: ' + mas[1] + '%; height: ' + mas[1] + '%;"' +
                                    'src="' + link + '"class="rounded float-'+mas[0]+'" alt=""></div>');
                            }
                        }
                    }
                }
            }
        } else {
            if (array[i+1][0] == '[' ) {
                if (array[i+2][0] == ']' ) {
                    if (array[i+3][0] == '(' ) {
                        if (array[i+4][0] == ')' ) {
                            var name = text.substring(array[i+1][1] + 1, array[i+2][1]);
                            var link = text.substring(array[i+3][1] + 1, array[i+4][1]);
                            res = res.replace('['+ name +'](' + link + ')' , '<a href="' + link + '">' + name + '</a>');
                        }
                    }
                }
            }
        }

    }
    return res;
}