<#ftl encoding='utf-8'/>
<!DOCTYPE html>
<html>

<#include "base.ftl"/>

<#macro title>BiologyStudy</#macro>

<#macro content>
<body>
    <#if error?has_content>
<h>${error}</h>
    </#if>

<a href="/register" <p align="right" name="register">Регистрация</p></a>
<a href="/login" <p align="right" name="auth" href="/login">Авторизация</p></a>

<p align="center" style="color:#000000; font-size:30px">
    Добро пожаловать на BiologyStudy. Сайт, где вы можете читать темы и закреплять их тестами.</p>
</div>
</body>
</html>
</#macro>

<@main></@main>