CREATE TABLE `proffessions` (
 `id` mediumint(9) NOT NULL auto_increment,
 `proffessionsName` varchar(40) NOT NULL,
 PRIMARY KEY (`id`)
) ;
INSERT INTO `proffessions` VALUES (1, 'Sprzedawca');
INSERT INTO `proffessions` VALUES (2, 'Kelner');
INSERT INTO `proffessions` VALUES (3, 'Kucharz');

CREATE TABLE `employees` (
 `id` int(11) NOT NULL auto_increment,
 `name` varchar(100) NOT NULL,
 `surname` varchar(100) NOT NULL,
 `rating` float NOT NULL default '0',
 `dailyIncome` float default '0',
  `proffession_id` mediumint(9) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`proffession_id`) REFERENCES `proffessions`(`id`)
) ;
INSERT INTO `employees` VALUES (1, 'Jan', 'Zbedny', 6.5, 3000,1);
INSERT INTO `employees` VALUES (2, 'Gloria', 'Melmanowa',4.4 , 0,2);
INSERT INTO `employees` VALUES (3, 'Melman', 'Gloriowy', 9.0, 200,3);

CREATE TABLE `orderItems` (
`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`itemName` VARCHAR(30) NOT NULL,
`price` float default '0',
`containsAlcohol` boolean default '0'
);


INSERT INTO `orderItems` VALUES (1, 'Coca-cola', 5.0, false);
INSERT INTO `orderItems` VALUES (2, 'Paluszki', 3.5, false);
INSERT INTO `orderItems` VALUES (3, 'Chipsy', 5.0, false);


CREATE TABLE Orders
(
	ID int NOT NULL auto_increment primary key,
	Employee_Id int NOT NULL,
    DiscountPercent float,
    TotalValue float, 
    constraint FK_Employee foreign key (Employee_Id) references Employees(id)
);

INSERT INTO `orders` VALUES (1, 1, 5.0, 10.0);
INSERT INTO `orders` VALUES (2, 2, 0.0, 3.5);
INSERT INTO `orders` VALUES (3, 2, 0.0, 3.5);
INSERT INTO `orders` VALUES (4, 2, 0.0, 3.5);



CREATE TABLE OrderPositions
(
	ID int NOT NULL auto_increment primary key,
    Order_Id int,
    OrderItem_Id int,
    Quantity float,
    DiscountPercent float,
	
    constraint FK_OrderItem foreign key (OrderItem_Id) references orderitems(id),
	constraint FK_Order foreign key (Order_Id) references Orders(ID)
);

INSERT INTO `orderpositions` VALUES (1, 1, 1, 1, 2.0);
INSERT INTO `orderpositions` VALUES (2, 1, 3, 1, 3.5);
INSERT INTO `orderpositions` VALUES (3, 2, 2, 1, 3.5);
INSERT INTO `orderpositions` VALUES (4, 3, 2, 1, 3.5);
INSERT INTO `orderpositions` VALUES (5, 4, 2, 1, 3.5);
INSERT INTO `orderpositions` VALUES (6, 4, 2, 1, 3.5);


CREATE TABLE users (
 id BIGINT(50) NOT NULL AUTO_INCREMENT,
 username VARCHAR(25) NOT NULL,
 password VARCHAR(60) NOT NULL,
 isActive ENUM('0','1') NOT NULL DEFAULT '0',
 PRIMARY KEY (id)
);
CREATE TABLE roles (
 id BIGINT(50) NOT NULL AUTO_INCREMENT,
 role VARCHAR(45) NOT NULL,
 PRIMARY KEY (id)
);
CREATE TABLE user_roles (
 id BIGINT(50) NOT NULL AUTO_INCREMENT,
 user_id BIGINT(50) NOT NULL,
 role_id BIGINT(50) NOT NULL,
 PRIMARY KEY (id)
);


INSERT INTO roles (role) VALUES('ROLE_ADMIN'), ('ROLE_USER');
INSERT INTO users (username,password,isActive) VALUES
('admin','$2a$04$zzchzNzfGQP.j8oylRFJJu6VMMGe9uToxEOFVwws.tmaYZNrK/4Uu','1');
INSERT INTO users (username,password,isActive) VALUES
('user','$2a$04$lOLxtbIEZpjWcA3bFUX7JegBIC83El2Ekbg7VMnlINJ9qIP/qwhyq','1');
INSERT INTO user_roles (user_id,role_id) VALUES ('1','1'),('1','2'),('2','2');