<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset='UTF-8'>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Редактирование</title>

    <#-- CSS styles -->
    <link rel="stylesheet" href="<@spring.url "/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/style.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/profile.css"/>">
</head>

<body>
<#import "layouts/header.ftlh" as headerLayout>
<@headerLayout.header />

<div class="main-header-rooms">
    <div class="main-flex-rooms">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Профиль</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="room-availability spad">
    <div class="container">
        <div class="row gutters-sm">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body tab-content">
                        <div class="tab-pane active" id="profile">
                            <hr>
                            <form action="" method="post">

                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                                <div class="form-group">
                                    <label for="firstName">Имя</label>
                                    <br>
                                    <input id="firstName" name="firstName" value="${FirstName}">
                                </div>
                                <div class="form-group">
                                    <label for="lastName">Фамилия</label>
                                    <br>
                                    <input id="lastName" name="lastName" value="${LastName}">
                                </div>
                                <button type="submit" class="btn btn-primary">Сохранить изменения</button>
                                <a href="/profile" class="btn btn-danger">Отменить редактирование</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<#import "layouts/footer.ftlh" as footer>
<@footer.footer />
</body>
</html>