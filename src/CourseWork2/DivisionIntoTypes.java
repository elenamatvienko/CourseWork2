package CourseWork2;


public enum DivisionIntoTypes {
    PERSONAL_TASK("Личная задача"),
    WORK_TASK("Рабочая задача");

    final String tapeTask;

    DivisionIntoTypes(String tapeTask) {
        this.tapeTask = tapeTask;

    }

    public String getTapeTask() {
        return tapeTask;
    }
}

