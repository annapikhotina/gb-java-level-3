package lesson_1.task_3.entity;

import java.util.ArrayList;

public class Box <T extends Fruit> {
 private ArrayList<T> fruits = new ArrayList<>();

  public ArrayList<T> getFruits() {
    return fruits;
  }

  public void addFruit(T fruit) {
    fruits.add(fruit);
  }

  public float getWeight() {
    float weight = 0f;
    for(T fruit: fruits) {
      weight += fruit.getWeight();
    }
    return weight;
  }

  public boolean compareTo(Box<?> box) {
    return Float.compare(getWeight(), box.getWeight()) == 0;
  }

  public void moveTo(Box<T> box) {
    if(box != this) {
      box.getFruits().addAll(fruits);
      fruits.clear();
    } else {
      System.out.println("Move fruits to the same box prohibited");
    }
  }
}
