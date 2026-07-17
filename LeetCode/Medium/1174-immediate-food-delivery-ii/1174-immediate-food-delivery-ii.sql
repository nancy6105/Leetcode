# Write your MySQL query statement below
select round(sum(d.order_date = d.customer_pref_delivery_date)/count(*) * 100,2) as immediate_percentage
from delivery d
join (
    select customer_id, min(order_date) as first_ordered_date
    from delivery
    group by customer_id
) as filtered_table
on d.customer_id = filtered_table.customer_id 
and d.order_date = filtered_table.first_ordered_date;