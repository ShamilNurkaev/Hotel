<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset='UTF-8'>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>

    <link rel="stylesheet" href="<@spring.url "/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/signUp.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/style.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/signIn.css"/>">
</head>

<body>
<h2><a href="?lang=ru">РУ</a></h2>
<h2><a href="?lang=en">EN</a></h2>
<div class="d-flex justify-content-center align-items-center flex-column">
    <form action="" method="post">
        <div class="form-group">
            <div class="container">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="E-mail" required>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Пароль" required>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" id="remember-me" name="remember-me" type="checkbox">
                            <label class="form-check-label" for="remember-me">Запомнить меня</label>
                            <br>
                        </div>
                    </div>
                </div>
                <br>

                <div class="row justify-content-center">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-outline-primary">
                            Войти
                        </button>
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <div>
                                У вас ещё нет аккаунта?
                                <a href="/signUp">Регистрация</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <div>
                                Или
                                <a href="http://oauth.vk.com/authorize?client_id=7862886&redirect_uri=http://localhost:8080/auth/vk&response_type=code&scope=email&v=5.130">Авторизация через ВКонтакте</a>
                            </div>
                        </div>
                    </div>
                </div>
                <p></p>
                <#if wrongEmailOrPasswordMessage??>
                    <h6 class="text-danger">${wrongEmailOrPasswordMessage}</h6>
                </#if>
            </div>
        </div>
    </form>
</div>
</body>
</html>