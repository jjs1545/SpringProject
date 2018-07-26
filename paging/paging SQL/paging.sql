#use myportal;

# 테스트를 위한 log 테이블 생성
DROP TABLE IF EXISTS log;
CREATE TABLE log (
	id INT PRIMARY KEY,
    log varchar(128) NOT NULL,
    created_at datetime
);

# 테스트를 위한 임시 데이터 생성
DELIMITER $$
DROP PROCEDURE IF EXISTS INIT_LOG_TABLE$$
CREATE PROCEDURE INIT_LOG_TABLE()
BEGIN
	DECLARE i INT DEFAULT 1;
    DECLARE logstr VARCHAR(100);
    
	TRUNCATE TABLE log;
    
    WHILE i <= 256 DO
		SET logstr = CONCAT("LOG ", i);
		INSERT INTO log VALUES(i, logstr, now());
		SET i = i + 1;
    END WHILE;
END$$

CALL INIT_LOG_TABLE();


