public class StepTracker {
    private int maxStepPerDay = 10000;
    private int[][] tableDays = new int[30][11];

    void selectPushDay(int month, int day, int step){
        tableDays[day - 1][month - 1] = step;
    }

    /**
     * statusForMonth() выводит статистику по выбранному месяцу
     */
    void statusForMonth(int month){
        int count = 0;
        int maxStep = 0;

        Converter converter = new Converter();

        System.out.println("Вы выбрали " + month + "-й месяц!");

        //Количество пройденных шагов по дням
        for (int i = 0; i < 30; i++) {
            if (i < 29){
                System.out.print((i+1) + " день: " + tableDays[i][month-1] + ", ");
            } else {
                System.out.println((i+1) + " день: " + tableDays[i][month-1]);
            }

        }

        //Общее количество шагов за месяц
        for (int i = 0; i<30; i++){
            count += tableDays[i][month-1];
        }
        System.out.println("Общее количество шагов: " + count);

        //Максимальное пройденное количество шагов в месяце
        for (int i = 0; i<30; i++){
            if (tableDays[i][month-1] > maxStep) {
                maxStep = tableDays[i][month-1];
            }
        }
        System.out.println("Максимальное пройденное количество шагов: " + maxStep);

        //Среднее количество шагов
        System.out.println("Среднее число шагов: " + count/30);

        //Пройденная дистанция (в км)
        System.out.println("Общая пройденная дистанция: " + converter.stepToDistance(count) + " км");

        //Количество сожженных килокалорий
        System.out.println("Количество сожженных килокалорий: " + converter.stepToCalorie(count) + " ККал");

        //Лучшая серия
        System.out.println("Лучшая серия шагов: " + bestSeriesSteps(month));
    }

    /**
     * bestSeriesSteps() - вычисляет наибольшее количество подряд идущих дней, при условии,
     * что каждый из этих дней совпадает или превосходит по количеству
     * шагов дневную цель maxStepPerDay.
     */
    int bestSeriesSteps(int month){
        int seriesBuf = 0;
        int series = 0;
        for (int i=0; i < 30; i++){
            if (tableDays[i][month-1] >= maxStepPerDay){
                seriesBuf++;
            } else {
                if (series < seriesBuf) {
                    series = seriesBuf;
                    seriesBuf = 0;
                }
            }
        }
        if (series < seriesBuf) {
            series = seriesBuf;
        }
        return series;
    }

    /**
     * Новая дневная цель шагов
     */
    void maxStepPerDay(int countStepPerDay){
        maxStepPerDay = countStepPerDay;
    }
}



