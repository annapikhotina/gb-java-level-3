package lesson_1.task_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    String[] array1 = {"one", "two", "three", "four", "five"};

    System.out.println(arrayToArrayList(array1).getClass().getSimpleName());
    System.out.println(arrayToArrayList(array1));
  }

  private static <T> ArrayList<T> arrayToArrayList(T[] array) {
    return new ArrayList<>(Arrays.asList(array));
  }
}
