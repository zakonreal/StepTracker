import java.util.Scanner;

public class StepTracker {
    private final MonthData[] monthToData;
    private int goalStepsPerDay;
    private Scanner scanner;
    private Converter converter;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
        this.monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
        this.goalStepsPerDay = 10000; // Цель по умолчанию
        this.converter = new Converter();
    }

    // Метод для ввода нового количества шагов за день
    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (1-12): ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка! Номер месяца должен быть от 1 до 12.");
            return;
        }

        System.out.println("Введите номер дня (1-30): ");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Ошибка! День должен быть от 1 до 30.");
            return;
        }

        System.out.println("Введите количество шагов: ");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Ошибка! Количество шагов должно быть неотрицательным.");
            return;
        }

        monthToData[month - 1].setStepsForDay(day, steps);
        System.out.println("Данные успешно сохранены.");
    }

    // Метод для изменения цели по количеству шагов в день
    public void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов в день: ");
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Ошибка! Цель должна быть положительной.");
            return;
        }
        this.goalStepsPerDay = newGoal;
        System.out.println("Цель изменена на " + newGoal + " шагов в день.");
    }

    // Метод для вывода статистики за определенный месяц
    public void printStatisticsForMonth() {
        System.out.println("Введите номер месяца (1-12), за который хотите получить статистику: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка! Номер месяца должен быть от 1 до 12.");
            return;
        }

        MonthData data = monthToData[month - 1];
        int totalSteps = data.sumStepsFromMonth();

        // Вывод статистики
        data.printDaysAndStepsFromMonth(); // Количество пройденных шагов по дням
        System.out.println("\nОбщее количество шагов за месяц: " + totalSteps);
        System.out.println("Максимальное количество шагов в месяце: " + data.maxSteps());
        System.out.println("Среднее количество шагов: " + ((double) totalSteps / 30));
        System.out.println("Пройденная дистанция (км): " + converter.convertToKm(totalSteps));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(totalSteps));
        System.out.println("Лучшая серия: " + data.bestSeries(this.goalStepsPerDay) + " дней");
    }

    private int findMaxSteps(MonthData data) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 30; i++) {
            max = Math.max(max, data.getStepsForDay(i));
        }
        return max;
    }

    private int findMinSteps(MonthData data) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 30; i++) {
            min = Math.min(min, data.getStepsForDay(i));
        }
        return min;
    }
}