public class Solution_220307 {

    public static void main(String args[]) {
        solution("...!@BaT#*..y.abcdefghijklm");
    }

    /**
     * [프로그래머스] 신규 아이디 추천
     * https://programmers.co.kr/learn/courses/30/lessons/72410
     * 정규식 참고: https://codez.tistory.com/4
     *          : https://codechacha.com/ko/java-regex/
     * @param new_id 입력ID
     * @return 추천ID
     */
    public static String solution(String new_id) {

        // [STEP 1] new_id의 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();

        // [STEP 2] 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        // [STEP 3] 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("[.]{2,}",".");

        // [STEP 4] 마침표(.)가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^[.]|[.]$","");

        // [STEP 5] 빈 문자열이라면, new_id에 "a"를 대입
        if (new_id.isEmpty()) new_id = "a";

        // [STEP 6] 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$","");
        }

        // [STEP 7] 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        while (new_id.length() <3) {
            new_id += new_id.charAt(new_id.length()-1);
        }

        return new_id;
    }

}
