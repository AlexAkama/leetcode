# Получение информации их двух таблиц

SELECT firstName, lastName, city, state
FROM Person p
         LEFT JOIN Address a
                   ON p.personId = a.personId
;
# Runtime: 1556 ms, faster than 5.00% of MySQL online submissions for Combine Two Tables.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Combine Two Tables.