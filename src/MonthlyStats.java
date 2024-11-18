public class MonthlyStats {
    private final int totalSteps;
    private final double averageSteps;
    private final int bestStreak;
    private final double distanceInKm;
    private final double caloriesBurned;

    public MonthlyStats(int totalSteps, double averageSteps, int bestStreak, double distanceInKm, double caloriesBurned) {
        this.totalSteps = totalSteps;
        this.averageSteps = averageSteps;
        this.bestStreak = bestStreak;
        this.distanceInKm = distanceInKm;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Статистика за месяц:\n" +
                "Всего шагов: " + totalSteps + "\n" +
                "Среднее количество шагов в день: " + String.format("%.2f", averageSteps) + "\n" +
                "Лучшая серия: " + bestStreak + " дней\n" +
                "Пройдено километров: " + String.format("%.2f", distanceInKm) + " км\n" +
                "Сожжено калорий: " + caloriesBurned + " ккал";
    }
}