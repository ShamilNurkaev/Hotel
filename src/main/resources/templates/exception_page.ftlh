<#ftl encoding="UTF-8"/>
    <html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Страница ошибки</title>

    <#-- CSS styles -->
    <link rel="stylesheet" href="<@spring.url "/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/style.css"/>">
</head>

<body>
<#import "layouts/header.ftlh" as headerLayout>
<@headerLayout.header />

<div class="main-header">
    <div class="main-flex">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Что-то пошло не так. Ошибка на сервере.</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#import "layouts/footer.ftlh" as footer>
<@footer.footer />
</body>
