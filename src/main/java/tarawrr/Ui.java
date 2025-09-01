package tarawrr;
public class Ui {
    public static final String HORIZONTAL_LINE = "____________________________________________________________";

    public void showWelcomeMessage() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Hello! I'm TARAWRR");
        System.out.println("What can I do for you?");
        System.out.println(HORIZONTAL_LINE);
    }

    public void showTaskAddedMessage(Task task, int taskCount) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(String.format("Got it. I've added and logged this task:\n\t%s", task.toString()));
        System.out.println(String.format("Now you have %s tasks in the list.", taskCount));
        System.out.println(HORIZONTAL_LINE);
    }

    public void showMarkedTask(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println(String.format("Nice! I have marked this task as done:\n %s", task.toString()));
        System.out.println("____________________________________________________________");
    }

    public void showUnmarkedTask(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println(String.format("OK! I have marked this task as not done yet:\n %s", task.toString()));
        System.out.println("____________________________________________________________");
    }

    public void showDeletedTask(Task task, int taskCount) {
        System.out.println("____________________________________________________________");
        System.out.println(String.format("Got it. I've removed this task: \n\t%s", task.toString()));
        System.out.println(String.format("Now you have %s tasks in the list.", taskCount));
        System.out.println("____________________________________________________________");
    }

    public void showTaskList(TaskList tasks) {
        // List all tasks
        System.out.println("____________________________________________________________\n"
                + "Here are the tasks in your list:\n"
                + tasks.toString()
                + "____________________________________________________________");
    }

    public void showError(String errorMessage) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(errorMessage);
        System.out.println(HORIZONTAL_LINE);
    }

    public void showExitMessage() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(HORIZONTAL_LINE);
    }
}


