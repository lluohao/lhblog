CREATE TABLE blog(
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL,
  md VARCHAR(65535),
  html VARCHAR(65535),
  time TIMESTAMP ,
  count INT DEFAULT 0,
  type int NOT NULL,
  PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;