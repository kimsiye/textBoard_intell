package txtBoard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();         // 현재 날짜/시간
        System.out.println(now); // 2021-12-02T18:19:36.897421300        // 현재 날짜/시간 출력
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));        // 포맷팅
        System.out.println(formatedNow); // 2021년 12월 02일 18시 19분 36초  // 포맷팅 현재 날짜/시간 출력
    }
}
