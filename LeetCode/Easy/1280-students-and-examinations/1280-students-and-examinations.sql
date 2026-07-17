# Write your MySQL query statement below
SELECT st.student_id, st.student_name, sub.subject_name, count(e.subject_name) as attended_exams
from students st
cross join subjects sub
left join examinations e
on st.student_id = e.student_id 
and sub.subject_name = e.subject_name
group by st.student_id, st.student_name, sub.subject_name
order by st.student_id, sub.subject_name;