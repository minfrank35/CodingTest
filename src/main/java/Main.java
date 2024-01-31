import util.QuickSortAscending;
import util.QuickSortDescending;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Programmers
 * 문제명 : 최댓값과 최소값
 * 실행 예시
 * String s = "1 2 3 4";
 * System.out.println(new Solution().solution(s));
 * 
 * @author minfrank
 * @since 2024-01-31
 */
class Solution_MINMAX {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] newArr = Stream.of(arr).mapToInt(Integer::parseInt).toArray();
        QuickSortAscending.quickSort(newArr);
        System.out.println(Arrays.toString(newArr));

        StringBuilder sbAnswer = new StringBuilder();
        sbAnswer.append(newArr[0]);
        sbAnswer.append(" ");
        sbAnswer.append(newArr[newArr.length - 1]);

        return sbAnswer.toString();
    }
}