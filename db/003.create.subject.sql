CREATE TABLE subject (
    SubjectID INT NOT NULL,
    CategoryName VARCHAR(20),
CONSTRAINT subject_pk
    PRIMARY KEY (SubjectID)
);

LOAD DATA LOCAL INFILE '..../docs/csv/db_subject.csv'
INTO TABLE subject
FIELDS TERMINATED BY ',';