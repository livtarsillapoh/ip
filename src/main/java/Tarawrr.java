import java.io.IOException;
import java.util.Scanner;

public class Tarawrr {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Tarawrr(String filePath) throws IOException {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tasks = this.storage.load();
    }

    public void run() throws TarawrrException {
        Scanner scanner = new Scanner(System.in);
        ui.showWelcomeMessage();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                break;
            }
            Command command = Parser.parseTask(input);
            command.execute(tasks, ui, storage);
        }

        ui.showExitMessage(); // Show farewell message when "bye" is typed
        scanner.close();
    }


    public static void main(String[] args) throws IOException, TarawrrException {
        new Tarawrr("data/dataFile.txt").run();
    }
}





