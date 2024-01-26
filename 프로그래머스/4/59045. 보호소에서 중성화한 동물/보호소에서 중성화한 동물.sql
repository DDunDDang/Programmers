-- 코드를 입력하세요
SELECT AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM ANIMAL_INS 
AI LEFT JOIN ANIMAL_OUTS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.SEX_UPON_INTAKE LIKE 'INTACT%'
AND (AO.SEX_UPON_OUTCOME LIKE 'SPAYED%'
OR AO.SEX_UPON_OUTCOME LIKE 'NEUTERED%')
ORDER BY AI.ANIMAL_ID ASC