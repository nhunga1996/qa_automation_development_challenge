package randomizer;

import Constant.RoleTypeEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.number.BigDecimalRandomizer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomizerSupport {

    public static final int DEFAULT_RANDOM_STRING_SIZE = 10;

    public static EasyRandomParameters getStandardRandomParameters() {
        return new EasyRandomParameters()
                .seed(System.currentTimeMillis())
                .objectPoolSize(100)
                .randomizationDepth(10)
                .stringLengthRange(10, 20)
                .collectionSizeRange(0, 10)
                .charset(StandardCharsets.UTF_8)
                .randomize(Integer.class, RandomUtils::nextInt)
                .randomize(int.class, RandomUtils::nextInt)
                .randomize(Long.class, RandomUtils::nextLong)
                .randomize(long.class, RandomUtils::nextLong)
                .randomize(BigDecimal.class, new BigDecimalRandomizer(2, RoundingMode.HALF_UP))
                .randomize(RoleTypeEnum.class, new RoleTypeRandomizer())
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
    }

    public static String randomAlphabetic() {
        return RandomStringUtils.randomAlphabetic(DEFAULT_RANDOM_STRING_SIZE);
    }

    public static String randomAlphabetic(int minLength, int maxLength) {
        int length = randomInt(minLength, maxLength);
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static int randomInt(int min, int max) {
        Random random = new Random();
        return Math.round(random.nextFloat() * (max - min) + min);
    }

    public static <T> T randomElement(T... array) {
        return array[nextInt(0, array.length)];
    }

    public static <T> T randomElement(Collection<T> collection) {
        int randomIndex = nextInt(0, collection.size());
        int index = 0;
        for (T t : collection) {
            if (index == randomIndex) {
                return t;
            }

            index++;
        }

        throw new AssertionError();
    }

    public static <T extends Enum<T>> T randomEnum(Class<T> enumClass,
                                                   T... excludedValues) {
        T[] enumValues = ArrayUtils.removeElements(enumClass.getEnumConstants(), excludedValues);
        return enumValues[nextInt(0, enumValues.length)];
    }

    public static String randomPassword() {
        int length = randomInt(10, 20);
        String upper = RandomStringUtils.random(2, 65, 91, true, true); // A-Z
        String lower = RandomStringUtils.random(2, 97, 123, true, true); // a-z
        String special = RandomStringUtils.random(2, 33, 48, false, false); // special chars
        String number = RandomStringUtils.randomNumeric(3);
        String other = RandomStringUtils.random(length - 6, true, true);
        String combined = upper + lower + special + number + other;
        List<String> chars = Arrays.asList(combined.split(""));
        Collections.shuffle(chars);
        return String.join("", chars);
    }
}