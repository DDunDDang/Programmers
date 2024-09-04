import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<int[]> times = new ArrayList<>();
        
        for (String[] time : book_time) {
            int start = timeToMinutes(time[0]);
            int end = timeToMinutes(time[1]) + 10;
            times.add(new int[] { start, end });
        }
        
        times.sort(Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        
        for (int[] time : times) {
            int startTime = time[0];
            int endTime = time[1];
            
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= startTime) {
                roomEndTimes.poll();
            }
            
            roomEndTimes.offer(endTime);
        }
        
        return roomEndTimes.size();
    }
    
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}
