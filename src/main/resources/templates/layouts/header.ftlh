<#macro header>
    <header>
        <div class="header-section">
            <div class="menu">
                <div class="container">
                    <div class="row">
                        <div class="col-md-5" style="max-width: 400px">
                            <nav>
                                <ul>
                                    <li><a href="/main">Главная</a></li>
                                    <li><a href="/availability">Бронирование</a></li>
                                </ul>
                            </nav>
                        </div>
                        <span style="margin: auto">
                        <div class="top-phone-num">
                            <img src="/static/img/phone.png" alt="">
                            <span>+7 (999) 000-54-54</span>
                        </div>
                    </span>
                        <div class="col-md-5" style="max-width: 400px">
                            <nav>
                                <#if  isAuthenticated?? && isAuthenticated == true>
                                    <li><a href="/profile">Профиль</a></li>
                                    <li><a href="/news">Новости</a></li>
                                <#else>
                                    <ul>
                                        <li><a href="/signUp">Регистрация</a></li>
                                        <li><a href="/signIn">Вход</a></li>
                                    </ul>
                                </#if>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
</#macro>