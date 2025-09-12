package tarawrr;

/**
 * DeleteCommand Class - Represents a command for adding a deleting task.
 */
public class DeleteCommand extends Command {
    private int index;

    //Constructor initiates an instance of DeleteCommand with index to be deleted
    public DeleteCommand(int i) {
        this.index = i;
        assert i > 0 : "index of task to be deleted should be greater than 0";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTasks().get(this.index - 1);
        tasks.removeFromTaskList(this.index);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            ui.showError(e.getMessage());
        }
        return ui.showDeletedTask(task, tasks.numberOfTasks());
    }
}
