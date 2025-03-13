# Write your MySQL query statement below
Select c.class
FROM Courses AS c
GROUP BY c.class
HAVING Count(*) >= 5