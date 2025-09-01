package tarawrr;

/**
 * Command Class - Abstract class that represents a generic command.
 */
public abstract class Command {
    /**
     * Executes the command. May mutate tasks, should print via Ui and store to datafile.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TarawrrException;

    public boolean isExit() {
        return false;
    }
}

