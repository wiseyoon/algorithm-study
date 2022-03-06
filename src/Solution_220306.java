import java.util.HashMap;
import java.util.Map;

public class Solution_220306 {

    public static void main(String args[]) {
        solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }

    /**
     * [프로그래머스] 완주하지 못한 선수
     * https://programmers.co.kr/learn/courses/30/lessons/42576
     * @param participant 참여자
     * @param completion 완주자
     * @return
     */
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String part: participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String comp: completion) {
            map.put(comp, map.get(comp) -1);
        }

        for (String key: map.keySet()) {
            if (map.get(key) != 0) {
                System.out.println(key);
                return key;
            }
        }

        return "";
    }
}
