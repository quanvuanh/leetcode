package interviewprep.reverselist;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    List<Integer> a = Solution.reverse(List.of(1, 2, 3, 4, 5));
    System.out.println(a);
  }

  public static <E> List<E> reverse(List<E> inputList) {
    List<E> reversedList = new ArrayList<>();
    for (int i = inputList.size() - 1; i >= 0; i--) {
      reversedList.add(inputList.get(i));
    }

    return reversedList;
  }
}
