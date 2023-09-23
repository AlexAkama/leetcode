package algorithm;

public class BinarySearch {

    // Принимаем на вход отсортированный массив и целевое значение.
    // Ищем индекс на котором расположено целевое значение.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Ищем середину массива
            int mid = left + (right - left) / 2;

            // Если целевое значение
            // равно значению из середины возвращаем mid
            if (arr[mid] == target) {
                return mid;
            }

            // меньше => меняем левую границу
            // больше => правую
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Если значение не найдено
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Элемент не найден в массиве");
        } else {
            System.out.println("Элемент найден в индексе: " + result);
        }
    }

}

