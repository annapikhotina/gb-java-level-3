package lesson_1.task_3;

import lesson_1.task_3.entity.Box;
import lesson_1.task_3.entity.impl.Apple;
import lesson_1.task_3.entity.impl.Orange;

public class Main {

  public static void main(String[] args) {

    Box<Apple> appleBox = new Box<>();
    appleBox.addFruit(new Apple(1.5f));
    appleBox.addFruit(new Apple(2.0f));
    appleBox.addFruit(new Apple(3.5f));
    appleBox.addFruit(new Apple(4.55f));
    System.out.printf("AppleBox weight = %f\n", appleBox.getWeight());

    Box<Apple> appleBoxB = new Box<>();
    appleBoxB.addFruit(new Apple(2.0f));

    Box<Apple> appleBoxA = new Box<>();

    Box<Orange> orangeBox = new Box<>();
    orangeBox.addFruit(new Orange(2.0f));
    orangeBox.addFruit(new Orange(3.0f));
    orangeBox.addFruit(new Orange(4.5f));
    orangeBox.addFruit(new Orange(5.50f));
    System.out.printf("orangeBox weight = %f\n", orangeBox.getWeight());

    Box<Orange> orangeBoxSameWeight = new Box<>();
    orangeBoxSameWeight.addFruit(new Orange(1.5f));
    orangeBoxSameWeight.addFruit(new Orange(2.0f));
    orangeBoxSameWeight.addFruit(new Orange(3.5f));
    orangeBoxSameWeight.addFruit(new Orange(4.55f));
    System.out.printf("orangeBoxSameWeight weight = %f\n", orangeBoxSameWeight.getWeight());

    System.out.println("----- Compare to different weight box -----");
    System.out.printf("Is appleBox the same weight as orangeBox? - %b\n", appleBox.compareTo(orangeBox));

    System.out.println("----- Compare to the same weight box -----");
    System.out.printf("Is appleBox the same weight as orangeBoxSameWeight? - %b\n", appleBox.compareTo(orangeBoxSameWeight));

    System.out.println("----- Move fruits from - to the same box -----");
    appleBox.moveTo(appleBox);

    System.out.println("#### Move fruits to empty box ###");
    System.out.printf("Weight of target box before: %f\n", appleBoxA.getWeight());
    System.out.printf("Weight of source box before: %f\n", appleBox.getWeight());
    appleBox.moveTo(appleBoxA);
    System.out.printf("Weight of target box after: %f\n", appleBoxA.getWeight());
    System.out.printf("Weight of source box after: %f\n", appleBox.getWeight());

    System.out.println("#### Move fruits to not empty box ###");
    System.out.printf("Weight of target box before: %f\n", appleBoxB.getWeight());
    System.out.printf("Weight of source box before: %f\n", appleBoxA.getWeight());
    appleBoxA.moveTo(appleBoxB);
    System.out.printf("Weight of target box after: %f\n", appleBoxB.getWeight());
    System.out.printf("Weight of source box after: %f\n", appleBoxA.getWeight());

  }
}
