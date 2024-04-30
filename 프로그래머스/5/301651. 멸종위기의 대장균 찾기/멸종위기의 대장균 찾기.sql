-- 코드를 작성해주세요
WITH RECURSIVE ECOLI_GENERATIONS AS (
    SELECT
        ID,
        PARENT_ID,
        1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT
        D.ID,
        D.PARENT_ID,
        G.GENERATION + 1 AS GENERATION
    FROM ECOLI_DATA D INNER JOIN ECOLI_GENERATIONS G ON D.PARENT_ID = G.ID
)
SELECT
    COUNT(GENERATION) AS COUNT,
    GENERATION
FROM ECOLI_GENERATIONS
WHERE NOT ID IN (
    SELECT DISTINCT PARENT_ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NOT NULL)
GROUP BY 2
ORDER BY 2