package tarawrr;

/**
 * TodoCommand Class - Represents a command for adding a todos task
 */
public class TodoCommand extends Command {
    private String description;

    //Constructor initialises an instance of TodoCommand given description
    public TodoCommand(String description) {
        this.description = description;
        assert description != null : "description of Todo task should not be null";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        Todo todo = new Todo(this.description);
        tasks.addToTaskList(todo);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        return ui.showTaskAddedMessage(todo, tasks.numberOfTasks());
    }

}
