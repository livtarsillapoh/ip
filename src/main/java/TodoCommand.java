public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException {
        ToDos todo = new ToDos(this.description);
        tasks.addToTaskList(todo);
        try {
            storage.save(tasks);
        } catch (TarawrrException e) {
            throw new RuntimeException(e);
        }
        ui.showTaskAddedMessage(todo, tasks.numberOfTasks());
    }

}
