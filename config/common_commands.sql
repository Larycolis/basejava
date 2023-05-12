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
WHERE r.uuid='uuid';

DELETE
FROM resume
WHERE uuid='uuid';