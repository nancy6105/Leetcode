# Write your MySQL query statement below
select e.employee_id, e.name, sub. reports_count, sub.average_age
from Employees e
inner join(
    select reports_to, count(*) as reports_count, round(avg(age)) as average_age
    from employees
    where reports_to is not null
    group by reports_to
)as sub
on e.employee_id = sub.reports_to
order by e.employee_id;