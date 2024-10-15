# Write your MySQL query statement below
SELECT v.customer_id,count(customer_id) as count_no_trans
FROM Visits v
LEFT JOIN Transactions t
ON v.visit_id = t.visit_id
where transaction_id is null
group by v.customer_id;