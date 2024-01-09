--Seed Employee
DELETE FROM interactions WHERE employeeid IN (SELECT id FROM employees);
DELETE FROM employees WHERE username = 'mslim';
INSERT INTO employees (username, password, role) VALUES ('mslim', 'fbcb7534-56e1-45f2-b279-3883348a0785', 'EMPLOYEE');