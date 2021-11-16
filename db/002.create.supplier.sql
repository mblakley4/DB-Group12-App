CREATE TABLE supplier (
    SupplierID INT NOT NULL,
    CompanyName VARCHAR(30),
    ContactLastName VARCHAR(20),
    ContactFirstName VARCHAR(20),
    Phone VARCHAR(20),
CONSTRAINT supplier_pk
    PRIMARY KEY (SupplierID)
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_supplier.csv'
INTO TABLE supplier
FIELDS TERMINATED BY ',';