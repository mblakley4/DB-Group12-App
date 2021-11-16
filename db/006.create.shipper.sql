CREATE TABLE shipper (
    ShipperID INT NOT NULL,
    ShipperName VARCHAR(30),
CONSTRAINT shipper_pk
    PRIMARY KEY (ShipperID)
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_shipper.csv'
INTO TABLE shipper
FIELDS TERMINATED BY ',';