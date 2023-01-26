package CourseWork2;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private final int id;
    private int idGenerator = 0;
    private final String title;
    private final String description;
    final LocalDate date;
    final DivisionIntoTypes tapeTask;
    final RepeatabilityOfTheTask repeatTask;
    LocalDate nextDate;


    public Task(String title, String description, DivisionIntoTypes tapeTask,
                RepeatabilityOfTheTask repeatTask) {
        id = idGenerator++;
        this.title = title;
        this.description = description;
        date = LocalDate.now();
        this.tapeTask = tapeTask;
        this.repeatTask = repeatTask;
        this.nextDate = nextDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public RepeatabilityOfTheTask getRepeatTask() {
        return repeatTask;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public void setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
    }

    @Override
    public String toString() {
        return "Задача: " + id + ": " + title + ", " + description + ", " + date +
                ", " + tapeTask.getTapeTask() + ", " + repeatTask.getRepeatTask();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(date, task.date) && tapeTask == task.tapeTask && repeatTask == task.repeatTask && Objects.equals(nextDate, task.nextDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, tapeTask, repeatTask, nextDate);
    }

    public LocalDate nextDate() {                                    // Заполнение следующей даты ежедневника
        switch (this.repeatTask) {
            case ONE_TIME_TASK:
                return date;
            case DAILY_TASK:
                return date.plusDays(1);
            case WEEKLY_TASK:
                return date.plusWeeks(1);
            case MONTHLY_TASK:
                return date.plusMonths(1);
            case ANNUAL_TASK:
                return date.plusYears(1);
            default:
                return date;
        }
    }
}
