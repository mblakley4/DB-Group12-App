CREATE TABLE employee (
    EmployeeID INT NOT NULL,
    LastName VARCHAR(20),
    FirstName VARCHAR(20),
CONSTRAINT employee_pk
    PRIMARY KEY (EmployeeID)
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_employee.csv'
INTO TABLE employee
FIELDS TERMINATED BY ',';