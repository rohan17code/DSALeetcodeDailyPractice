# Write your MySQL query statement below
SELECT e.name AS Employee,
    e.salary AS Salary,
    d.name AS Department
FROM (
    SELECT *,
    DENSE_RANK() OVER(
        PARTITION BY departmentId
        ORDER BY salary DESC
    ) AS 'rank'
    FROM Employee
) e
LEFT JOIN Department d
ON e.departmentId = d.Id
WHERE e.rank <= 3;