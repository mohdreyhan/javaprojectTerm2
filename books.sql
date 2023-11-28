CREATE TABLE Books (
    id int,
    title varchar(50),
    author varchar(50),
    price float8,
    qty int
);

INSERT INTO Books (id, title, author, price, qty) VALUES
(1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11),
(1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22),
(1003, 'More Java for more dummies', 'Mohammed Ali', 33.33, 33),
(1004, 'A cup of java', 'Kumar', 44.44, 44),
(1005, 'A teaspoon of java', 'Kevin', 55.55, 55);

select * from Books;