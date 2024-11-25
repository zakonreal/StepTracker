public class MonthData {
    private final int[] days;

    public MonthData() {
        this.days = new int[30]; // Предположим, что в каждом месяце 30 дней
    }

    // Метод для получения количества шагов за определенный день
    public int getStepsForDay(int day) {
        if (day < 1 || day > 30) {
            throw new IllegalArgumentException("День должен быть между 1 и 30");
        }
        return days[day - 1];
    }

    // Метод для записи количества шагов за определенный день
    public void setStepsForDay(int day, int steps) {
        if (day < 1 || day > 30) {
            throw new IllegalArgumentException("День должен быть между 1 и 30");
        }
        days[day - 1] = steps;
    }

    // Вывод на экран элементов массива в нужном формате
    public void printDaysAndStepsFromMonth() {
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + " день: " + getStepsForDay(i));
        }
    }

    // Подсчёт суммы шагов за месяц
    public int sumStepsFromMonth() {
        int sum = 0;
        for (int step : days) {
            sum += step;
        }
        return sum;
    }

    // Максимальное количество шагов за месяц
    public int maxSteps() {
        int max = Integer.MIN_VALUE;
        for (int step : days) {
            max = Math.max(max, step);
        }
        return max;
    }

    // Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов было больше или равно цели
    public int bestSeries(int goalByStepsPerDay) {
        int bestStreak = 0, currentStreak = 0;

        for (int day = 1; day <= 30; day++) {
            if (getStepsForDay(day) >= goalByStepsPerDay) {
                currentStreak++;
                bestStreak = Math.max(bestStreak, currentStreak);
            } else {
                currentStreak = 0; // Обнуляем текущую серию
            }
        }

        return bestStreak;
    }
}