import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) {
                System.out.print("Введите номер месяца (0 - январь ... 11 - декабрь): ");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.print("Такого месяца не существует, попробуйте снова!: ");
                    continue;
                }
                System.out.print("Введите число месяца (с 1 по 30): ");
                int day = scanner.nextInt();
                if (day < 1 || day > 30) {
                    System.out.print("Такого дня не существует, попробуйте снова!: ");
                    continue;
                }
                System.out.print("Введите число шагов за этот день: ");
                int step = scanner.nextInt();
                if (step < 0) {
                    System.out.print("Введите положительное число!: ");
                    continue;
                } else {
                    stepTracker.selectPushDay(month, day, step);
                }
            } else if (userInput == 2) {
                System.out.print("Введите номер месяца (0 - январь ... 11 - декабрь): ");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.print("Такого месяца не существует, попробуйте снова!: ");
                    continue;
                }
                stepTracker.statusForMonth(month);
            } else if (userInput == 3) {
                System.out.println("Выберите новую цель шагов в день:\n");
                int countStepPerDay = scanner.nextInt();
                if (countStepPerDay < 0) {
                    System.out.println("Цель шагов не может быть отрицательной, попробуйте снова!\n");
                    continue;
                }
                stepTracker.maxStepPerDay(countStepPerDay);
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.\n");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? \n" +
                "1 - Ввести количество шагов за определённый день\n" +
                "2 - Напечатать статистику за определённый месяц\n" +
                "3 - Изменить цель по количеству шагов в день\n" +
                "4 - Выход");
        System.out.print("Введите команду: ");
    }
}