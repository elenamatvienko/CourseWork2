import CourseWork2.DivisionIntoTypes;
import CourseWork2.RepeatabilityOfTheTask;
import CourseWork2.Task;
import CourseWork2.TaskService;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static TaskService taskService = new TaskService();

    public static void main(String[] args) throws IOException, ParseException {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1: // Добавление задачи
                            inputTask(scanner);
                            break;
                        case 2: // Удаление задачи по ID
                            System.out.print("Введите ID задачи для удаления ");
                            int delete = scanner.nextInt();
                            if (taskService.deleteTask(delete)) {
                                System.out.println("\nЗадача с заданным ID - удалена успешно!\n");
                            } else {
                                System.out.println("\n!  Не удается удалить задачу т.к. она не существует\n");
                            }
                            break;
                        case 3: // Получение задачи на указанный день
                            System.out.print("Введите дату для поиска задачи в формате yyyy-mm-dd - ");
                            String dateInputStr = scanner.next();
                            if (!isValidDate(dateInputStr)) {
                                LocalDate dateInput = LocalDate.parse(dateInputStr);
                                taskService.receivingTask(dateInput);
                            } else {
                                System.out.print("Введена дата не по формату!");
                            }
                            break;
                        case 4: // Вывод всех задач в консоль
                            taskService.printAllTasks();
                            break;
                        case 0:
                        default:
                            throw new IllegalStateException("Unexpected value: " + menu);
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите заголовок задачи: ");
        String titleName = scanner.next();
        System.out.print("Введите тип задачи:\nРабочая\nЛичная");
        String tapeName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String descriptionName = scanner.next();

        int repeatability;
        do {
            System.out.print("Введите повторяемость задачи: 1/однократная,2/ежедневная,3/еженедельная,4/ежемесячная,5/ежегодная ");
            repeatability = scanner.nextInt();
        } while (!(repeatability > 0 && repeatability < 6));

        switch (repeatability) {
            case 1:
                Task task1 = new Task(titleName, tapeName, DivisionIntoTypes.PERSONAL_TASK,
                        RepeatabilityOfTheTask.ONE_TIME_TASK);
                taskService.addList(task1.getId(), task1);
                break;
            case 2:
                Task task2 = new Task(titleName, tapeName, DivisionIntoTypes.PERSONAL_TASK,
                        RepeatabilityOfTheTask.DAILY_TASK);
                taskService.addList(task2.getId(), task2);
                break;
            case 3:
                Task task3 = new Task(titleName, tapeName, DivisionIntoTypes.PERSONAL_TASK,
                        RepeatabilityOfTheTask.WEEKLY_TASK);
                taskService.addList(task3.getId(), task3);
                break;
            case 4:
                Task task4 = new Task(titleName, tapeName, DivisionIntoTypes.PERSONAL_TASK,
                        RepeatabilityOfTheTask.MONTHLY_TASK);
                taskService.addList(task4.getId(), task4);
                break;
            case 5:
                Task task5 = new Task(titleName, tapeName, DivisionIntoTypes.PERSONAL_TASK,
                        RepeatabilityOfTheTask.ANNUAL_TASK);
                taskService.addList(task5.getId(), task5);
                break;
                default:
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу \n" +
                        "2. Удалить задачу \n" +
                        "3. Получить задачу на указанный день \n" +
                        "4. Получить все задачи \n" +
                        "0. Выход \n");
    }

    public static boolean isValidDate(String dateStr) {   // Проверка введенной даты на правильность формата
        if (!dateStr.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])")) {
            return true;
        } else {
            return false;
        }
    }
}
