<#ftl encoding='utf-8'/>
<!DOCTYPE html>
<html>

<#include "base.ftl"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Тесты</title>
    <style type="text/css">
        body {
            margin: 0;
        }

        #sidebar, #content {
            position: absolute;
        }

        #sidebar, #content {
            overflow: auto;
            padding: 10px;
        }

        #header {
            height: 80px;
            border-bottom: 2px solid #7B5427;
        }

        #header h1 {
            padding: 20px;
            margin: 0;
        }

        #sidebar {
            width: 150px;
            background: #ECF5E4;
            border-right: 1px solid #231F20;
            top: 82px;
            bottom: 0;
        }

        #content {
            top: 82px;
            left: 170px;
            bottom: 0;
            right: 0;
        }
    </style>
</head>


<body>
<div id="header"><h1>Тесты</h1></div>
<div id="sidebar">
    <#list tests as test>
        <p/> <a href="${url + "?testId=" + test.id}">${test.questionText}</a>
    </#list>
</div>
<div id="content">
    <#list tests as test>
        ${test.answerA}
        ${test.answerB}
        ${test.answerC}
        ${test.answerD}
    </#list>

</div>
</body>
</html>

