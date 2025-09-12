package tarawrr;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class
 */
public class Tarawrr {

    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    public Tarawrr(String filePath) throws IOException {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tasks = this.storage.load();
    }

    public Ui getUi() {
        return this.ui;
    }

    public void run() {

        assert tasks != null: "Tasklist should not be null";
        assert ui != null: "Ui returned should not be null";
        assert storage != null: "Storage returned should not be null";

        System.out.println(ui.showWelcomeMessage());
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                break;
            }
            try {
                Command command = Parser.parseTask(input);
                System.out.println(command.execute(tasks, ui, storage));
            } catch (TarawrrException e) {
                System.out.println(ui.showError(e.toString()));
            }
        }

        System.out.println(ui.showExitMessage());
        scanner.close();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        if (input.equals("bye")) {
            return ui.showExitMessage();
        }

        try {
            Command command = Parser.parseTask(input);
            assert command != null : "Command returned should not be null after parsing";
            return command.execute(tasks, ui, storage);
        } catch (TarawrrException e) {
            return ui.showError(e.toString());
        }
    }


    public static void main(String[] args) throws IOException {
        new Tarawrr("data/dataFile.txt").run();
    }
}





