# Write your MySQL query statement below
Select customer_id
From Customer 
Group by customer_id
having count(distinct(product_key)) = (Select count(product_key) from Product)