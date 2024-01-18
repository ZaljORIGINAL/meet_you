<header>
    <div aria-selected="true"><a href="/profiles">Анкеты</a></div>
    <div aria-selected="true"><a href="/sympathy">Лайки</a></div>
    <div aria-selected="true"><a href="/chats">Чаты</a></div>
    <#if user?has_content>
        <div aria-selected="true"><a href="/my_profile/${user.id}">${user.email}</a></div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Выйти"/>
        </form>
    <#else>
        <div>
            <div aria-selected="true"><a href="/login">Войти</a></div>
            <div aria-selected="true"><a href="/registration">Регистрация</a></div>
        </div>
    </#if>
</header>