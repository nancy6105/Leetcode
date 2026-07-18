# Write your MySQL query statement below
select s.product_id, s.year as first_year, s.quantity, s.price
from sales s
join (
    select product_id, min(year) as first_year
    from sales
    group by product_id
)as filtered
on s.product_id = filtered.product_id
and s.year = filtered.first_year