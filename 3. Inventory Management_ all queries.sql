/*
How many goods were sold on a
	1)Specific date/month/year
	2)From YYYY-MM-DD to YYYY-MM-DD
*/
select * from order_details where year(SoldDate)=2021-- month(SoldDate) = 9

--1.year)
select SUM(Qty) as goods_sold From order_details 
Where PaidStatus=1 AND YEAR(SoldDate) = 2021

--1.month)
select SUM(Qty) as goods_sold From order_details 
Where PaidStatus=1 AND MONTH(SoldDate) = 9 AND YEAR(SoldDate) = 2021	--september 2021 
	
--1.date)
select SUM(Qty) as goods_sold From order_details 
Where PaidStatus=1 AND SoldDate = '2021-09-21'

--2)
select SUM(Qty) as goods_sold From order_details 
Where PaidStatus=1 
AND SoldDate between '2021/07/25' and '2021/09/25' --25july,2021 - 25september,2021
		 

/*
1.Income from dd/mm/yyyy to dd/mm/yyyy
2.Profit from dd/mm/yyyy to dd/mm/yyyy

*/
--1)
select SUM(FinalPrice) as Income From order_details 
Where PaidStatus=1 
AND SoldDate between '2021/07/25' and '2021/09/25' --25july,2021 - 25september,2021

--2)
select SUM(FinalPrice-tax) as Profit From order_details 
Where PaidStatus=1 
AND SoldDate between '2021/07/25' and '2021/09/25' --25july,2021 - 25september,2021

/*
Select Employees according to
	1.Salary
	2.Experience (in months)
	3.Address
	4.Gender (M/F)
	5.Status (employed/fired)
	6.Position (Manager/ Salesperson/ Cashier)
*/
--1)
Select * From Employee Where Salary Between 25000 and 50000
--2)
Select * From Employee Where Experience>0
--3)
Select * From Employee Where Address like 'k%bagan%'
--4)
Select * From Employee Where Gender = 'M'
--5)
Select * From Employee Where EmployStatus = 1 --0 for fired employees, 1 for employed 
--6)
Select * From Employee Where Position = 'Salesperson' --salesperson/cashier/manager



---------------------------------------------------------------------arman entry-1
---ALVEE's WORK STARS FROM HERE 24-09-21---
/*
Show all Customers  /* ill do this - ALVEE*/
	1.in a particular area x
	2.Handled by particular employee (eid)
	3.Who spent more than xx bdt 
	4.Who bought more than x qty of items
	5.Who didn’t buy something from xDate - yDate
	6.Who bought something from xDate-yDate

*/
select * from customer
--1)
SELECT * FROM Customer WHERE Address like '%anupom%road%'
--2)
SELECT * FROM Customer WHERE EmployeeId = 100001
--3)
SELECT * FROM Customer WHERE SpentMoney > 200
--4)
SELECT * FROM Customer WHERE PurchaseQty > 29
--5)
--SELECT * FROM Customer WHERE LastPurchase NOT BETWEEN '2021-09-22' AND '2021-09-28'
--arman comment: above one won't work cause lastPurchase only contains a single date, the last purchase
select * from customer where customerId NOT IN 
	(Select customerId from order_details where 
	soldDate BETWEEN '2021-03-22' AND '2021-03-28')
--6)
--SELECT * FROM Customer WHERE LastPurchase BETWEEN '2021-09-19' AND '2021-09-28'
--arman: same case as above
select * from customer where customerId IN 
	(Select customerId from order_details where 
	soldDate BETWEEN '2021-03-22' AND '2021-03-28')


/*
Search a customer by   /* ill do this - ALVEE*/
	1.Cid
	2.Phone number
	3.Email
	4.Name
*/
--1)
SELECT * FROM Customer WHERE CustomerId = 200001
--2)
SELECT * FROM Customer WHERE PhoneNumber = 1712123123
--3)
SELECT * FROM Customer WHERE Email = 'uddinchy@gmail.com'
--4)
SELECT * FROM Customer WHERE Name like '%shimul%ahmed%' --arman comment: name ta %% diye korle better


/*
Which items will expire in x days?
*/
SELECT * FROM Product WHERE Exp_Date <DATEADD(day,10,GETDATE())
--products which hasn't expired yet
SELECT * FROM Product WHERE Exp_Date >DATEADD(day,0,GETDATE())

--expired products
SELECT * FROM Product WHERE Exp_Date <DATEADD(day,0,GETDATE())





/*

Which items will expire in less x days?
*/
SELECT * FROM Product WHERE DATEDIFF(day,Exp_Date, getdate()) <= 10  --(expDate - currentDate)

/*
Search an order with   /* ill do this - ALVEE*/
	1.order ID
	2.Eid
	3.Customer name
	4.Customer phone number
	5.Cid
*/
--1)
SELECT * FROM Order_Details WHERE OrderId = 400
--2)
SELECT * FROM Order_Details WHERE EmployeeId = 100001
--3)
SELECT * FROM Order_Details WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE Name like '%rahim%' )
--4)
SELECT * FROM Order_Details WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE PhoneNumber = 1712123123 )
--5)
SELECT * FROM Order_Details WHERE CustomerId = 200006


/*
Select Orders   /* ill do this - ALVEE*/
	1.Which have payments due
	2.With unitPrice(product.Saleprice) higher than x bdt
	3.With totalPrice higher than x bdt
	4.Which have discount
	5.Which do not have discount
	6.Sold between xDate - yDate
	7.Qty more than x items
	8.Handled by particular Employee
		i.Eid
		ii.Employee name (Order table do not have employee name, only eid. Will join table or use subquery for this)
*/
select * from order_details
--1)
SELECT * FROM Order_Details WHERE PaidStatus = 0
--2)
SELECT O.* FROM Order_Details O JOIN Product P ON O.ProductId=P.ProductId
	WHERE P.SalePrice < 45
	
	select * from Order_details 	
--3)
SELECT * FROM Order_Details WHERE TotalPrice > 20
--4)
SELECT * FROM Order_Details WHERE Discount > 0
--5)
SELECT * FROM Order_Details WHERE Discount = 0
--6)
SELECT * FROM Order_Details WHERE SoldDate BETWEEN '2021-09-19' AND '2021-09-23'
--7)
SELECT * FROM Order_Details WHERE Qty > 1 --x=1 here
--8.i)
SELECT * FROM Order_Details WHERE EmployeeId = 100001
--8.ii)
SELECT * FROM Order_Details WHERE EmployeeId IN (SELECT EmployeeId FROM Employee WHERE Name = 'Alvee Sheikh' )

---ALVEE's WORK ENDS  HERE 24-09-21 FOR THE NIGHT ---
--reviewed till here ---arman

/*
Search a particular Product
	1.Pid
	2.Product Title
	3.imgurl

*/
--1)
Select * from Product Where ProductId=302
--2)
Select * from Product Where Title='ACI Salt 1Kg'
--3)
Select * from Product Where imgurl='images/placeholder.jpg'
/*
Select products based on ?
	1.Country of manufacture
	2.Category
	3.Sub -category
	4.Input by a particular employee (Eid)
	5.Added on a particular date
	6.Added between xDate-yDate
	7.Expires within a week/month	
	8.In stock
	9.Not in stock
	10.Less than x items in stock
	11.SalePrice less/higher than x bdt
	12.Supplied by particular supplier (Sid)
	13.Highest sold product
	14. Sold between xDate-yDate
*/
select * from Product where Title like '%ACI%'
--1)
select * from Product where Manufacture_country = 'Bangladesh'
--2)
select * from Product where Category = 'Cooking Essentials'
--3)
select * from Product where SubCategory like '%Salt%Sugar%'
--4)
select * from Product where EmployeeId = 100001
--5)
select * from Product where AddDate = '2021-09-25'
--6)
select * from Product where AddDate BETWEEN  '2021-09-20' and '2021-09-25'
--7)
SELECT * FROM Product WHERE DATEDIFF(month,Exp_Date, getdate()) <= 1  --within 1 month
SELECT * FROM Product WHERE DATEDIFF(week,Exp_Date, getdate()) <= 1	--within 1 week
--8)
select * from Product where InStock > 0 
--9)
select * from Product where InStock <= 0 
--10)
select * from Product where InStock <= 15
--11)
select * from Product where SalePrice >= 50 --use <= for opposite
--12)
SELECT p.* 
FROM Product p JOIN SUPPLY supply ON supply.ProductId=p.ProductId 
	WHERE supply.SupplierId = 600
/*	arman: below is left Join of 3 tables: Product, Supply, Supplier
		and we selected all from product, supplier id from SUPPLY and supplier name form SUPPLIER
		*/ 
SELECT Product.*,supply.SupplierId, supplier.Name 
FROM Product
LEFT JOIN SUPPLY supply ON supply.ProductId=Product.ProductId
LEFT JOIN SUPPLIER supplier ON supplier.SupplierId = supply.SupplierId  
	WHERE supply.SupplierId = 600
	ORDER BY Product.productId ASC;
--13)
SELECT Order_Details.ProductId,SUM(Qty) as 'Sold Amount'
FROM Order_Details 		
GROUP BY  Order_Details.ProductId
ORDER BY SUM(Qty) DESC
--14)
select P.*,Order_Details.SoldDate
from Order_Details --Order Details got priority because we don't need to show anything that hasn't been ordered 
LEFT JOIN Product P ON Order_details.ProductId=P.ProductId
where SoldDate BETWEEN  '2021-09-20' and '2021-09-25'
ORDER BY SoldDate DESC

/*
Search a payment by
	1.Bill_id
	2.Payment date & time
*/
--1)
SELECT * FROM PAYMENT WHERE Bill_Id = 500

--2)
SELECT * FROM PAYMENT 
WHERE PayDate = '2021-09-22' AND DATEDIFF(second, pay_time, '00:12:14')<1 --input time hh:mm:ss

/*
Show all payments which
	1.Are paid (paid status)
	2.Aren’t paid
	3.Handled by particular Employee (Eid)
	4.Paid through card
	5.Paid through cash
	6. Are between xDate-yDate
*/
--1)
SELECT * FROM PAYMENT WHERE PaidStatus=1
--2)
SELECT * FROM PAYMENT WHERE PaidStatus=0
--3)
SELECT * FROM PAYMENT WHERE EmployeeId=100001
--4)
SELECT * FROM PAYMENT WHERE Pay_Type='Card'
--5)
SELECT * FROM PAYMENT WHERE Pay_Type='Cash'
--6)
SELECT * FROM PAYMENT WHERE PayDate BETWEEN '2021-09-20' AND '2021-09-25'

	

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
--VALUES (100001, 'Rahim Uddin','19/b Shaplabag, Dhaka', 01712123124, 'uddinchy@gmail.com', 4, 225.5, 'M');
--VALUES (100001, 'Shimul Ahmed','19/b Anupoms Road, Dhaka', 01712123124, 'shimulahmed@gmail.com', 4, 225.5, 'M');
VALUES (100001, 'Ratan Sharkar','22/b Shaplabagan, Dhaka', 01712123125, 'ratans@gmail.com', 2, 117.99, 'M');

--product
INSERT INTO Product (EmployeeId, Title, Category, SubCategory, Manufacture_country, InStock, CostPrice, SalePrice, Exp_Date) 
--VALUES (100001, 'ACI Salt 1Kg', 'Cooking Essentials', 'Salt & Sugar', 'Bangladesh',200,30, 32, '2023-09-25');
--VALUES (100001, 'Radhuni Garam Masala 15gm', 'Cooking Essentials', 'Spices & Mixes', 'Bangladesh',200,25, 26, '2023-09-25');
--VALUES (100001, 'Pran Premium Ghee 400g', 'Milk & Dairy Products', 'Butter & Ghee', 'Bangladesh',100,515, 565, '2021-10-05');
VALUES (100001, 'Ispahani Mirzapore Bestleaf 200 Gm', 'Beverages', 'Tea & Coffee', 'Bangladesh',500,100, 110, '2021-09-10');

--payment
select* from payment
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

select * from Order_Details
