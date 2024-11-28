import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = getValidInt(scanner);

        while (userInput != 4) {

            if (userInput == 1) {
                System.out.print("Введите номер месяца (0 - январь ... 11 - декабрь): ");
                int month = getValidInt(scanner);
                if (month < 0 || month > 11) {
                    System.err.print("Такого месяца не существует, попробуйте снова!: ");
                    continue;
                }
                System.out.print("Введите число месяца (с 1 по 30): ");
                int day = getValidInt(scanner);
                if (day < 1 || day > 30) {
                    System.err.print("Такого дня не существует, попробуйте снова!: ");
                    continue;
                }
                System.out.print("Введите число шагов за этот день: ");
                int step = getValidInt(scanner);
                if (step < 0) {
                    System.err.print("Введите положительное число!: ");
                    continue;
                } else {
                    stepTracker.selectPushDay(month, day, step);
                }
            } else if (userInput == 2) {
                System.out.print("Введите номер месяца (0 - январь ... 11 - декабрь): ");
                int month = getValidInt(scanner);
                if (month < 0 || month > 11) {
                    System.err.print("Такого месяца не существует, попробуйте снова!: ");
                    continue;
                }
                stepTracker.statusForMonth(month);
            } else if (userInput == 3) {
                System.out.print("Выберите новую цель шагов в день: ");
                int countStepPerDay = getValidInt(scanner);
                if (countStepPerDay < 0) {
                    System.err.print("Цель шагов не может быть отрицательной, попробуйте снова!");
                    continue;
                }
                stepTracker.maxStepPerDay(countStepPerDay);
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.err.println("Извините, такой команды пока нет.\n");
            }

            printMenu();
            userInput = getValidInt(scanner);
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

    public static int getValidInt(Scanner scanner) {
        boolean validInput = false;
        int userInput = -1;

        while (!validInput) {
            try {
                userInput = scanner.nextInt(); // Попытка прочитать целое число
                validInput = true; // Вход корректный, выход из цикла
            } catch (InputMismatchException e) {
                System.err.println("Неверный ввод. Пожалуйста, введите целое число.");
                scanner.nextLine(); // Очистка буфера
            }
        }
        return userInput;
    }
}