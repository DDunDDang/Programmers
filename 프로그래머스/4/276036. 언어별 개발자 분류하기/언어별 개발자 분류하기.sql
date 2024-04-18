-- 코드를 작성해주세요
WITH grade AS (
    SELECT 
        ID,
        EMAIL,
        CASE
           WHEN COUNT(CASE WHEN CATEGORY = 'Front End' THEN 1 END) > 0 AND 
                COUNT(CASE WHEN NAME = 'Python' THEN 1 END) > 0 
                THEN 3
           WHEN COUNT(CASE WHEN NAME = 'C#' THEN 1 END) > 0 THEN 2
           WHEN COUNT(CASE WHEN CATEGORY = 'Front End' THEN 1 END) > 0 THEN 1
        END AS SCORE
    FROM
        DEVELOPERS D JOIN SKILLCODES S ON D.SKILL_CODE & S.CODE
    GROUP BY ID,EMAIL
    HAVING SCORE > 0
)
SELECT 
    CASE 
        WHEN SCORE = 3 THEN 'A'
        WHEN SCORE = 2 THEN 'B'
        WHEN SCORE = 1 THEN 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM grade
ORDER BY GRADE, ID