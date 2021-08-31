package lesson_1.task_1;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    Integer[] array1 = { 1, 2, 3, 4 };
    String[] array2 = { "a", "b", "c", "d", "e", "f" };

    swapArrayElements(array1, 1, 2);
    System.out.println(Arrays.toString(array1));
    swapArrayElements(array2, 6, 5);
    System.out.println(Arrays.toString(array2));
    swapArrayElements(array1, 0, 1);
    System.out.println(Arrays.toString(array1));
    swapArrayElements(array2, 6, 7);
    System.out.println(Arrays.toString(array2));

  }

  private static <T> void swapArrayElements(T[] array, int x, int y) {
    if (x > 0 && y > 0 && x <= array.length && y <= array.length) {
      T temp = array[x - 1];
      array[x - 1] = array[y - 1];
      array[y - 1] = temp;
    } else {
      System.out.println("One of the element indexes is out of array boundary. The array has not been changed.");
    }
  }
}
