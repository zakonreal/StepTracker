import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatisticsForMonth();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Ввести количество шагов за определенный день.");
        System.out.println("2. Изменить цель по количеству шагов в день.");
        System.out.println("3. Напечатать статистику за определенный месяц.");
        System.out.println("4. Выйти из приложения.");
        System.out.print("Ваш выбор: ");
    }
}