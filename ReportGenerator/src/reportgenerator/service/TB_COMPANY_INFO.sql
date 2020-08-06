/**
 * Author:  VSI SERVER
 * Created: Aug 6, 2020
 */

CREATE TABLE TB_COMPANY_INFO
(
  COMID           NUMBER,
  COMPANY         VARCHAR2(255 BYTE)            NOT NULL,
  ADDRESS         VARCHAR2(255 BYTE),
  COMLOGO         BLOB,
  ISOLOGO         BLOB
)
