<#ftl encoding='utf-8'/>
<!DOCTYPE html>
<html>

<#include "base.ftl"/>

<#macro title>Авторизация</#macro>

<#macro content>
<body>
<#if error?has_content>
<h>${error}</h>
</#if>
<div class="center-wrap">
    <div class="login-wrap">


        <form method = "post" action="/login" class="login-form">
            <h1 class="freeb">Вход</h1>
            <div class="input-wrap">
            <#if login?has_content>
                <label for="" class="user-id"><input type="text" name="username" placeholder="Username" value="${login}"></label>
            <#else>
                <label for="" class="user-id"><input type="text" name="username" placeholder="Username"></label>
            </#if>
                <hr class="form-hr">
                <label for="" class="password"><input type="password" name="password" placeholder="Password"></label>
            </div>
            <div class="remember">
                <span>Запомнить?</span>
                <div class="switch">
                    <input type="checkbox" id="switch" name="switch" class="switch-check" checked="checked">
                    <label for="switch" class="switch-label">
                        <span class="switch-slider switch-slider-on"></span>
                        <span class="switch-slider switch-slider-off"></span></label>

                </div>
            </div>
            <input type="submit" class="button" value="ВОЙТИ">
        </form>

    </div>
</div>
</body>
</html>
</#macro>

<@main></@main>