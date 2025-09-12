package tarawrr;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
        assert keyword != null : "keyword to find should not be null";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> taskList = tasks.getTasks();
        TaskList list = new TaskList();

        // iterate through all tasks and add tasks containing keyword to list
        for (Task t : taskList) {
            String description = t.getDescription();
            if (description.contains(keyword)) {
                list.addToTaskList(t);
            }
        }

        // if list is be empty, show error message
        if (list.numberOfTasks() ==0) {
            ui.showError("No matching tasks found :(");
        }

        return ui.showFindTask(list);
    }
}
