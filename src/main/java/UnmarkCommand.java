public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int i) {
        this.index = i;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        tasks.unmarkTask(this.index);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        ui.showUnmarkedTask(tasks.getTasks().get(this.index - 1));

    }
}
