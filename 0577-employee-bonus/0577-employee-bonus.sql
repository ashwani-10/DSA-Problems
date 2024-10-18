# Write your MySQL query statement below
select emp.name,b.bonus
from Employee emp
left join Bonus b
on emp.empId = b.empId
where bonus < 1000 OR bonus is null;