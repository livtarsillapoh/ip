import java.util.ArrayList;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int i) {
        this.index = i;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        tasks.markTask(this.index);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        ui.showMarkedTask(tasks.getTasks().get(this.index - 1));
    }
}
