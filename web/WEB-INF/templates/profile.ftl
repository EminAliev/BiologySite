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


<div class="container">

    <div class="col-md-12" style="margin-top: 100px; text-align: center; margin-bottom: 20px" >
        <div class="col-md-5">
            <h3>Здравствуйте, ${name}</h3>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
            <ul style="margin-top: 10px; margin-bottom: 40px">
                <li class="list-group-item">Имя: <p>${name}</p></li>
                <li class="list-group-item">Фамилия: <p>${fullname}</p></li>
                <li class="list-group-item">Ник: <p>${username}</p></li>
                <li class="list-group-item">E-mail: <p><#if email?has_content>
                    <td>${email}</td>
                <#else>
                    <td>нет</td>
                </#if></p></li>
                <li class="list-group-item">Класс: <p><#if classnumber?has_content>
                    <td>${classnumber}</td>
                <#else>
                    <td>нет</td>
                </#if></p></li>
            </ul>
            <button type="button" class="btn" style="margin-left: 41px; margin-bottom: 30px">
                <span class="glyphicon glyphicon-cog" style="margin-right: 5px"></span>
                <a href="/edit">Редактировать</a>
            </button>
            <button type="button" class="btn" style="margin-left: 41px; margin-bottom: 30px">
                <span class="glyphicon glyphicon-cog" style="margin-right: 5px"></span>
                <a href="/delete">Удалить</a>
            </button>
            <button type="button" class="btn" style="margin-left: 41px; margin-bottom: 30px">
                <span class="glyphicon glyphicon-cog" style="margin-right: 5px"></span>
                <a href="/logout">Выйти</a>
            </button>
        </div>


</body>

</html>
</#macro>
<@main></@main>