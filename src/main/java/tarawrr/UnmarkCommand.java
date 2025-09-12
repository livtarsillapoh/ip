package tarawrr;

/**
 * UnmarkCommand Class - Represents a command for marking a task as incomplete.
 */
public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
        assert index > 0 : "index of task to be unmarked should be greater than 0";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.unmarkTask(this.index);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            ui.showError(e.getMessage());
        }
        return ui.showUnmarkedTask(tasks.getTasks().get(this.index - 1));
    }
}
