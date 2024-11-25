public class Converter {
    private static final double STEPS_TO_METERS = 0.75; // 1 шаг = 75 см
    private static final double CALORIES_PER_STEP = 0.05; // 1 шаг = 50 кал

    // Перевод шагов в километры
    public double convertToKm(int steps) {
        return steps * STEPS_TO_METERS / 1000;
    }

    // Перевод шагов в килокалории
    public double convertStepsToKilocalories(int steps) {
        return steps * CALORIES_PER_STEP / 1000;
    }
}