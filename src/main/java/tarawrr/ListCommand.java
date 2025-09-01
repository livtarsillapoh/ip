package tarawrr;

/**
 * ListCommand Class - Represents a command for listing all my tasks
 */
public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }
}