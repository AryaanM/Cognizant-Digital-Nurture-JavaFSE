-- ==========================================
-- EXERCISE 3: STORED PROCEDURES
-- ==========================================

SET SERVEROUTPUT ON;

-- ==========================================
-- SCENARIO 1: Process monthly interest for Savings accounts
-- ==========================================
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Apply 1% interest to the current balance of all Savings accounts
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 1: Monthly interest of 1% applied to all Savings accounts.');
END ProcessMonthlyInterest;
/

-- ==========================================
-- SCENARIO 2: Implement a bonus scheme for employees
-- ==========================================
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
BEGIN
    -- Update salary by adding the bonus percentage for a specific department
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percent / 100))
    WHERE Department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 2: Bonus of ' || p_bonus_percent || '% applied to department: ' || p_department);
END UpdateEmployeeBonus;
/

-- ==========================================
-- SCENARIO 3: Transfer funds with balance check
-- ==========================================
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_current_balance NUMBER;
BEGIN
    -- Fetch the current balance of the source account
    SELECT Balance INTO v_current_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    -- Check if the source account has sufficient funds
    IF v_current_balance >= p_amount THEN
        
        -- Deduct amount from source account
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;
        
        -- Add amount to destination account
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Scenario 3 Success: Transferred $' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Scenario 3 Error: Insufficient funds in Account ' || p_from_account);
    END IF;

EXCEPTION
    -- Handle case where the account ID does not exist
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Scenario 3 Error: Invalid Account ID provided.');
END TransferFunds;
/