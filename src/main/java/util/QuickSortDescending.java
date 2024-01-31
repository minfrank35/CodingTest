package util;

/**
 *  ** 내림차순 QuickSort **
 * 사용예시
 * int[] arr = { 3, 1, 5, 6, 20, 10, 7, 11, 15, 9 };
 * QuickSortDescending.quickSort(arr);
 *
 * 사용원리
 * pivot을 중심으로 왼쪽에 큰값 오른쪽에 작은값을 배치하는 작업을 반복해서 실시
 *
 * 평균 시간
 * O(nlogn)
 *
 * 최장시간
 * O(n^2)
 */
public class QuickSortDescending {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        // start가 end보다 크거나 같다면 정렬할 원소가 1개 이하이므로 정렬하지 않고 return
        if (start >= end)
            return;

        // 가장 왼쪽의 값을 pivot으로 지정, 실제 비교 검사는 start+1 부터 시작
        int pivot = start;
        int lo = start + 1;
        int hi = end;

        // lo는 현재 부분배열의 왼쪽, hi는 오른쪽을 의미
        // 서로 엇갈리게 될 경우 while문 종료
        while (lo <= hi) {
            while (lo <= end && arr[lo] >= arr[pivot]) // 피벗보다 작은 값을 만날 때까지
                lo++;
            while (hi > start && arr[hi] <= arr[pivot]) // 피벗보다 큰 값을 만날 때까지
                hi--;
            if (lo > hi)				 // 엇갈리면 피벗과 교체
                swap(arr, hi, pivot);
            else
                swap(arr, lo, hi);			 // 엇갈리지 않으면 lo, hi 값 교체
        }

        // 엇갈렸을 경우,
        // 피벗값과 hi값을 교체한 후 해당 피벗을 기준으로 앞 뒤로 배열을 분할하여 정렬 진행
        quickSort(arr, start, hi - 1);
        quickSort(arr, hi + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
