import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static StepTracker tracker = new StepTracker();

    public static void main(String[] args) {
        printWelcomeMessage();

        while (true) {
            printMenu();
            int option = SCANNER.nextInt();
            processOption(option);
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("Добро пожаловать в приложение-счётчик шагов и калорий!");
        System.out.println("Пожалуйста, введите вашу цель по количеству шагов в день:");
        int dailyGoal = SCANNER.nextInt();
        tracker.setDailyGoal(dailyGoal);
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выйти из приложения");
    }

    private static void processOption(int option) {
        switch (option) {
            case 1:
                enterStepsForDay();
                break;
            case 2:
                printMonthlyStatistics();
                break;
            case 3:
                changeDailyGoal();
                break;
            case 4:
                exitApplication();
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, попробуйте ещё раз.");
        }
    }

    private static void enterStepsForDay() {
        System.out.println("Введите дату (формат ГГГГ-ММ-ДД):");
        String dateInput = SCANNER.next();
        LocalDate date = LocalDate.parse(dateInput);

        System.out.println("Введите количество шагов:");
        int steps = SCANNER.nextInt();

        tracker.addSteps(date, steps);
    }

    private static void printMonthlyStatistics() {
        System.out.println("Введите год:");
        int year = SCANNER.nextInt();

        System.out.println("Введите месяц (число от 1 до 12):");
        int month = SCANNER.nextInt();

        MonthlyStats stats = tracker.getMonthlyStats(year, month);
        System.out.println(stats);
    }

    private static void changeDailyGoal() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        int newGoal = SCANNER.nextInt();
        tracker.setDailyGoal(newGoal);
    }

    private static void exitApplication() {
        System.out.println("Спасибо за использование нашего приложения! До свидания.");
        SCANNER.close();
        System.exit(0);
    }
}