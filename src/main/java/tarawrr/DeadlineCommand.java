package tarawrr;

/**
 * DeadlineCommand Class - Represents a command for adding a deadline task.
 */
public class DeadlineCommand extends Command{
    private final String description;
    private final String date;

    //Constructor initiates an instance of DeadlineCommand with description and date
    public DeadlineCommand(String description, String date) {
        this.description = description;
        assert description != null : "description of Deadline task should not be null";
        this.date = date;
        assert date != null : "deadline of Deadline task should not be null";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        Deadline deadline = new Deadline(description, date);
        tasks.addToTaskList(deadline);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
       return ui.showTaskAddedMessage(deadline, tasks.numberOfTasks());
    }
}
