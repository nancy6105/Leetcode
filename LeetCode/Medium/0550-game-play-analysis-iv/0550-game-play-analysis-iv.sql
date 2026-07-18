# Write your MySQL query statement below
select round(count(distinct a.player_id)/(select count(distinct player_id) from activity),2) as fraction
from activity a
join (
    select player_id, min(event_date) as first_login
    from activity
    group by player_id
) as filtered_table
on a.player_id = filtered_table.player_id
and a.event_date = date_ADD(filtered_table.first_login, interval 1 DAY);