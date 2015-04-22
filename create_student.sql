use scholarship;

DROP TABLE student;

CREATE TABLE student (
  id int(6) NOT NULL AUTO_INCREMENT,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  student_number int(6) NOT NULL,
  created DATE,
  updated DATE,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
