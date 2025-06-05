SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName 
FROM Products p JOIN
Cateegories c ON p.CategoryID = c.CategoryID ORDER BY c.CategoryName, p.ProductName;

-- Question 2 -- 
SELECT p.ProductID, p.ProductName, p.UnitPrice, s.CompanyName AS SupplierName 
FROM Products p 
JOIN Suppliers s 
ON p.SupplierID = s.SupplierID 
WHERE p.UnitPrice > 75 
ORDER BY p.ProductName;

-- Question 3 -- 
SELECT p.ProductID, p.ProductName, p.UnitPrice, c.CategoryName, s.CompanyName AS SupplierName 
FROM Products p 
JOIN Categories c 
ON p.CategoryID = c.CategoryID 
JOIN Suppliers s ON p.SupplierID = s.SupplierID 
ORDER BY p.ProductName;

-- Question 4 -- 
SELECT p.ProductName, c.CategoryName 
FROM Products p 
JOIN Categories c 
ON p.CategoryID = c.CategoryID 
WHERE p.UnitPrice = ( SELECT MAX(UnitPrice) FROM Products );

-- Question 5 -- 
SELECT o.OrderID, o.ShipName, o.ShipAddress, s.CompanyName AS ShipperName 
FROM Orders o JOIN Shippers s 
ON o.ShipVia = s.ShipperID
 WHERE o.ShipCountry = 'Germany';