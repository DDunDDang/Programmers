import java.util.*;

class Solution {
    static Map<String, Integer> parseMap;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();

        parseMap = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] tempRecords = records[i].split(" ");
            if (tempRecords[2].equals("IN")) {
                map.put(tempRecords[1], tempRecords[0]);
            } else {
                parse(map.get(tempRecords[1]), tempRecords[0], tempRecords[1]);
                map.remove(tempRecords[1]);
            }
        }

        if (!map.isEmpty()) {
            for (String s : map.keySet()) {
                parse(map.get(s), "23:59", s);
            }
        }

        cul(fees);

        List<Integer> list = new ArrayList<>();
        for (String key : parseMap.keySet()) {
            list.add(parseMap.get(key));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static void parse(String in, String out, String carNum) {
        String[] outTemp = out.split(":");
        String[] inTemp = in.split(":");
        int outMin = Integer.parseInt(outTemp[0]) * 60 + Integer.parseInt(outTemp[1]);
        int inMin = Integer.parseInt(inTemp[0]) * 60 + Integer.parseInt(inTemp[1]);
        int dif = outMin - inMin;
        parseMap.put(carNum, parseMap.getOrDefault(carNum, 0) + dif);
    }

    static void cul(int[] fees) {
        for (String key : parseMap.keySet()) {
            if (parseMap.get(key) < fees[0]) {
                parseMap.put(key, fees[1]);
            } else {
                double addTime = parseMap.get(key) - fees[0];
                addTime = Math.ceil(addTime / fees[2]);
                int result = (int) (addTime * fees[3] + fees[1]);
                parseMap.put(key, result);
            }
        }
    }
}