<header>
    <div aria-selected="true"><a href="/profiles">Анкеты</a></div>
    <div aria-selected="true"><a href="/sympathy">Лайки</a></div>
    <div aria-selected="true"><a href="/chats">Чаты</a></div>
    <#if user?? && !user.blocked>
        <div aria-selected="true"><a href="/my_profile/${user.id}">Мой профиль</a></div>
    </#if>
</header>