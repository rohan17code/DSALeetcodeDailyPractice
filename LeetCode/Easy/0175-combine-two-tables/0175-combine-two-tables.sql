# Write your MySQL query statement below
SELECT p.firstname, p.lastname, a.city, a.state
FROM person as p
LEFT JOIN Address as a
ON p.personID = a.personID