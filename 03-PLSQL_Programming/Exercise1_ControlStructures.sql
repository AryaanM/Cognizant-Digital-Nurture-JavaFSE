-- ==========================================
-- EXERCISE 1: CONTROL STRUCTURES
-- ==========================================

-- Enable console output for DBMS_OUTPUT
SET SERVEROUTPUT ON;

-- ==========================================
-- SCENARIO 1: Discount loan interest for customers > 60 years old
-- ==========================================
DECLARE
    v_age NUMBER;
BEGIN
    -- Loop through customers who have loans
    FOR rec IN (
        SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        -- Calculate age in years
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        
        -- Apply 1% discount if older than 60
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Scenario 1: 1% Discount applied for Customer ID: ' || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- ==========================================
-- SCENARIO 2: Set VIP status for balance > $10,000
-- ==========================================
-- First, alter the table since IsVIP is missing from the provided schema
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

BEGIN
    -- Loop through all customers
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) 
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Scenario 2: VIP status granted to Customer ID: ' || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- ==========================================
-- SCENARIO 3: Reminders for loans due in next 30 days
-- ==========================================
BEGIN
    -- Fetch loans where EndDate is within 30 days from today
    FOR rec IN (
        SELECT c.Name, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND (SYSDATE + 30)
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Scenario 3 Reminder: Loan for ' || rec.Name || ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/