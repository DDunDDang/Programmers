-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', FILE.BOARD_ID, '/', FILE.FILE_ID, FILE.FILE_NAME, FILE.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS FILE
LEFT JOIN USED_GOODS_BOARD AS BOARD
ON FILE.BOARD_ID = BOARD.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY FILE_ID DESC