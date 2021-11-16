CREATE TABLE group12db.order (
    OrderID INT NOT NULL,
    CustomerID INT NOT NULL,
    EmployeeID INT,
    OrderDate DATE,
    ShippedDate DATE,
    ShipperID INT,
CONSTRAINT order_pk
    PRIMARY KEY (OrderID),
CONSTRAINT order_customer_fk
    FOREIGN KEY (CustomerID)
    REFERENCES customer (CustomerID)
    ON DELETE CASCADE,
CONSTRAINT order_employee_fk
    FOREIGN KEY (EmployeeID)
    REFERENCES employee (EmployeeID)
    ON DELETE SET NULL,
CONSTRAINT order_shipper_fk
    FOREIGN KEY (ShipperID)
    REFERENCES shipper (ShipperID)
    ON DELETE SET NULL
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_order.csv'
INTO TABLE group12db.order
FIELDS TERMINATED BY ',';