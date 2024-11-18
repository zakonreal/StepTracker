public class Converter {
    private static final double STEPS_PER_KILOMETER = 1333.33; // Предположительно, 1 км = 1333.33 шага
    private static final double CALORIES_PER_STEP = 0.05;      // 1 шаг = 0.05 ккал

    public static double stepsToKilometers(int steps) {
        return steps / STEPS_PER_KILOMETER;
    }

    public static double caloriesBurned(int steps) {
        return steps * CALORIES_PER_STEP;
    }
}