package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  private static double power(double i, double n) {
    double res = 1;
    for (double it = 0; it < n; it++) {
      res *= i;
    }
    return res;
  }
  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    return input.stream().map(x -> power(x * 2 + 3,5)).collect(Collectors.toList());
  }

  private static String capital(String str) {
    if (str == null || str.length() == 0)
      return str;
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    return input.stream().map(x -> capital(x).repeat(2)).collect(Collectors.toList());
  }

}
