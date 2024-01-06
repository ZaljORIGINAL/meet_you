<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<header></header>
<body>
<div>
    <form action="/registration" method="post">
        <p>Имя пользователя: <input type="text" name="name"></p>
        <p>Электронная почта: <input type="email" name="email"></p>
        <p>Пароль: <input type="password" name="password"></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Регистрация</button>
    </form>
</div>
</body>
</html>