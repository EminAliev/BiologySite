<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Комментарии</title>
<#include "base.ftl">

<#macro content>
<div class="wrapper">
    <a href='/theme'>Назад</a>
    <h3>Комментарии</h3>
    <#if comments?has_content>
        <#list comments as c>
            <div class="list">
                <div class="num" onclick="location.href='#'"><#if c.idUser??><h4>${c.idUser} ${c.date}: </h4><#else><h4>
                    fgf</h4></#if>
                    <h3><span>${c.text} </span></h3></div>
            </div>
        </#list>
    </#if>

    <div class="well">
        <h4>Напишите комментраий</h4>
        <form method="post" action="/comments">

            <div class="form-group">
                <textarea class="form-control text-review" rows="3" id="comment1" name="comment"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Отправить</button>
        </form>
    </div>
</div>
</#macro>

</html>
<@main></@main>
