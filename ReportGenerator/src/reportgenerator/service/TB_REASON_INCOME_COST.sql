/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  VSI-ANIK
 * Created: Jul 23, 2020
 */

---- CREATE TABLE
CREATE TABLE TB_REASON_INCOME_COST (
ID	   		 NUMBER NOT NULL UNIQUE,
REASON   VARCHAR2(250 BYTE)
);


---  INSERT DATA IN TABLE
INSERT INTO TB_REASON_INCOME_COST (ID,REASON) 
VALUES (1,'instrument');


--- CREATE TRIGGER
CREATE OR REPLACE TRIGGER AUTO_INCREMENT_REASON_ID
BEFORE INSERT
	   ON TB_REASON_INCOME_COST
	   FOR EACH ROW
	   
DECLARE
	   TEMP_VER NUMBER:=0;

BEGIN
	 SELECT MAX(ID) INTO TEMP_VER FROM TB_REASON_INCOME_COST;
	 :NEW.ID:=(TEMP_VER+1);
END;
/

--- SELECT DATA
SELECT * FROM TB_REASON_INCOME_COST