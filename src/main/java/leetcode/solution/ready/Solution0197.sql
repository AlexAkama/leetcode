-- Повышение температуры
-- Вывести значения у которых "вчерашнее" поле больше предыдущего
--
-- DATEDIFF - разница между датами
-- https://docs.microsoft.com/ru-ru/sql/t-sql/functions/datediff-transact-sql?view=sql-server-ver16
--
SELECT w1.id
FROM weather w1, weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
AND w1.temperature > w2.temperature
;
