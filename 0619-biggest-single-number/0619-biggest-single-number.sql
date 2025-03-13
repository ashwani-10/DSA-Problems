# Write your MySQL query statement below
SELECT(
SELECT DISTINCT num
FROM MyNumbers as n
GROUP BY n.num
HAVING COUNT(*) = 1
ORDER BY num DESC limit 1) AS num