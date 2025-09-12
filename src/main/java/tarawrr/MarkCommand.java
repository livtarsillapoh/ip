package tarawrr;

/**
 * MarkCommand Class - Represents a command for marking a task as complete.
 */
public class MarkCommand extends Command {
    private final int index;

    //Constructor initiates an instance of MarkCommand with index to be marked
    public MarkCommand(int index) {
        this.index = index;
        assert index > 0 : "index of task to be marked should be greater than 0";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        tasks.markTask(this.index);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        return ui.showMarkedTask(tasks.getTasks().get(this.index - 1));
    }
}
