CREATE TABLE book (
    BookID INT NOT NULL,
    Title VARCHAR(30) NOT NULL,
    UnitPrice DECIMAL(8,2) NOT NULL,
    Author VARCHAR(50),
    Quantity INT DEFAULT 1,
    SupplierID INT,
    SubjectID INT,
CONSTRAINT book_pk
    PRIMARY KEY (BookID),
CONSTRAINT book_supplier_fk
    FOREIGN KEY (SupplierID)
    REFERENCES supplier (SupplierID)
    ON DELETE SET NULL,
CONSTRAINT book_subject_fk
    FOREIGN KEY (SubjectID)
    REFERENCES subject (SubjectID)
    ON DELETE SET NULL
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_book.csv'
INTO TABLE book
FIELDS TERMINATED BY ',';
