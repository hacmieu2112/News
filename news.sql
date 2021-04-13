CREATE DATABASE News

CREATE TABLE users (
  id int NOT NULL PRIMARY KEY,
  username varchar(50) NOT NULL,
  password varchar(40) NOT NULL,
  fullname varchar(50) NOT NULL,
)

CREATE TABLE categories (
  id int NOT NULL PRIMARY KEY,
  name varchar(200) NOT NULL
) 

CREATE TABLE new (
  id int NOT NULL PRIMARY KEY,
  category_id int NOT NULL FOREIGN KEY REFERENCES dbo.categories(id),
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  detail text NOT NULL,
  image varchar(255) NOT NULL,
  date DATE NOT NULL,
  user_id int NOT NULL FOREIGN KEY REFERENCES dbo.users(id),
  viewtime int NOT NULL
)



--Test
UPDATE dbo.new
SET name = 'Kill friend to get money for play game',
description = 'This is sad story',
detail = 'THVL said "Game not good"',
[image] = 'View/images/1.jpg',
date = '2020/11/17'
WHERE id = '1';

SELECT * FROM new

Insert Into new values('3','15','PE da xong','do la cuoc thi','Thi thuc hanh cua FPT','View/images/1.jpg','2020-11-17','2')

Select * from users where username = 'Hung'

UPDATE dbo.users
SET username = 'admin',
password = 'admin',
fullname = 'ad'
WHERE id = '0';

ALTER TABLE dbo.new ALTER COLUMN detail NVARCHAR(MAX)

CREATE TABLE comment(
	id int NOT NULL PRIMARY KEY,
	commment NVARCHAR(MAX),
	usercheck BIT,
	admincheck BIT,
	name NVARCHAR(25),
	post_id INT NOT NULL FOREIGN KEY REFERENCES dbo.new(id)
)

SELECT * FROM dbo.new
SELECT * FROM dbo.comment
SELECT * FROM dbo.categories
SELECT * FROM dbo.users

ALTER TABLE dbo.new ALTER COLUMN name NVARCHAR(255) NOT NULL

ALTER TABLE dbo.new ALTER COLUMN [description] NVARCHAR(255) NOT NULL
ALTER TABLE dbo.new ALTER COLUMN detail NVARCHAR(MAX) NOT NULL

ALTER TABLE dbo.categories ALTER COLUMN name NVARCHAR(255) NOT NULL

ALTER TABLE dbo.users ALTER COLUMN fullname NVARCHAR(50) NOT NULL

Select * from comment where post_id = '1'

SELECT dbo.new.name
FROM dbo.new,dbo.comment
WHERE dbo.comment.[post_id] = new.id AND admincheck = '0' AND usercheck = '1'

SELECT *
FROM dbo.new
WHERE category_id = '1'
ORDER BY [date] DESC

SELECT *
FROM dbo.new
WHERE category_id = '1'
ORDER BY viewtime DESC

ALTER TABLE dbo.comment ADD [date] DATE