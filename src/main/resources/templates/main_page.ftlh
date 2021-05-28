<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Главная</title>

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
                            <h1>Надеемся, что вам понравится пребывание у нас.</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="follow-instagram">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Присоединяйтесь к нам в Instagram @hotel</h2>
            </div>
        </div>
    </div>
</section>

<div class="footer-room-pic">
    <div class="container-fluid">
        <div class="row">
            <img src="/static/img/room-footer-pic/room-1.jpg" alt="">
            <img src="/static/img/room-footer-pic/room-2.jpg" alt="">
            <img src="/static/img/room-footer-pic/room-3.jpg" alt="">
            <img src="/static/img/room-footer-pic/room-4.jpg" alt="">
        </div>
    </div>
</div>

<#import "layouts/footer.ftlh" as footer>
<@footer.footer />

</body>
</html>
