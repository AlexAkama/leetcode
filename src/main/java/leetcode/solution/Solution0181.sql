# Получение значений со сравнением в этой же таблице

SELECT e.name Employee
FROM Employee e
WHERE managerId IS NOT NULL
  AND e.salary > (SELECT u.salary
                  FROM Employee u
                  WHERE u.id = e.managerId)
;

# Runtime: 1332 ms, faster than 5.01% of MySQL online submissions for Employees Earning More Than Their Managers.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
--

SELECT e.name Employee
FROM Employee e,
     Employee m
WHERE e.managerId = m.id
  AND e.salary > m.salary
;

# Runtime: 438 ms, faster than 53.00% of MySQL online submissions for Employees Earning More Than Their Managers.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
--

# С объединением получается быстрее, чем каждый раз запрос фигачить