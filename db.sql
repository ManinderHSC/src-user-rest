DROP TABLE users_tbl1;
CREATE TABLE users_tbl1(id INT auto_increment, name VARCHAR(100),age INT,address1 VARCHAR(100),address2 VARCHAR(50));

CREATE INDEX name_index ON users_tbl1(name);
CREATE INDEX age_index ON users_tbl1(age);
