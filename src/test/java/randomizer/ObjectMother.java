package randomizer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;

import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMother {
    private static final EasyRandom RANDOMIZER = new EasyRandom(
            RandomizerSupport.getStandardRandomParameters());
    public static <T> T next(Class<T> clazz) {
        return RANDOMIZER.nextObject(clazz);
    }

    public static <T> T next(Class<T> clazz,
                             Consumer<T> customizer) {
        T obj = next(clazz);
        customizer.accept(obj);
        return obj;
    }
}
