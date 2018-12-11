CREATE OR REPLACE FUNCTION year_cost(yr IN VARCHAR2) RETURN NUMBER IS
v_total_cost NUMBER;
BEGIN
SELECT SUM(totalCostVenue + NVL(totalCostEquip,0) + NVL(totalCostCatSec,0)) AS "Total Cost"
INTO v_total_cost
FROM
			(SELECT EV.eventID, SUM(V.costPerDay) AS totalCostVenue
			FROM EventVenues EV, Venues V
			WHERE EV.venueID = V.venueID
			 AND TO_CHAR(EV.bookingDate, 'YYYY') = yr
			GROUP BY EV.eventID) R1,
			(SELECT EE.eventID,
			 SUM(EE.unitPrice * EE.quantity * EE.noOfDays) AS totalCostEquip
			 FROM EventEquipments EE
			GROUP BY eventID) R2,
			(SELECT ES.eventID, SUM (ES.eventCharge) AS totalCostCatSec
			FROM EventServices ES
			GROUP BY ES.eventID) R3
WHERE R1.eventID = R2.eventID(+)
AND R2.eventID = R3.eventID(+);

RETURN v_total_cost;
END year_cost;
/

SELECT DISTINCT TO_CHAR(BOOKINGDATE, 'YYYY'), year_cost(TO_CHAR(BOOKINGDATE, 'YYYY')) AS "YEARCOST"
FROM EVENTVENUES;




CREATE OR REPLACE FUNCTION sellStatus (inputEventID     IN Events.eventID%TYPE)
RETURN VARCHAR2 IS
numAvailTickets NUMBER;
numEventTimes NUMBER;
numSoldTickets NUMBER;
numRemTickets NUMBER;
BEGIN

SELECT E.venueCapacityRequired
INTO numAvailTickets
FROM Events E
WHERE E.eventID = inputEventID;

SELECT COUNT(*)
INTO numEventTimes
FROM EVENTVENUES
WHERE eventID = inputEventID;

SELECT COUNT(T.ticketNumber) 
INTO numSoldTickets
FROM Tickets T
WHERE T.eventID = inputEventID
GROUP BY T.eventID;

numRemTickets := numAvailTickets*numEventTimes – numSoldTickets;

IF numRemTickets = 0 THEN
	RETURN 'Sold Out!';
ELSIF (numAvailTickets / numRemTickets) >= 4 THEN
	RETURN 'Get in Quick!';
ELSIF (numAvailTickets / numRemTickets) >= 2 THEN
	RETURN 'Selling Steadily';
ELSE
	RETURN 'More Promotion Required!';
END IF;
END sellStatus;
/

sELECT DISTINCT EVENTid, sellStatus(EVENTid) AS "STATUS"
fROM EVENTvenues
wHERE BOOKINGdATE >= tO_date('2008', 'YYYY');


CREATE OR REPLACE TRIGGER checkPromoter
BEFORE INSERT ON Promoters
FOR EACH ROW
DECLARE  promoterCount INTEGER;
BEGIN
	SELECT COUNT(*)
	INTO promoterCount
	FROM Promoters
	WHERE promoterBusinessName = :new.promoterBusinessName
	AND streetaddress = :new.streetaddress
	AND suburb = :new.suburb
	AND postcode = :new.postcode;
	
	IF promoterCount > 0 THEN
		RAISE_APPLICATION_ERROR(-20000,'Promoter with those details already exists');
	END IF;
	
END checkPromoter;
/

INSERT INTO Promoters(promoterID, promoterBusinessName, streetaddress, suburb, postcode)
VALUES('P00005','Coffee by the Lake', '79 Mahoney Rd', 'Fisherman''s Bend', '1003');

CREATE OR REPLACE TRIGGER checkCapacity
BEFORE INSERT ON  EVENTVENUES
FOR EACH ROW
DECLARE
	capacity INTEGER;
	capacityReq INTEGER;
BEGIN
SELECT venueCapacityRequired
INTO capacity
FROM Events
WHERE :new

END checkCapacity;
/
	
	
	