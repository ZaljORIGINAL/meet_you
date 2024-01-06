<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Войти</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<header></header>
<body>
<div>
    <form action="/login" method="post">
        <label>Логин: <input type="text" name="username"></label>
        <label>Пароль: <input type="password" name="password"></label>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Войти</button>
    </form>
    <a href="/registration">Зарегистрироваться</a>
    <a href="/lost_password">Востановить пароль</a>
</div>
</body>
</html>