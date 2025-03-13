# Write your MySQL query statement below
Select
(Select Distinct(salary) 
From Employee
Group by salary
order by salary desc
limit 1 offset 1) AS SecondHighestSalary