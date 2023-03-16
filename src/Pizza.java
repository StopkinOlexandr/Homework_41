import exception.IncorrectWeightException;

public class Pizza {
//  Задача 1
//  Создайте своё собственное исключение IncorrectWeightException и
//  унаследуйте его от IllegalArgumentException.
//
//  Добавьте ему конструктор, в который можно передавать одно целое число.
//
//  При этом супер-класс IllegalArgumentException должен создаваться с
//  сообщением об ошибке вида "Вес не может быть отрицательным: [некоректный вес]"
//
//  Дополните файл Pizza.java из классной работы, выбросив в конструкторе исключение
//  IncorrectWeightException при попытке создать пиццу с отрицательной массой.

//  Задача 2* (не обязательно)
//  Дополните файлы Pizza.java и PizzaRunner.java из классной работы (и задачи № 1).
//
//  Добавьте классу Pizza приватный статический атрибут - максимально возможный вес пиццы.
//
//  Добавьте классу Pizza публичный статический метод (сеттер) для изменения этого атрибута.
//
//  При запуске программы PizzaRunner.java должна быть возможность:
//
//  запустить программу как раньше, без аргументов, тогда ограничения нет
//  (Или есть? подсказка: Integer.MAX_VALUE).
//  запустить программу с одним аргументом командной строки: целым числом.
//  Тогда именно это целое число и будет максимально возможным весом пиццы (в граммах).
//  Примечание
//  Вы также можете проверить параметр командно строки на корректность и использовать
//  IncorrectWeightException из задачи 1 в случае некорректного запуска программы.

  private String title;
  private int weight;
  private static int maxWeight;

  public static void setMaxWeight(int weigh){
    maxWeight = weigh;
  }

  public Pizza(String title, int weight) {
    this.title = title;
    if (weight < 0) {
      throw new IncorrectWeightException(weight);
    }
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Пицца '" + title + "' весом " + weight + " г";
  }

  // метод equals должен уметь сравнивать наш объект с ЛЮБЫМ
  // возвращаем true, если объекты равны, и false, если не равны
  @Override
  public boolean equals(Object obj) {
    if (this == obj) { // мы сравниваем объект сам с собой (сравниваем ссылки)
      return true;
    }
    // если obj является разновидностью класса Pizza, то
    // превращаем его в объект otherPizza класса Pizza
    if (!(obj instanceof Pizza otherPizza)) {
      return false; // если "другой" объект - не пицца, то они не равны
    }
    // пиццы равны, только если совпадают названия и вес
    return title.equals(otherPizza.title) && weight == otherPizza.weight;
  }

  // переопределение equals ДОЛЖНО приводить к переопределению hashCode()
  // это специальный метод, по которому Hash* (HashSet, HashMap) решает, нужно ли вообще
  // сравнивать наши объекты.
  // Если hashCode() разный, то Hash* считает объекты РАЗНЫМИ и даже не пытается их сравнивать
  // Если hashCode() одинаковый, то Hash* сравнивает объекты через equals()
  @Override
  public int hashCode() {
    // !!! для одинаковых (через equals()) элементов hashCode() ОБЯЗАН возвращать одинаковый hash
    // это значит, что мы должны учитывать все поля, которые сравниваются в equals() (и только их)
    return 31 * weight * title.hashCode();
  }
}
