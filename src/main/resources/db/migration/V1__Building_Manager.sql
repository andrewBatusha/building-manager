create table buildings
(
    id          serial      not null
        constraint buildings_pkey
            primary key,
    geolocation varchar(255),
    name        varchar(35) not null
);

alter table buildings
    owner to qkyntoodxhgifg;

create table employees
(
    id            serial      not null
        constraint employees_pkey
            primary key,
    email         varchar(40)
        constraint uk_j9xgmd0ya5jmus09o0b8pqrpb
            unique,
    name          varchar(35) not null,
    patronymic    varchar(35) not null,
    position_name varchar(35) not null,
    salary        serial,
    surname       varchar(35) not null,
    time_type     varchar(255),
    building_id   serial
        constraint fkcn3eqktgq9h0sm6lrwgf5t3dh
            references buildings
);

alter table employees
    owner to qkyntoodxhgifg;

create table equipments
(
    id          serial      not null
        constraint equipments_pkey
            primary key,
    name        varchar(35) not null,
    price       serial,
    quantity    serial,
    building_id serial      not null
        constraint fkcg110843e2yjp5l8dsjeeq4u4
            references buildings,
    employee_id serial
        constraint fkocd869ruac1gh4mn48xm5jlx8
            references employees
);

alter table equipments
    owner to qkyntoodxhgifg;

create table ledgers
(
    id                  serial      not null
        constraint ledgers_pkey
            primary key,
    bookkeeping         varchar(255),
    due_time            timestamp,
    name                varchar(35) not null,
    price               serial,
    procurement_type    varchar(255),
    quantity            serial,
    unit_of_measurement varchar(255),
    building_id         serial      not null
        constraint fkh9pf0ifm43qrf0cdyhssld8gu
            references buildings
);

alter table ledgers
    owner to qkyntoodxhgifg;

create table warehouses
(
    id                  serial      not null
        constraint warehouses_pkey
            primary key,
    name                varchar(35) not null,
    quantity            serial,
    unit_of_measurement varchar(255),
    building_id         serial      not null
        constraint fkl8181ccrg6ydrp1xwbh06vtqu
            references buildings
);

alter table warehouses
    owner to qkyntoodxhgifg;

