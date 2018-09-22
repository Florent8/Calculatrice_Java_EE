<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculatrice</title>
</head>
<body>
<form action="/calculatrice/" method="post">
    <input type="number" title="number1" name="number1"/>
    +
    <input type="number" title="number2" name="number2"/>
    <button type="submit">Calculer</button>
</form>
${ empty result ? '' : result }
</body>
</html>
