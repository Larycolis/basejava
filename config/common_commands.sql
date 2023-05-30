SELECT *
FROM resume;

SELECT count(*)
FROM resume;

SELECT *
FROM resume r
         LEFT JOIN contact c ON r.uuid = c.resume_uuid
         LEFT JOIN section s ON r.uuid = s.resume_uuid
ORDER BY r.full_name,
         r.uuid;

SELECT *
FROM resume r
         LEFT JOIN contact с ON r.uuid = с.resume_uuid
ORDER BY r.full_name,
         r.uuid;

SELECT *
FROM resume r
         LEFT JOIN section s ON r.uuid = s.resume_uuid
ORDER BY r.full_name,
         r.uuid;

SELECT *
FROM resume r
         LEFT JOIN contact c ON r.uuid = c.resume_uuid
WHERE r.uuid = '5e0c5902-4aa6-4c0d-bfe4-03b2bb9cfd80';

SELECT *
FROM resume r
         LEFT JOIN section s ON r.uuid = s.resume_uuid
WHERE r.uuid = '27528b77-19b5-4710-8cc1-2fe78ba260d4';

DELETE
FROM resume
WHERE uuid = 'uuid';