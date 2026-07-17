# Write your MySQL query statement below
SELECT author_id as id
from Views
WHERE author_id = Viewer_id
group by  author_id
order by author_id asc;
