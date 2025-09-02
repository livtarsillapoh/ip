package tarawrr;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        ArrayList<Task> taskList = tasks.getTasks();
        TaskList list = new TaskList();
        for (Task t : taskList) {
            String description = t.getDescription();
            if (description.contains(keyword)) {
                list.addToTaskList(t);
            }
        }
        ui.showFindTask(list);
    }
}
