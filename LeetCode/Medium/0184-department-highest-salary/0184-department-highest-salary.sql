# Write your MySQL query statement below
SELECT d.name AS Department,
    e.name AS Employee,
    e.salary AS salary
FROM Employee e
LEFT JOIN Department d
ON e.departmentID = d.id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE departmentID = e.departmentID #Current employee (e) jis department me hai, us department ki maximum salary
);