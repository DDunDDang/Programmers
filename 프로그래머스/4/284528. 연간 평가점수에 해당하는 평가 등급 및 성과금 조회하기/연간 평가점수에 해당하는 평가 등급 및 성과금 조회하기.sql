-- 코드를 작성해주세요
WITH grade AS (
    SELECT
        EMP_NO,
        AVG(SCORE) AS SCORE_AVG
    FROM HR_GRADE
    GROUP BY EMP_NO
)
SELECT
    E.EMP_NO,
    E.EMP_NAME,
    CASE
        WHEN G.SCORE_AVG >= 96 THEN 'S'
        WHEN G.SCORE_AVG >= 90 THEN 'A'
        WHEN G.SCORE_AVG >= 80 THEN 'B'
        ELSE 'C' 
        END
        AS GRADE,
    CASE
        WHEN G.SCORE_AVG >= 96 THEN E.SAL * 0.2
        WHEN G.SCORE_AVG >= 90 THEN E.SAL * 0.15
        WHEN G.SCORE_AVG >= 80 THEN E.SAL * 0.1
        ELSE E.SAL * 0
        END
        AS BONUS
FROM HR_EMPLOYEES E JOIN grade G ON E.EMP_NO = G.EMP_NO
ORDER BY E.EMP_NO
