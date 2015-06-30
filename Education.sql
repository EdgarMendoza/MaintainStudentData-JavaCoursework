DROP TABLE Student;

CREATE TABLE Student
(
	studentID INT NOT NULL,
	firstName varchar(25) NOT NULL,
	lastName varchar(25) NOT NULL,
	Major char(4),
	Email varchar(30) NOT NULL,
	Phone char(11),
	birthdate DATE NOT NULL,
	Address varchar(100) NOT NULL,
	zipCode char(5) NOT NULL,
	PRIMARY KEY (studentID)
);

INSERT INTO Student (studentID, firstName, lastName, Major, Email, Phone, birthdate, Address, zipCode) VALUES
	(444111110, 'Jacob', 'Smith', 'INSY', 'jacob.smith@mavs.uta.edu', '9129219434', '1985-04-09', '99 Kingston Street', '31435'),
	(444111111, 'John', 'Stevenson', 'MANA', 'john.stevenson@mavs.uta.edu', NULL, '1988-05-10', '100 Main Street', '31411'),
	(444111112, 'George', 'Heintz', 'INSY', 'george.heintz@mavs.uta.edu', '9129213454', '1974-10-10', '1200 Abercorn Street', '31419'),
	(444111113, 'Frank', 'Jones', 'FINA', 'frank.jones@mavs.uta.edu', '9125919434', '1970-09-09', '100 Main Street', '31411'),
	(444111114, 'Jean', 'Smith', 'ECON', 'jean.smith@mavs.uta.edu', '9129219434', '1970-02-09', '100 Main Street', '31411'),
	(444111115, 'John', 'Woo', 'MANA', 'josh.woo@mavs.uta.edu', '7075989434', '1970-02-09', '555 Franklin Street', '31411');