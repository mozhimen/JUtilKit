package com.mozhimen.java.utilk.java.ranges;


/**
 * @ClassName UtilK_Ranges
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilK_Ranges {
    public static long constraint(long value, long min, long max) {
        long minV = Math.min(min, max);
        long maxV = Math.max(min, max);
        return coerceIn(value, minV, maxV);
    }

    public static float constraint(float value, float min, float max) {
        float minV = Math.min(min, max);
        float maxV = Math.max(min, max);
        return coerceIn(value, minV, maxV);
    }

    public static double constraint(double value, double min, double max) {
        double minV = Math.min(min, max);
        double maxV = Math.max(min, max);
        return coerceIn(value, minV, maxV);
    }

    public static int constraint(int value, int min, int max) {
        int minV = Math.min(min, max);
        int maxV = Math.max(min, max);
        return coerceIn(value, minV, maxV);
    }

    public static int coerceIn(int value, int minimumValue, int maximumValue) {
        if (minimumValue > maximumValue)
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.");
        if (value < minimumValue) return minimumValue;
        return Math.min(value, maximumValue);
    }

    public static double coerceIn(double value, double minimumValue, double maximumValue) {
        if (minimumValue > maximumValue)
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.");
        if (value < minimumValue) return minimumValue;
        return Math.min(value, maximumValue);
    }

    public static float coerceIn(float value, float minimumValue, float maximumValue) {
        if (minimumValue > maximumValue)
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.");
        if (value < minimumValue) return minimumValue;
        return Math.min(value, maximumValue);
    }

    public static long coerceIn(long value, long minimumValue, long maximumValue) {
        if (minimumValue > maximumValue)
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.");
        if (value < minimumValue) return minimumValue;
        return Math.min(value, maximumValue);
    }
}
