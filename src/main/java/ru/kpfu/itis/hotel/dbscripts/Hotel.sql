CREATE TABLE user_hotel
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(30),
    last_name     VARCHAR(30),
    email         VARCHAR(30),
    hash_password VARCHAR(100),
    rooms_id      VARCHAR
);

SELECT *
FROM user_hotel;

SELECT *
FROM room_hotel;

CREATE TABLE room_hotel
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30),
    photo         VARCHAR(500),
    date_from     BIGINT,
    date_to       BIGINT,
    rooms_number  INTEGER,
    adults_number INTEGER,
    child_number  INTEGER,
    price         INTEGER
);

INSERT INTO room_hotel (id, name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES (1, 'room1', '/static/img/room/rooms-1.jpg', 12345, 123456, 3, 3, 3, 5000);
INSERT INTO room_hotel (id, name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES (2, 'room1', '/static/img/room/rooms-2.jpg', 12345, 123456, 1, 1, 1, 9990);
INSERT INTO room_hotel (id, name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES (3, 'room1', '/static/img/room/rooms-3.jpg', 12345, 123456, 3, 3, 3, 19990);
INSERT INTO room_hotel (id, name, photo, date_from, date_to, rooms_number, adults_number, child_number, price)
VALUES (4, 'room1', '/static/img/room/rooms-4.jpg', 12345, 123456, 3, 3, 3, 4500);

CREATE TABLE news_hotel
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(100),
    description VARCHAR(500),
    photo       VARCHAR(500)
);
SELECT *
FROM news_hotel;

INSERT INTO news_hotel (id, title, description, photo)
VALUES (1, 'Вот что Вам нужно знать при поездке на отдых.', 'Lorem ipsum ...', '/static/img/blog/blog-1.jpg'),
       (2, 'Скоро у нас открытие кофейни.', 'Lorem ipsum ...', '/static/img/blog/blog-2.jpg'),
       (3, 'Новый класс комнат в нашем отеле.', 'Lorem ipsum ...', '/static/img/blog/blog-3.jpg');

CREATE TABLE tag_hotel
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(30)
);
SELECT *
FROM tag_hotel;

INSERT INTO tag_hotel
VALUES (1, 'Жильё'),
       (2, 'Отель'),
       (3, 'События'),
       (4, 'Бронирование'),
       (5, 'Праздники'),
       (6, 'Новости'),
       (7, 'Без рубрики');

CREATE TABLE news_tag
(
    news_id BIGINT REFERENCES news_hotel (id),
    tag_id  BIGINT REFERENCES tag_hotel (id),
    CONSTRAINT news_tag_pkey PRIMARY KEY (news_id, tag_id)
);

INSERT INTO news_tag
VALUES (1, 3),
       (1, 4),
       (2, 2),
       (2, 3),
       (2, 6),
       (3, 1),
       (3, 2),
       (3, 6);

WITH _news_title_tag AS (
    SELECT news.id, news.title, news.description, news.photo, news_tag.tag_id
    FROM news_hotel news
             LEFT JOIN news_tag on news.id = news_tag.news_id)
SELECT ntt.id, ntt.title, ntt.description, ntt.photo
FROM _news_title_tag ntt
         INNER JOIN tag_hotel tag ON tag.id = ntt.tag_id
WHERE tag.tag_name = :tag_name;

-- auto-generated definition
create table spring_session
(
    primary_id            char(36) not null
        constraint spring_session_pk
            primary key,
    session_id            char(36) not null,
    creation_time         bigint   not null,
    last_access_time      bigint   not null,
    max_inactive_interval integer  not null,
    expiry_time           bigint   not null,
    principal_name        varchar(100)
);

alter table spring_session
    owner to postgres;

create unique index spring_session_ix1
    on spring_session (session_id);

create index spring_session_ix2
    on spring_session (expiry_time);

create index spring_session_ix3
    on spring_session (principal_name);

-- auto-generated definition
create table spring_session_attributes
(
    session_primary_id char(36)     not null
        constraint spring_session_attributes_fk
            references spring_session
            on delete cascade,
    attribute_name     varchar(200) not null,
    attribute_bytes    bytea        not null,
    constraint spring_session_attributes_pk
        primary key (session_primary_id, attribute_name)
);

alter table spring_session_attributes
    owner to postgres;

SELECT bh.room_id
FROM booking_hotel bh
GROUP BY bh.room_id
HAVING bh.room_id = MAX(bh.room_id);


WITH _popular_rooms AS (
    SELECT * FROM (SELECT bh.room_id, COUNT(bh.room_id) as count
    FROM booking_hotel bh
    GROUP BY bh.room_id) AS a
    GROUP BY a.room_id
    HAVING a.count = MAX(a.count)
)
SELECT rh.id,
       rh.adults_number,
       rh.child_number,
       rh.date_from,
       rh.date_to,
       rh.name,
       rh.photo,
       rh.price,
       rh.rooms_number,
       rh.user_id
FROM room_hotel rh
         INNER JOIN _popular_rooms _pr ON rh.id = _pr.room_id


