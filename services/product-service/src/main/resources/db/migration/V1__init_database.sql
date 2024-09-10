CREATE TABLE IF NOT EXISTS category
(
    id integer not null primary key,
    description varchar(255),
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS product
(
    id integer not null primary key,
    description varchar(255),
    name varchar(255),
    available_quantity double precision not null,
    price numeric(38, 2),
    category_id integer,
    foreign key (category_id) references category (id)
);

CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50;
CREATE SEQUENCE IF NOT EXISTS product_seq INCREMENT BY 50;