package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    Integer tmp = 1;
    if (n >= 0 && i >= 0) {
      for (Integer it = 0; it < n; it++) {
        if (tmp * i == 0 && i != 0)
          return Option.none();
        tmp *= i;
      }
      return Option.of(tmp);
    }
    else
      return Option.none();
  }
}
