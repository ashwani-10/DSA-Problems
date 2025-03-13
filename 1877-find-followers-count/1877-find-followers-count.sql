# Write your MySQL query statement below
Select user_id, Count(follower_id) AS followers_count
FROM Followers as f
GROUP BY user_id
Order by user_id