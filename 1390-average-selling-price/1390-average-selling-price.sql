# Write your MySQL query statement below
SELECT p.product_id,IFNULL(ROUND(SUM(units*price)/sum(units),2),0) AS average_price
FROM Prices AS p
LEFT JOIN UnitsSold as u
ON p.product_id = u.product_id AND
u.purchase_date BETWEEN start_date AND end_date
GROUP BY p.product_id
