
/* Lab 3 SQL Statements */
-- question 1
select * from emp where ename like 'b%' and job not in ('manager', 'clerk', 'president');

-- question 2
select ename, sal, (sal * 12) as 'Annual Salary' from emp;

-- question 3
select ename, job, deptno, hiredate from emp order by ename asc;

-- question 4
select deptno, ename, job, hiredate from emp group by deptno, ename;

-- question 5
select sysdate();

-- question 6
select ename, round(datediff(sysdate(), hiredate)/365) from emp;

-- question 7
select sum(sal) as 'Total paid out' from emp;

-- question 8
select min(sal) as 'Minimum Salary' from emp;

-- question 9
select min(sal) as 'Minimum Salary', max(sal) as 'Maximum Salary', 
avg(sal) as 'Average Salary' from emp where job = 'salesman';

-- question 10
select count(distinct mgr) as 'Number of Managers' from emp;

-- question 11
select count(*) as 'Number of Employees' from emp;

-- question 12
select count(*) as 'Employees in Dept 20' from emp where deptno = 20;