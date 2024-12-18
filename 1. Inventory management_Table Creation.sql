--ADMIN_DETAILS
--TABLE CREATION

CREATE TABLE Admin_details(
	UserId int IDENTITY(900001,1) PRIMARY KEY,
	AdminPass varchar(20) NOT NULL
)

INSERT INTO Admin_Details(Adminpass) 
VALUES ('Vengence249'),
	('Attack338');

Select * from Admin_Details


----------------------------------------------------------------------------------------------	
--EMPLOYEE
--TABLE CREATION
CREATE TABLE Employee(
	EmployeeId int IDENTITY(100001,1) PRIMARY KEY,
	EmployeePass varchar(35) NOT NULL,
	Name varchar(35) NOT NULL,
	DOB date NOT NULL,
	NID bigint NOT NULL,
	PhoneNumber bigint NOT NULL,
	Email varchar(30) NOT NULL,
	Address varchar(100) NOT NULL,
	EmployStatus bit NOT NULL default 1,
	Position varchar(35) NOT NULL default 'SalesPerson',
	JoiningDate date NOT NULL default GETDATE(),
	Salary int NOT NULL default 25000,
	Experience int NOT NULL default 0,
	Gender char NOT NULL	
)
--alter table employee
--	alter column DOB date NOT NULL;

--minimalistic insert
INSERT INTO EMPLOYEE (EmployeePass,Name, DOB, NID, PhoneNumber, Email, Address, Gender) 
VALUES ('nutaku11', 'Alvee Sheikh', '1999-09-11', 9571231234, 01712123123, 'nutaku@gmail.com', 'gulshan,Dhaka', 'M');

Select * from employee
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

--CUSTOMER
--TABLE CREATION
CREATE TABLE Customer(
	
	CustomerId int IDENTITY(200001,1) PRIMARY KEY,
	EmployeeId int NOT NULL FOREIGN KEY REFERENCES Employee(EmployeeId),
	Name varchar(35) NOT NULL,
	Address varchar(100) NULL,
	PhoneNumber bigint NOT NULL,
	Email varchar(35) NULL,
	LastPurchase date NULL,
	PurchaseQty int NOT NULL default 0,
	SpentMoney int NOT NULL default 0,
	Gender char NULL
)

--minimalistic insert
INSERT INTO Customer (EmployeeId, Name, PhoneNumber,LastPurchase,SpentMoney,PurchaseQty) 
VALUES (100001, 'AlveeCEO', 0171999653,'2021-09-23',20000,99);

Select * from customer
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

--PRODUCT
--TABLE CREATION
CREATE TABLE Product(
	ProductId int IDENTITY(300,1) PRIMARY KEY,
	EmployeeId int NOT NULL FOREIGN KEY REFERENCES Employee(EmployeeId),
	Title varchar(50) NOT NULL,
	Category varchar(35) NOT NULL,
	SubCategory varchar(35) NULL,
	Manufacture_country varchar(35) NULL,
	Description varchar(255) NULL,
	Imgurl varchar(100) NOT NULL default 'images/placeholder.jpg',
	InStock int NOT NULL default 0,
	CostPrice float NULL,
	SellPrice float NULL,
	AddDate date NOT NULL default GETDATE(),
	LastUpdated date NOT NULL default GETDATE(),
	Exp_Date date NOT NULL,
	Mfg_Date date NULL
)

--minimalistic insert (means the things we must have)
INSERT INTO Product (EmployeeId, Title, Category, CostPrice, SellPrice, Mfg_Date, Exp_Date) 
VALUES (100001, 'Huston ', 'Beverageg', 9, 50, '2023-09-01','2023-09-11');

Select * from Product

--changing column SalePrice to SellPrice
--sp_rename 'Product.SalePrice', 'SellPrice', 'COLUMN';

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

--ORDER
--TABLE CREATION
CREATE TABLE Order_Details(
	OrderId int IDENTITY(400,1) PRIMARY KEY,
	CustomerId int NOT NULL FOREIGN KEY REFERENCES Customer(CustomerId),
	ProductId int NOT NULL FOREIGN KEY REFERENCES Product(ProductId),
	EmployeeId int NOT NULL FOREIGN KEY REFERENCES Employee(EmployeeId),
	Qty int NOT NULL default 0,
	--UnitPrice int NOT NULL, already exists on Product table
	TotalPrice float NOT NULL,
	Discount float NOT NULL default 0,
	Tax float NOT NULL default 0.15, --15% = 15/100. 
	FinalPrice float NOT NULL,
	SoldDate date NOT NULL default GETDATE(),
	PaidStatus bit NOT NULL default 0	
)
--minimal insert
INSERT INTO Order_Details (CustomerId, ProductId, EmployeeId,TotalPrice,FinalPrice,Discount) 
VALUES (200006, 300, 100001, 500, 590,25);

SELECT * from Order_details
----------------------------------------------------------------------------------------------
--PAYMENT
--TABLE CREATION
CREATE TABLE Payment(
	Bill_Id int IDENTITY(500,1) PRIMARY KEY,
	EmployeeId int NOT NULL Foreign Key References Employee(EmployeeId),
	OrderId int NOT NULL Foreign Key References Order_Details(OrderId),
	Pay_type varchar(30) NOT NULL default 'Cash',
	Pay_CardNo varchar(30) NULL,
	PayDate date NOT NULL default GETDATE(),
	Pay_Time time NOT NULL default GETDATE(),	
	PaidStatus bit NOT NULL default 0,
)
INSERT INTO Payment (EmployeeId, OrderId, PaidStatus) 
VALUES (100001, 400,1);

Select * from Payment
--------------------------------------------------------------------------------------------------

--Supplier
--TABLE CREATION
CREATE TABLE SUPPLIER(
	SupplierId int IDENTITY(600,1) PRIMARY KEY,
	Name varchar(35) NOT NULL,
	Address varchar(35) NOT NULL,
	PhoneNumber bigint NOT NULL,
	Email varchar(35) NULL,
)

INSERT INTO Supplier (Name, Address, PhoneNumber) 
VALUES ('Nestle', 'Gazipur,Dhaka',01712123123);
---------------------------------------------------------------------------------
--SUPPLY TABLE CREATION
CREATE TABLE SUPPLY(
	SupplyId int IDENTITY(700,1) PRIMARY KEY,
	ProductId int NOT NULL FOREIGN KEY REFERENCES Product(ProductId),
	SupplierId int NOT NULL FOREIGN KEY REFERENCES SUPPLIER(SupplierId),
	EmployeeId int NOT NULL Foreign Key References Employee(EmployeeId),
	SupplyDate date NOT NULL default getdate(),
	Qty int NOT NULL default 0,
	CostPrice float NOT NULL, --related to product table
	Total_CostPrice float NOT NULL,
)
INSERT INTO Supply (ProductId, SupplierId, EmployeeId, Qty, CostPrice, Total_CostPrice) 
VALUES (300, 600, 100001, 2, 45,90);

--------------------------------------------------------------------------------------
--creating all tables done

--DATE - format YYYY-MM-DD
--DATETIME - format: YYYY-MM-DD HH:MI:SS
--SELECT CONVERT(TIME, GETDATE()) 
--      AS 'CURRENT_TIME using GETDATE()'


/*
DROP TABLE Admin_Details
DROP TABLE Customer
DROP TABLE Employee
DROP TABLE Order_Details
DROP TABLE Payment
DROP TABLE Product
DROP TABLE SUPPLIER
DROP TABLE Supply
*/