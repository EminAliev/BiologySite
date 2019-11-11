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

</div>
<div id="content">
    <form method="post" class="test-form">
    <#list questions as question>
        <p>
        <h3> ${question.questionText}</h3>

        <p>
        <ul>
            <li>
                <input type="checkbox" name="option" value="answera"> ${question.answerA}
            </li>
            <li>
                <input type="checkbox" name="option" value="answerb"> ${question.answerB}
            </li>
            <li>
                <input type="checkbox" name="option" value="answerc"> ${question.answerC}
            </li>
            <li>
                <input type="checkbox" name="option" value="answerd"> ${question.answerD}
            </li>
        </ul></p>

    </#list>

        <input type="submit" class="button" value="Результаты">
    </form>
</div>
</body>
</html>

