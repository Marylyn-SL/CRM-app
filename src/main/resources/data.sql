DELETE FROM interactions WHERE employeeid IN (SELECT id FROM employees);
DELETE FROM interactions WHERE customerid IN (SELECT id FROM customers);
--Seed Employee
DELETE FROM employees WHERE username = 'mslim';
INSERT INTO employees (username, password, role) VALUES ('mslim', 'fbcb7534-56e1-45f2-b279-3883348a0785', 'EMPLOYEE');
--Seed Customer
DELETE FROM customers WHERE email = 'test@test.com';
INSERT INTO customers(email,is_customer,is_customer_date,last_contact,name,stop_date)
VALUES('test@test.com',false,null,null,'test',null);