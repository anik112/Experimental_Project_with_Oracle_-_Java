/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Anik
 * Created: Jul 13, 2020
 */
CREATE TABLE TB_ADVANCE_AMOUNT (
ID          NUMBER NOT NULL UNIQUE,
SUB_DATE        VARCHAR2(50 BYTE),
EMP_NAME    VARCHAR2(250 BYTE),
AMOUNT      FLOAT(2),
COST        FLOAT(2),
CASH_IN_HAND    FLOAT(2),
AUTHORIZED      VARCHAR2(10 BYTE));


----- CREATE TRIGGER
CREATE OR REPLACE TRIGGER AUTO_INCREMENT_ID
BEFORE INSERT
   ON TB_ADVANCE_AMOUNT
   FOR EACH ROW
   
DECLARE
   TEMPVAR NUMBER:=0;

BEGIN
   SELECT MAX(ID) INTO TEMPVAR FROM TB_ADVANCE_AMOUNT;
   :NEW.ID:=(TEMPVAR+1);
END;
/