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
WHERE r.uuid='6fd43d30-de89-4353-9290-fc19ec7f7ce7';

DELETE
FROM resume
WHERE uuid='6fd43d30-de89-4353-9290-fc19ec7f7ce7';