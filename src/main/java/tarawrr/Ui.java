package tarawrr;

/**
 * Ui class deals with interactions with the user
 */
public class Ui {
    public String showWelcomeMessage() {
        return "Hello! I'm TARAWRR, what can I do for you?" +
                "\n" +
                "(Type help for the available list of commands)";
    }

    public String showTaskAddedMessage(Task task, int taskCount) {
        return String.format("Got it. I've added and logged this task:\n\t%s", task.toString()) +
                "\n" +
                String.format("Now you have %s tasks in the list.", taskCount);
    }

    public String showMarkedTask(Task task) {
        return String.format("Nice! I have marked this task as done:\n %s", task.toString());
    }

    public String showUnmarkedTask(Task task) {
        return String.format("OK! I have marked this task as not done yet:\n %s", task.toString());
    }

    public String showDeletedTask(Task task, int taskCount) {
        return String.format("Got it. I've removed this task:\n\t%s", task.toString()) +
                "\n" +
                String.format("Now you have %s tasks in the list.", taskCount);
    }

    public String showTaskList(TaskList tasks) {
        return String.format("Here are the tasks in your list:\n%s", tasks.toString());
    }

    public String showFindTask(TaskList tasks) {
        return String.format("Here are the matching tasks in your list:\n%s", tasks.toString());
    }

    public String showSnoozeMessage(Task task) {
        return String.format("Got it. I've snoozed this task to:\n\t%s", task.toString());
    }

    public String showError(String errorMessage) {
        return errorMessage;
    }

    public String showHelp() {
        return "Here are the available commands:\n" +
                "Note: Dates are to be typed in the format YYYY-MM-DD\n\n" +
                "1. todo <description> - Adds a todo task\n" +
                "2. deadline <description> /by <YYYY-MM-DD> - Adds a deadline task\n" +
                "3. event <description> /from <YYYY-MM-DD> /to <YYYY-MM-DD> - Adds an event task\n" +
                "4. list - Lists all tasks\n" +
                "5. mark <task number> - Marks a task as done\n" +
                "6. unmark <task number> - Marks a task as not done\n" +
                "7. delete <task number> - Deletes a task\n" +
                "8. snooze <task number> /to <YYYY-MM-DD> <YYYY-MM-DD> - Changes the date of a deadline or event task\n" +
                "9. find <keyword> - Finds tasks containing the keyword\n" +
                "10. help - Shows this help message\n" +
                "11. bye - Exits the program\n" +
                "12. clear - Clears all tasks from the list\n\n" +
                "Happy organizing! :)";
    }

    public String showClearMessage() {
        return "All tasks have been cleared. Your list is now empty :)";
    }

    public String showExitMessage() {
        return "Bye. Hope to see you again soon!";
    }

}


