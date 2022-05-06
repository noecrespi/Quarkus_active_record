drop table persona if exists;
create table persona (
    id bigint generated by default as identity,
    name varchar(255) not null,
    primary key (id)
);

insert into
    persona (name)
    values
    ('Víctor');