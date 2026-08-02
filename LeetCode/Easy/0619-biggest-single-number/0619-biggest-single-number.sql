# Write your MySQL query statement below
SELECT MAX(num) AS num
FROM (
    SELECT num
    FROM MyNUmbers
    GROUP BY num 
    HAVING COUNT(*) = 1
) AS num;