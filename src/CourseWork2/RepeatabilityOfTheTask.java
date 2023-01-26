package CourseWork2;

public enum RepeatabilityOfTheTask {
    ONE_TIME_TASK("Однократная"),
    DAILY_TASK("Ежедневная"),
    WEEKLY_TASK("еженедельная"),
    MONTHLY_TASK("ежемесячная"),
    ANNUAL_TASK("ежегодная");

    final String repeatTask;

    RepeatabilityOfTheTask(String repeatTask) {
        this.repeatTask = repeatTask;
    }

    public String getRepeatTask() {
        return repeatTask;
    }

}
