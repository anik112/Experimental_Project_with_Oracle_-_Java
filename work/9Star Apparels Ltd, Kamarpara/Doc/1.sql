conn system/manager@payroll
drop user test cascade;
create user test identified by test default tablespace users temporary tablespace temp;
grant dba to test;
alter database datafile 'D:\Oracle\ORADATA\PAYROLL\TEMP01.DBF' resize 500M;
alter database datafile 'D:\Oracle\ORADATA\PAYROLL\USERS01.DBF' resize 200M;
alter tablespace users add datafile 'D:\Oracle\ORADATA\PAYROLL\USERS02.DBF' size 700M;
exit;