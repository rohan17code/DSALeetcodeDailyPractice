# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT salary 
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
)
AS SecondHighestSalary

# LIMIT n - means return only n rows 
# OFFSET n - means skip the first n rows