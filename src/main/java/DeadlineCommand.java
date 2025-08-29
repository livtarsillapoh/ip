public class DeadlineCommand extends Command{
    private String description;
    private String date;

    public DeadlineCommand(String description, String date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        Deadline deadline = new Deadline(description, date);
        tasks.addToTaskList(deadline);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        ui.showTaskAddedMessage(deadline, tasks.numberOfTasks());
    }
}
