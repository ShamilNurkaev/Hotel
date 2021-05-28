<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>
<@spring.bind "userDto" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><@spring.message 'sign_up_page.registration.title'/></title>

    <#-- CSS styles -->
    <link rel="stylesheet" href="<@spring.url "/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/signUp.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/style.css"/>">

    <#-- JS -->
    <script src="<@spring.url "/static/js/signUp.js"/>"></script>
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
                            <#assign firstNamePlaceholder>
                                <@spring.message 'sign_up_page.registration.placeholder.firstName'/>
                            </#assign>
                            <@spring.formInput "userDto.firstName" "class=form-control id='firstName'
                            name='firstName' placeholder=" + firstNamePlaceholder + " required"/>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <#assign lastNamePlaceholder>
                                <@spring.message 'sign_up_page.registration.placeholder.lastName'/>
                            </#assign>
                            <@spring.formInput "userDto.lastName" "class=form-control id='lastName'
                            name='lastName' placeholder=" + lastNamePlaceholder + " required"/>
                            <#if namesErrorMessage??>
                                <p class="error text-danger">${namesErrorMessage}</p>
                            </#if>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <@spring.formInput "userDto.email" "type='email' class=form-control id='email' name='email'
                                                placeholder='Email' required"/>
                            <@spring.showErrors "<br>", "error text-danger"/>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <#assign passwordPlaceholder>
                                <@spring.message 'sign_up_page.registration.placeholder.password'/>
                            </#assign>
                            <@spring.formPasswordInput "userDto.password" "class=form-control
                                id='password' name='password' placeholder=" + passwordPlaceholder +" required"/>
                            <@spring.showErrors "<br>", "error text-danger "/>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <#assign confirmPasswordPlaceholder>
                                <@spring.message 'sign_up_page.registration.placeholder.confirmPassword'/>
                            </#assign>
                            <@spring.formPasswordInput "userDto.confirmPassword" "class=form-control
                                id='confirmPassword' name='confirmPassword' placeholder=" +
                            confirmPasswordPlaceholder + " required"/>
                            <@spring.showErrors "<br>" "error"/>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="consent" required>
                            <label class="form-check-label" for="consent">
                                <@spring.message 'sign_up_page.registration.label.consent'/></label>
                            <br>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-outline-primary">
                            <@spring.message 'sign_up_page.registration.button.submit'/>
                        </button>
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <div>
                                <@spring.message 'sign_up_page.registration.text.haveAnAccount'/>
                                <a href="/signIn"> <@spring.message 'sign_up_page.registration.link.signIn'/></a>
                            </div>
                        </div>
                    </div>
                </div>
                <p></p>
                <#if duplicateEntryMessage??>
                    <h6 class="text-danger">${duplicateEntryMessage}</h6>
                </#if>
            </div>
            <p></p>
        </div>
    </form>
</div>
</body>
</html>
