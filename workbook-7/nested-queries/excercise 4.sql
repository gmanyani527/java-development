select ProductName FROM Products WHERE UnitPrice = (select MAX(UnitPrice) );

 -- Question 2 -- 
 
 select OrderId, Shipname, ShipAddress 
 FROM Orders 
 WHERE shipVia = (select shipperId
 FROM shippers
 WHERE companyname = 'Federal Shipping' 
 );
 
 -- Question 3 -- 
SELECT orderid
FROM `order details`
WHERE productid = (
    SELECT productid
    FROM products
    WHERE productname = 'Sasquatch Ale'
);

-- Question 4 -- 
SELECT CONCAT(FirstName, ' ', LastName) 
AS EmployeeName FROM WHERE EmplopyeeID = ( SELECT EmployeeID 
FROM Orders WHERE OrderID = 10266);