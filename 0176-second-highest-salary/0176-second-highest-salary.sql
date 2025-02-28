SELECT (
    SELECT DISTINCT ep.salary
    FROM Employee ep
    ORDER BY ep.salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;
