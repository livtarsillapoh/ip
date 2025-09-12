package tarawrr;

/**
 * Ui class deals with interactions with the user
 */
public class Ui {
    public static final String HORIZONTAL_LINE = "____________________________________________________________";

    public String showWelcomeMessage() {
        return HORIZONTAL_LINE +
                "\n" +
                "Hello! I'm TARAWRR, what can I do for you?" +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showTaskAddedMessage(Task task, int taskCount) {
        return HORIZONTAL_LINE +
                "\n" +
                String.format("Got it. I've added and logged this task:\n\t%s", task.toString()) +
                "\n" +
                String.format("Now you have %s tasks in the list.", taskCount) +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showMarkedTask(Task task) {
        return HORIZONTAL_LINE +
                "\n" +
                String.format("Nice! I have marked this task as done:\n %s", task.toString()) +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showUnmarkedTask(Task task) {
        return HORIZONTAL_LINE +
                "\n" +
                String.format("OK! I have marked this task as not done yet:\n %s", task.toString()) +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showDeletedTask(Task task, int taskCount) {
        return HORIZONTAL_LINE +
                "\n" +
                String.format("Got it. I've removed this task:\n\t%s", task.toString()) +
                "\n" +
                String.format("Now you have %s tasks in the list.", taskCount) +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showTaskList(TaskList tasks) {
        return HORIZONTAL_LINE +
                "\n" +
                String.format("Here are the tasks in your list:\n%s", tasks.toString()) + "\n" +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showFindTask(TaskList tasks) {
        return HORIZONTAL_LINE +
                "\n" +
                String.format("Here are the matching tasks in your list:\n%s", tasks.toString()) + "\n" +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showError(String errorMessage) {
        return HORIZONTAL_LINE +
                "\n" +
                errorMessage +
                "\n" +
                HORIZONTAL_LINE;
    }

    public String showExitMessage() {
        return HORIZONTAL_LINE +
                "\n" +
                "Bye. Hope to see you again soon!" +
                "\n" +
                HORIZONTAL_LINE;
    }

}


