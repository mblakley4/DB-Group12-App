CREATE TABLE customer (
    CustomerID INT NOT NULL,
    LastName VARCHAR(20),
    FirstName VARCHAR(20),
    Phone VARCHAR(20),
CONSTRAINT customer_pk
    PRIMARY KEY (CustomerID)
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_customer.csv'
INTO TABLE customer
FIELDS TERMINATED BY ',';