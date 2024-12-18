--inserts
/**/
--order
INSERT INTO Order_Details (CustomerId, ProductId, EmployeeId, Qty,TotalPrice, discount,Tax, FinalPrice,PaidStatus) 
--VALUES (200001, 300, 100001, 3,150,0,22.5,172.5, 1);
--VALUES (200002, 300, 100002, 3,150,0,22.5,172.5, 1);
VALUES (200003, 301, 100002, 5,160,0,24,184, 1);

--employee
INSERT INTO EMPLOYEE (EmployeePass,Name, DOB, NID, PhoneNumber, Email, Address,Position, Gender) 
VALUES ('BL9902', 'Rahat Aziz', '1997-07-17', 9571231234, 01712123321, 'karma99@gmail.com', 'Kolabagan,Dhaka', 'Cashier', 'M');

--customer
INSERT INTO Customer (EmployeeId, Name, Address, PhoneNumber, Email, PurchaseQty, SpentMoney, Gender) 
--VALUES (100001, 'Karim Hossen','19/b Shaplabag, Dhaka', 01712123124, 'uddinchy@gmail.com', 4, 225.5, 'M');
--VALUES (100001, 'Shimul Ahmed','19/b Anupoms Road, Dhaka', 01712123124, 'shimulahmed@gmail.com', 4, 225.5, 'M');
VALUES (100001, 'Ratan Sharkar','22/b Shaplabagan, Dhaka', 01712123125, 'ratans@gmail.com', 2, 117.99, 'M');
--product
INSERT INTO Product (EmployeeId, Title, Category, SubCategory, Manufacture_country, InStock, CostPrice, SalePrice, Exp_Date) 
--VALUES (100001, 'ACI Salt 1Kg', 'Cooking Essentials', 'Salt & Sugar', 'Bangladesh',200,30, 32, '2023-09-25');
--VALUES (100001, 'Radhuni Garam Masala 15gm', 'Cooking Essentials', 'Spices & Mixes', 'Bangladesh',200,25, 26, '2023-09-25');
--VALUES (100001, 'Pran Premium Ghee 400g', 'Milk & Dairy Products', 'Butter & Ghee', 'Bangladesh',100,515, 565, '2021-10-05');
VALUES (100001, 'Ispahani Mirzapore Bestleaf 200 Gm', 'Beverages', 'Tea & Coffee', 'Bangladesh',500,100, 110, '2021-09-10');

--payment
INSERT INTO Payment (EmployeeId, OrderId, Pay_type, Pay_CardNo, PayDate, PaidStatus) 
VALUES 
(100001, 401,'Card', '601309', '2021-09-22',0),
(100001, 402,'Card', '604306', '2021-09-24',1),
(100001, 403,'Card', '602301', '2021-03-25',1),
(100001, 404,'Cash', NULL, '2021-09-25',1),
(100001, 405,'Cash', NULL, '2021-09-25',1);
--updates
UPDATE EMPLOYEE SET Experience=2 Where Name = 'Rahat Aziz'

UPDATE Order_Details SET SoldDate='2021-03-25' Where OrderId = 403;
