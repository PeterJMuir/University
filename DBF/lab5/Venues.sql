CREATE TABLE Venues
(venueID VARCHAR2(6) NOT NULL,
venueName VARCHAR2(50),
venueAddress VARCHAR2(70),
venueCapacity NUMBER(4) NOT NULL,
costPerDay NUMBER(7,2),
venueManager VARCHAR2(50),
managerPhoneNo VARCHAR2(15),
PRIMARY KEY (venueID));

INSERT INTO Venues
(venueID, venueName, venueAddress, venueCapacity, costPerDay, venueManager, managerPhoneNo)
VALUES
('V00001', 'Town Hall', '15 High St, Local Town', 800, 650.00, 'Sean O''Riley', '9333 2498');

INSERT INTO Venues
(venueID, venueName, venueAddress, venueCapacity, costPerDay, venueManager, managerPhoneNo)
VALUES
('V00002', 'Lyndhurst Street Community Centre', '12 Lyndhurst St, Local Town', 170, 310.00, 'Kylie Ong', '9333 1212');

INSERT INTO Venues
VALUES
('V00003', 'Local Town Community Theatre', '146 Main Rd, Local Town', 650, 1500.00, 'James McPhee', '9333 8569');

INSERT INTO Venues
(venueID, venueName, venueAddress, costPerDay, venueManager, venueCapacity)
VALUES
('V00004', 'Glass Street Scout Hall', '6 Grange Rd, Local Town', 20.00, 'Jesse Olson', 420);

CREATE TABLE Event
(eventId VARCHAR2(10) NOT NULL,
eventName VARCHAR2(100),
eventDescription VARCHAR2(200),
venueCapacityRequired NUMBER(4) NOT NULL,
cateringRequired CHAR(1) CHECK (cateringRequired = 'y' OR cateringRequired = 'n'),
venueID VARCHAR2(6) NOT NULL,
PRIMARY KEY (eventId),
FOREIGN KEY (venueID) REFERENCES Venues(venueID));

INSERT INTO Event
VALUES
('E00001', 'Andrew''s Fun Time', 'It''s a gay old time', 400,'n','V00004');

INSERT INTO Event
(eventID, eventName, eventDescription, venueCapacityRequired, cateringRequired, venueID)
VALUES
('E00002', 'Little Athletic''s Trivia Night', 'Fundraiser for the local little athletics club', 250, 'n', 'V00001');

ALTER TABLE Event
MODIFY eventId VARCHAR2(6);

ALTER TABLE Venues
DROP (venueManager);

ALTER TABLE Venues
ADD (streetAddress VARCHAR2(100), addressCity VARCHAR2 (100), addressPostcode VARCHAR2(6));

ALTER TABLE Venues
MODIFY venueName VARCHAR2(5);

UPDATE Venues
SET streetAddress = '12 Lyndhurst St'
WHERE venueID = 'V00001';

DELETE FROM Venues
WHERE venueID = 'V00002';

DELETE FROM Venues
WHERE venueID = 'V00001';

DROP TABLE Venues CASCADE CONSTRAINTS;

PURGE RECYCLEBIN;

COLUMN eventID FORMAT a8 HEADING 'Event ID' WORD_WRAPPED
COLUMN eventName FORMAT a50 heading 'Event Name' WORD_WRAPPED
COLUMN eventDescription FORMAT a60 heading 'Event|Description' WORD_WRAPPED;
COLUMN venueCapacityRequired FORMAT 9999 heading 'Venue|Capacity|Required' JUSTIFY left;