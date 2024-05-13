import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        int changeCount = 0;

        for (int i = 0; i < record.length; i++) {
            if (record[i].contains("Leave")) continue;

            String[] arr = record[i].split(" ");

            if (arr[0].equals("Enter")) hashMap.put(arr[1], arr[2]);
            else if (arr[0].equals("Change")) {
                hashMap.put(arr[1], arr[2]);
                changeCount++;
            }
        }

        String[] answer = new String[record.length - changeCount];
        int answerIdx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");

            if (arr[0].equals("Leave")) {
                answer[answerIdx++] = hashMap.get(arr[1]) + "님이 나갔습니다.";
            } else if (arr[0].equals("Enter")) {
                answer[answerIdx++] = hashMap.get(arr[1]) + "님이 들어왔습니다.";
            }

        }
        return answer;
    }
}