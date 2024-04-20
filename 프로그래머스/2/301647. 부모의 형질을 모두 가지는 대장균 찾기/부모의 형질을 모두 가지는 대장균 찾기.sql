-- 코드를 작성해주세요
SELECT
    E1.ID,
    E1.GENOTYPE,
    E2.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA E1 JOIN ECOLI_DATA E2 ON E1.PARENT_ID = E2.ID
WHERE E1.GENOTYPE & E2.GENOTYPE = E2.GENOTYPE
ORDER BY E1.ID