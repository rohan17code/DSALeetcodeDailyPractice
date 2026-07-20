# Write your MySQL query statement below
SELECT e.name, u.unique_id
FROM Employees e
LEFT JOIN EmployeeUNI u
ON u.id = e.id;