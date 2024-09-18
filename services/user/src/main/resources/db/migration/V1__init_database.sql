create table if not exists USER_TABLE (
    id bigint not null primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    birthdate date not nulL
);

create sequence if not exists user_table_seq increment by 50;