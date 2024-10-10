import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
        for (String term : terms) {
            String[] parts = term.split(" ");
            termsMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            LocalDate collectionDate = LocalDate.parse(parts[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            String termType = parts[1];
            
            LocalDate expirationDate = collectionDate.plusMonths(termsMap.get(termType)).minusDays(1);
            
            expirationDate = adjustDate(expirationDate);
            
            if (todayDate.isAfter(expirationDate)) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private LocalDate adjustDate(LocalDate date) {
        int day = date.getDayOfMonth();
        if (day > 28) {
            return date.withDayOfMonth(28);
        }
        return date;
    }
}