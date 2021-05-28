<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Новости</title>

    <#-- CSS styles -->
    <link rel="stylesheet" href="<@spring.url "/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/style.css"/>">

    <#-- JQuery for AJAX -->
    <script src="<@spring.url "/static/js/jquery-3.3.1.min.js"/>"></script>
    <script src="<@spring.url "/static/js/news.js"/>"></script>
</head>

<body>
<#import "layouts/header.ftlh" as headerLayout>
<@headerLayout.header />

<div class="main-header-news">
    <div class="main-flex-rooms">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Новости</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="side-bar">
                    <div class="tags-item">
                        <h4>Поиск по тегам</h4>
                        <div class="tag-links">
                            <button class="tag-buttons" id="accommodation-tag" value="Жильё">Жильё</button>
                            <button class="tag-buttons" id="hotel-tag" value="Отель">Отель</button>
                            <button class="tag-buttons" id="events-tag" value="События">События</button>
                            <button class="tag-buttons" id="booking-tag" value="Бронирование">Бронирование</button>
                            <button class="tag-buttons" id="holidays-tag" value="Праздники">Праздники</button>
                            <button class="tag-buttons" id="news-tag" value="Новости">Новости</button>
                            <button class="tag-buttons" id="uncategorized-tag" value="Без рубрики">Без рубрики</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="w-100"></div>
            <div class="col-lg-8">
                <div class="blog-post" id="blog-post">
                    <#-- Сюда подставятся новости, которые имеют выбранный тег -->
                </div>
            </div>
        </div>
    </div>
</section>

<#import "layouts/footer.ftlh" as footer>
<@footer.footer />
</body>
</html>