package io.github.jfuncy;

import java.util.Optional;
import java.util.function.Function;

public class Monads {

    private static class Once<T, R> implements Function<Function<T, R>, Function<T, Optional<R>>> {

        private boolean ran;

        @Override
        public Function<T, Optional<R>> apply(Function<T, R> func) {
            return t -> {
                if (ran) {
                    return Optional.empty();
                } else {
                    R r = func.apply(t);
                    ran = true;
                    return Optional.ofNullable(r);
                }
            };
        }
    }

    public static <T, R> Function<T, Optional<R>> once(Function<T, R> func) {
        return new Once<T, R>().apply(func);
    }
}
