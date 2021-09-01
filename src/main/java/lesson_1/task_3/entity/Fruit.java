package lesson_1.task_3.entity;

public abstract class Fruit {
  private float weightInGram;

  public Fruit(float weightInGram) {
    if(weightInGram > 0) {
      this.weightInGram = weightInGram;
    } else {
      System.out.println("Invalid weight");
    }
  }

  public float getWeight() {
    return weightInGram;
  }
}
