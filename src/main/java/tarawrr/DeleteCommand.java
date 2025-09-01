package tarawrr;
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int i) {
        this.index = i;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTasks().get(this.index - 1);
        tasks.removeFromTaskList(this.index);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        ui.showDeletedTask(task, tasks.numberOfTasks());
    }
}
