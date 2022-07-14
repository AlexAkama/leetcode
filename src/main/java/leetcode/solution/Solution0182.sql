# Показ дубликатов

SELECT email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1
;

# Runtime: 372 ms, faster than 63.75% of MySQL online submissions for Duplicate Emails.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.