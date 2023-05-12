SELECT *
FROM resume;

SELECT count(*) FROM resume;

SELECT *
FROM resume r
         LEFT JOIN contact c ON r.uuid = c.resume_uuid
ORDER BY r.full_name,
         r.uuid;

SELECT *
FROM resume r
         LEFT JOIN contact c
                   ON r.uuid = c.resume_uuid
WHERE r.uuid='92862cdc-2584-4cee-b3da-1c6bfd7d36a1';

SELECT *
FROM resume r
         LEFT JOIN section s
                   ON r.uuid = s.resume_uuid
WHERE r.uuid='92862cdc-2584-4cee-b3da-1c6bfd7d36a1';

DELETE
FROM resume
WHERE uuid='uuid';