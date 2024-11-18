import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StepTracker {
    private final TreeMap<LocalDate, Integer> stepsByDay = new TreeMap<>();
    private int dailyGoal;

    public void setDailyGoal(int goal) {
        if (goal > 0) {
            this.dailyGoal = goal;
        } else {
            throw new IllegalArgumentException("Цель должна быть положительной");
        }
    }

    public int getDailyGoal() {
        return dailyGoal;
    }

    public void addSteps(LocalDate date, int steps) {
        stepsByDay.merge(date, steps, Integer::sum);
    }

    public MonthlyStats getMonthlyStats(int year, int month) {
        List<LocalDate> datesInMonth = getDatesInMonth(year, month);
        int totalSteps = 0;
        int bestStreak = 0;
        int currentStreak = 0;

        for (LocalDate date : datesInMonth) {
            int steps = stepsByDay.getOrDefault(date, 0);
            totalSteps += steps;

            if (steps >= dailyGoal) {
                currentStreak++;
                if (currentStreak > bestStreak) {
                    bestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        double averageSteps = (double) totalSteps / datesInMonth.size();
        double distanceInKm = Converter.stepsToKilometers(totalSteps);
        double caloriesBurned = Converter.caloriesBurned(totalSteps);

        return new MonthlyStats(
                totalSteps,
                averageSteps,
                bestStreak,
                distanceInKm,
                caloriesBurned
        );
    }

    private List<LocalDate> getDatesInMonth(int year, int month) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDate lastDay = firstDay.withDayOfMonth(firstDay.lengthOfMonth());

        List<LocalDate> result = new ArrayList<>();
        for (LocalDate date = firstDay; !date.isAfter(lastDay); date = date.plusDays(1)) {
            result.add(date);
        }

        return result;
    }
}