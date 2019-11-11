<#ftl encoding="utf-8"/>
<!DOCTYPE html>
<html>

<#include "base.ftl"/>

<#macro title>Настройки аккаунта</#macro>

<#macro content>
<body>
<div class="container">
    <div class="body2">
        <div class="row" style="margin-left: 30px;margin-right: 30px" >
            <div class="col-md-12" style="margin-top: 40px; text-align: center; margin-bottom: 0px" >
            </div>
            <div class="col-md-12" style="margin-top: 100px; text-align: center; margin-bottom: 20px" >
                <h1>Настройки</h1>
                    <div class = "row" style="margin-top:40px;margin-left:40px;margin-right:40px">
                        <div class="col-md-6">
                            <h3>Изменить пользовательские данные</h3>

                            <#if username?has_content>
                                 <input type="text" name="username" id="username" class="form-control" placeholder="Ник" value="${username}" style="color: black;margin-top:10px"/>
                            <#else>
                                 <input type="text" name="username" id="username" class="form-control" placeholder="Ник" value="" style="color: black;margin-top:10px"/>
                            </#if>


                            <#if name?has_content>
                                <input type="text" name="name" id="name"  class="form-control" placeholder="Имя" value="${name}" style="color: black"/>
                            <#else>
                                <input type="text" name="name" id="name"  class="form-control" placeholder="Имя" value="" style="color: black"/>
                            </#if>

                            <#if fullname?has_content>
                                <input type="text" name="fullname" id="fullname"  class="form-control" placeholder="Фамилия" value="${fullname}" style="color: black"/>
                            <#else>
                                <input type="text" name="name" id="name"  class="form-control" placeholder="Фамилия" value="" style="color: black"/>
                            </#if>

                            <#if classnumber?has_content>
                                <input type="text" name="classnumber" id="classnumber"  class="form-control" placeholder="Класс" value="${classnumber}" style="color: black"/>
                            <#else>
                                <input type="text" name="classnumber" id="classnumber"  class="form-control" placeholder="Класс" value="" style="color: black"/>
                            </#if>

                            <#if email?has_content>
                                <input type="text" name="mail" id="mail"  class="form-control" placeholder="Электронная почта" value="${email}" style="color: black;margin-top:10px"/>
                            <#else>
                                <input type="text" name="mail" id="mail"  class="form-control" placeholder="Электронная почта" value="" style="color: black;margin-top:10px"/>
                            </#if>
                        </div>


                        <div class="col-md-6">
                            <h3>Сменить пароль</h3>
                            <input type="password" name="password"  id="password" class="form-control" placeholder="Пароль" value="" style="color: black"/>
                        </div>

                    </div>


                    <div class = "row" style="margin-top:250px">
                        <br>
                        <input type="submit" name="reg" id="reg" value="Сохранить изменения" class="button" value=""/>
                        <br>
                        <p id="out"></p>
                    </div>

            </div>

        </div>
    </div>
</div>
</body>
</html>
</#macro>
<@main></@main>