CREATE TABLE PRODUCT
(
    ID               BIGSERIAL      NOT NULL PRIMARY KEY,
    TITLE            VARCHAR(255)   NOT NULL,
    COST             DECIMAL(10, 2) NOT NULL,

    UNIQUE (TITLE)
);


select * from product where ID = 10;

select p from Product p
