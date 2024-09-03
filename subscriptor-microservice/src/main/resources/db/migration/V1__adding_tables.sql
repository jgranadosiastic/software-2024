create table subscriptor (
    email varchar(50) primary key,
    name varchar(50) not null
);

create table subscription (
    subscriptor_email varchar(50) not null references subscriptor(email),
    author_email varchar(50) not null,
    subscription_date date not null,
    with_notifications boolean not null,
    primary key(subscriptor_email, author_email)

);