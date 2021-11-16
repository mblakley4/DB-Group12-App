CREATE TABLE order_detail (
    BookID INT NOT NULL,
    OrderID INT NOT NULL,
    Quantity INT NOT NULL,
CONSTRAINT order_detail_pk
    PRIMARY KEY (BookID, OrderID),
CONSTRAINT order_detail_book_fk
    FOREIGN KEY (BookID)
    REFERENCES book (BookID)
    ON DELETE CASCADE,
CONSTRAINT order_detail_order_fk
    FOREIGN KEY (OrderID)
    REFERENCES group12db.order (OrderID)
    ON DELETE CASCADE
);

LOAD DATA LOCAL INFILE '.../docs/csv/db_order_detail.csv'
INTO TABLE order_detail
FIELDS TERMINATED BY ',';