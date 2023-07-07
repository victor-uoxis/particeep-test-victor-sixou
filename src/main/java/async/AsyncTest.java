package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      for (int i = 0; i < ceos.size(); i++) {
        if (ceos.get(i).id.equals(ceo_id)) {
          return Option.of(ceos.get(i));
        }
      }
      return Option.none();
    });
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      for (int i = 0; i < enterprises.size(); i++) {
        if (enterprises.get(i).ceo_id.equals(ceo_id)) {
          return Option.of(enterprises.get(i));
        }
      }
      return Option.none();
    });
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      return new Tuple2<>(getCeoById(ceo_id).join(), getEnterpriseByCeoId(ceo_id).join());
    });
  }
}
