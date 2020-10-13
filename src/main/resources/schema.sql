create table IF NOT EXISTS calcDate(
 dateId varchar(10) not null primary key,
 dateName varchar(10) ,
 valueYear int not null default 0,
 valueMonth int not null default 0,
 valueDay int not null default 0
);