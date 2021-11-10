LOAD DATA INFILE '.../db_book.csv'
INTO TABLE book
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_customer.csv'
INTO TABLE customer
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_employee.csv'
INTO TABLE employee
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_order.csv'
INTO TABLE order
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_order_detail.csv'
INTO TABLE detail
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_shipper.csv'
INTO TABLE shipper
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_subject.csv'
INTO TABLE subject
FIELDS TERMINATED BY ',';

LOAD DATA INFILE '.../db_supplier.csv'
INTO TABLE supplier
FIELDS TERMINATED BY ',';