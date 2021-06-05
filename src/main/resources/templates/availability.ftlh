<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset='UTF-8'>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Бронирование</title>

    <#-- CSS styles -->
    <link rel="stylesheet" href="<@spring.url "/static/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<@spring.url "/static/css/style.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<@spring.url "https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>"/>

    <#-- JQuery for AJAX, Date Range Picker's files -->
    <script src="<@spring.url "/static/js/jquery-3.3.1.min.js"/>"></script>
    <script src="<@spring.url "/static/js/allAvailableRooms.js"/>"></script>

    <#-- Date Range Picker's files -->
    <script type="text/javascript"
            src="<@spring.url "https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"/>"></script>
    <script type="text/javascript"
            src="<@spring.url "https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"/>"></script>
    <script src="<@spring.url "/static/js/daterange.js"/>"></script>
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
                            <h1>Бронирование</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="room-availability spad">
    <div class="container">
        <div class="room-check">
            <div class="row">
                <div class="col-mg-6">
                    <div class="check-form">
                        <h2>Проверить наличие свободных мест</h2>
                        <div>
                            <div class="datepicker">
                                <div class="date-select">
                                    <label for="daterange"><p>Дата заезда и дата выезда</p></label>
                                    <input type="text" id="daterange" name="daterange"/>
                                </div>
                            </div>
                            <div class="room-quantity">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <div class="single-quantity">
                                            <label for="rooms-number"><p>Комнаты</p></label>
                                            <select id="rooms-number" name="rooms-number">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="single-quantity">
                                        <div class="col-lg-4">
                                            <label for="adults-number"><p>Взрослые</p></label>
                                            <select id="adults-number" name="adults-number">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="single-quantity">
                                        <div class="col-lg-4">
                                            <label for="child-number"><p>Дети</p></label>
                                            <select id="child-number" name="child-number">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button id="check-available-rooms-btn" name="check-available-rooms-btn">
                                ПРОВЕРИТЬ
                            </button>
                            <p></p>
                            <button id="popular-rooms-btn" name="popular-rooms-btn">
                                Most Popular Rooms
                            </button>
                            <p></p>
                            <#if noAvailableRooms??>
                                <h6 class="text-danger">${noAvailableRooms}</h6>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="about-room">
            <div class="row">
                <div class="col-lg-10 offset-lg-1">
                    <h2>“Клиенты могут забыть, что вы сказали, но они никогда не забудут, что вы заставили их
                        почувствовать”.</h2>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="room-section spad">
    <div class="container" id="popular-rooms">

    </div>
</section>

<section class="room-section spad">
    <div class="container" id="available-rooms">
        <#-- Сюда подставятся свободные комнаты  -->
    </div>
</section>


<#import "layouts/footer.ftlh" as footer>
<@footer.footer />
</body>
</html>