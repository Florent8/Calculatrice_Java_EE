<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculatrice</title>
    <meta charset="UTF-8"/>
</head>
<body>
<form action="/calculatrice/" method="post" accept-charset="UTF-8">
    <input type="number" title="number1" name="number1"/>
    <select name="operator" title="operator">
        <option value="+" selected>+</option>
        <option value="-">-</option>
        <option value="x">x</option>
        <option value="÷">÷</option>
        <option value="mod">mod</option>
    </select>
    <input type="number" title="number2" name="number2"/>
    <button type="submit">Calculer</button>
</form>
${ empty result ? '' : '<p>'.concat(result).concat('</p>') }
</body>
</html>
