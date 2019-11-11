<#ftl encoding="utf-8"/>
<!DOCTYPE html>
<html>

<#include "base.ftl"/>

<#macro title>Регистрация</#macro>

<#macro content>
<body>


<div style="margin-top: 100px"></div>
<#if error?has_content>
    <h>${error}</h>
</#if>

<div class="center-wrap2">
    <div class="col-md-4 col-xs-1 col-sm-2" ></div>
    <div class="col-md-4 col-xs-10 col-sm-8">

        <form action="/register" id="f1" method="post" >
            <h1>Регистрация</h1>

            <input type="text" name="username" required="" id="username" class="form-control" placeholder="Username" value="" style="color: black"/>

            <input type="password" name="password" required="" id="password" class="form-control" placeholder="Password" value="" style="color: black"/>

            <input type="text" name="name" required="" id="name"  class="form-control" placeholder="Name" value="" style="color: black"/>

            <input type="text" name="fullname" id="fullname"  class="form-control" placeholder="Fullname" value="" style="color: black"/>

            <input type="text" name="classnumber" id="classnumber" class="form-control" placeholder="Classnumber" value="" style="color: black"/>
            <input type="text" name="email" id="email" class="form-control" placeholder="e-mail" value="" style="color: black"/>

            <input type="submit" name="reg" id="reg" value="Регистрация" class="button"/>
            <br>
            <p id="out"></p>
        </form>
    </div>
    <div class="col-md-3 col-xs-1 col-sm-2"></div>
</div>
</body>
</html>
</#macro>
<@main></@main>