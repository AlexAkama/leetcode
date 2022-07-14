# Два варианта
# 1. Выбрать уникальные номера кустомеров из ордеров и потом выбрать тех кто в них не входит
# 2. Объединить кустомеров и ордера и взять тех у кого нет ордеров


#Runtime: 491 ms, faster than 64.47% of MySQL online submissions for Customers Who Never Order.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
SELECT c.name Customers
FROM Customers c
WHERE c.id NOT IN (SELECT DISTINCT customerId
                   FROM Orders)
;

# Runtime: 493 ms, faster than 63.89% of MySQL online submissions for Customers Who Never Order.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
SELECT c.name Customers
FROM Customers c
         LEFT JOIN Order o ON c.id = o.customerId
WHERE o.id IS NULL
;

# Вроде одинаково, но интересно что будет на больших объемах