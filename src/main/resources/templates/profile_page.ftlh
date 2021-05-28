<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset='UTF-8'>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль</title>

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
                            <form>
                                <div class="form-group">
                                    <label for="first-name">Имя</label>
                                    <h5 id="first-name">
                                        <#if FirstName??>
                                            ${FirstName}
                                        </#if>
                                    </h5>
                                </div>
                                <div class="form-group">
                                    <label for="last-name">Фамилия</label>
                                    <h5 id="last-name">
                                        <#if LastName??>
                                            ${LastName}
                                        </#if>
                                    </h5>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <h5 id="email">
                                        <#if Email??>
                                            ${Email}
                                        </#if>
                                    </h5>
                                </div>
                                <a href="/logout" class="btn btn-primary">
                                    Выйти из аккаунта
                                </a>
                                <a href="/profile/edit" class="btn btn-primary">
                                    Редактировать профиль
                                </a>
                            </form>
                            <p></p>
                            <form method="post">
                                <button class="btn btn-danger" type="submit">Удалить аккаунт</button>
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