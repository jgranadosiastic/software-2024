create table author (
    email varchar(50) primary key,
    name varchar(50) not null,
    profession varchar(50) not null,
    about varchar(50)
);

create table article (
    id varchar(150) primary key,
    title varchar(50) not null,
    description varchar(50),
    author_email varchar(50) not null references author(email),
    content varchar(3000) not null,
    publication_date date not null,
    active boolean not null,
    visible boolean not null
);