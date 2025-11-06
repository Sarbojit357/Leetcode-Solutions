WITH FilteredStadium AS (
    SELECT
        id,
        visit_date,
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS consecutive_group
    FROM
        Stadium
    WHERE
        people >= 100
),
CountedGroups AS (
    SELECT
        consecutive_group
    FROM
        FilteredStadium
    GROUP BY
        consecutive_group
    HAVING
        COUNT(*) >= 3
)
SELECT
    S.id,
    S.visit_date,
    S.people
FROM
    Stadium S
JOIN
    FilteredStadium FS ON S.id = FS.id
WHERE
    FS.consecutive_group IN (SELECT consecutive_group FROM CountedGroups)
ORDER BY
    S.visit_date ASC;