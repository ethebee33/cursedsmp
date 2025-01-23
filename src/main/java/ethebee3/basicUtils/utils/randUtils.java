package ethebee3.basicUtils.utils;

import java.util.Random;

public class randUtils {
    static Random random = new Random();
    public static int generateRandomInt(int min, int max) {
        int r = random.nextInt(max - min);
        return r + min;
    }

    public static Double generateRandomDouble(Double min, Double max) {
        Double r = random.nextDouble(max - min);
        return r + min;
    }

}
