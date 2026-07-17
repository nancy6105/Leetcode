# Write your MySQL query statement below
select e.name
from Employee e
join (
    select managerId
    from Employee
    where managerId is not null
    group by managerId
    having count(*) >= 5
)
as filtered_table
on e.id = filtered_table.managerId;