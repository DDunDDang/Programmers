-- 코드를 작성해주세요
WITH Return_Name AS (
    SELECT
        ID,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS ntile_num
    FROM ECOLI_DATA
)

SELECT
    ID,
    CASE
        WHEN ntile_num = 1 THEN 'CRITICAL'
        WHEN ntile_num = 2 THEN 'HIGH'
        WHEN ntile_num = 3 THEN 'MEDIUM'
        WHEN ntile_num = 4 THEN 'LOW'
    END AS COLONY_NAME
FROM Return_Name
ORDER BY ID