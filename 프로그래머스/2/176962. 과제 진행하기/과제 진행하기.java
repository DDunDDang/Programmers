import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 시간 처리를 위해 각 과제를 분 단위로 변환
        for (String[] plan : plans) {
            String[] timeParts = plan[1].split(":");
            int startTimeInMinutes = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            plan[1] = String.valueOf(startTimeInMinutes);
        }

        // 시작 시간을 기준으로 과제를 정렬
        Arrays.sort(plans, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

        List<String> result = new ArrayList<>();
        Stack<String[]> pausedTasks = new Stack<>();
        int currentTime = 0;

        for (int i = 0; i < plans.length; i++) {
            String[] currentTask = plans[i];
            int startTime = Integer.parseInt(currentTask[1]);
            int duration = Integer.parseInt(currentTask[2]);

            // 이전 작업이 있다면 남은 시간 처리
            while (!pausedTasks.isEmpty() && currentTime < startTime) {
                String[] pausedTask = pausedTasks.pop();
                int remainingTime = Integer.parseInt(pausedTask[2]);

                // 현재 시간 + 남은 시간 <= 시작 시간인 경우 과제 완료
                if (currentTime + remainingTime <= startTime) {
                    currentTime += remainingTime;
                    result.add(pausedTask[0]);
                } else {
                    // 아직 시간이 남아있는 경우 다시 스택에 넣기
                    pausedTask[2] = String.valueOf(remainingTime - (startTime - currentTime));
                    pausedTasks.push(pausedTask);
                    currentTime = startTime;
                    break;
                }
            }

            // 새로운 과제 시작
            currentTime = startTime + duration;

            // 다음 작업이 있다면 현재 작업을 중단하고 스택에 저장
            if (i < plans.length - 1) {
                int nextStartTime = Integer.parseInt(plans[i + 1][1]);
                if (currentTime > nextStartTime) {
                    currentTask[2] = String.valueOf(currentTime - nextStartTime);
                    pausedTasks.push(currentTask);
                    currentTime = nextStartTime;
                } else {
                    result.add(currentTask[0]);
                }
            } else {
                result.add(currentTask[0]);
            }
        }

        // 스택에 남아있는 작업들 마무리
        while (!pausedTasks.isEmpty()) {
            result.add(pausedTasks.pop()[0]);
        }

        return result.toArray(new String[0]);
    }
}
