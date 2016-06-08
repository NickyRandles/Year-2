/* Labsheet 4*/
-- 1
select deptno, count(*) as 'Number of Employees'
from emp
group by deptno
having count(*) > 4;

-- 2
select mgr as 'Manager', min(sal) as 'Lowest paid salary'
from emp
group by mgr
having min(sal) > 1000
order by min(sal);

-- 3 
select e.empno, e.ename, d.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno;

-- 4
select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno;

-- 5 
select e.ename, e.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
group by d.deptno, e.ename;

-- 6
select d.deptno, d.dname, sum(e.sal + ifnull(e.comm, 0)) as 'Total paid out'
from emp e inner join dept d
on e.deptno = d.deptno
group by deptno;

-- 7 
select e.deptno, d.dname, count(*) as 'Number of employees'
from emp e inner join dept d
on e.deptno = d.deptno;

-- 8
select e.deptno, d.dname, count(*) as 'Number of employees'
from emp e inner join dept d
on e.deptno = d.deptno
group by deptno
having count(*) > 4;

-- 9 
select e.ename, s.grade
from emp e inner join salgrade s
ON e.sal >= s.losal
AND e.sal <= s.hisal;

-- 10
select e.ename, s.grade, e.job, e.sal 
from emp e inner join salgrade s
ON e.sal >= s.losal
AND e.sal <= s.hisal;

-- 11
select e1.empno as 'Employees number', e1.ename as 'Employees name',
e2.empno as 'Managers number', e2.ename as 'Managers name'
from emp e1 inner join emp e2 
on e1.mgr = e2.empno;