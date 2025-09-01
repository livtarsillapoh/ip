package tarawrr;
public class EventCommand extends Command {
    private String description;
    private String start;
    private String end;

    public EventCommand(String description, String start, String end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        Event event = new Event(description, start, end);
        tasks.addToTaskList(event);
        storage.save(tasks);
        ui.showTaskAddedMessage(event, tasks.numberOfTasks());
    }
}
