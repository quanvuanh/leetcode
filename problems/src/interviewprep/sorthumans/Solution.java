package interviewprep.sorthumans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    List<Human> humans = new ArrayList<>();
    humans.add(new Human(LocalDate.of(2025, 1, 23), "Bob"));
    humans.add(new Human(LocalDate.of(2012, 3, 23), "Alice"));
    humans.add(new Human(LocalDate.of(2003, 12, 23), "Zero"));
    humans.add(new Human(LocalDate.of(2015, 3, 23), "Bob"));
    humans.add(new Human(LocalDate.of(2012, 3, 22), "Charles"));
    humans.add(new Human(LocalDate.of(2003, 12, 23), "Harry"));
    humans.add(new Human(LocalDate.of(1923, 3, 23), "Bob"));
    humans.add(new Human(LocalDate.of(1959, 3, 23), "Bob"));

    List<Human> otherHumans = new ArrayList<>(humans);

    Solution.sort(humans);
    Solution.sortWithComparator(otherHumans);
    System.out.println(humans);
    System.out.println(otherHumans);
    System.out.println(humans.equals(otherHumans));
  }

  public static void sort(List<Human> inputList) {
    inputList.sort(Solution::compare);


  }

  public static void sortWithComparator(List<Human> inputList) {
    inputList.sort(
      Comparator
        .comparing(Human::birthday)
        .thenComparing(Human::name)
    );
  }

  private static int compare(Human a, Human b) {
    if (a.birthday().isEqual(b.birthday())) {
      return a.name().compareTo(b.name());
    }

    return a.birthday().compareTo(b.birthday());
  }
}

