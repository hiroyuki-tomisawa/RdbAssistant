-- テスト用の全てのデータ型を持つテーブル
CREATE TABLE TEST_ALL_TYPES
(
	ID NUMBER PRIMARY KEY,
	V_VARCHAR2 VARCHAR2(20),
	V_NVARCHAR2 NVARCHAR2(20),
	V_CHAR CHAR(20),
	V_NCHAR NCHAR(20),
	V_LONG LONG,
	V_CLOB CLOB,
	V_NUMBER NUMBER(10,3),
	V_BF BINARY_FLOAT,
	V_BD BINARY_DOUBLE,
	V_DATE DATE,
	V_TS TIMESTAMP,
	V_TSWT TIMESTAMP WITH TIME ZONE,
	V_TSWLT TIMESTAMP WITH LOCAL TIME ZONE,
	V_IYTM INTERVAL YEAR TO MONTH,
	V_IDTS INTERVAL DAY TO SECOND,
	V_RAW RAW(255),
	V_BLOB BLOB,
	V_BFILE BFILE,
	V_ROWID ROWID
)
