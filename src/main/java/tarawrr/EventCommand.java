package tarawrr;

/**
 * EventCommand Class - Represents a command for adding a Event task.
 */
public class EventCommand extends Command {
    private String description;
    private String start;
    private String end;

    //Constructor initiates an instance of EventCommand with description, start date and end date
    public EventCommand(String description, String start, String end) {
        this.description = description;
        this.start = start;
        this.end = end;
        assert end != null : "end of Event task should not be null";
        assert start != null : "start of Event task should not be null";
        assert description != null : "description of Event task should not be null";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        Event event = new Event(description, start, end);
        tasks.addToTaskList(event);
        storage.save(tasks);
        return ui.showTaskAddedMessage(event, tasks.numberOfTasks());
    }
}
