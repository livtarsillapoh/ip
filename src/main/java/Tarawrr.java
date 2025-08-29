import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/*
public class Tarawrr {

    private static final String DATA_FILE = "data/dataFile.txt";

    private static void addToData(Task t) {
        try {
            writeToFile(DATA_FILE, t.toStorageString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String logo = "TARAWRR";
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<Task> logbook = new ArrayList<>();
        int counter = 0;

        System.out.println("____________________________________________________________");
        System.out.println(String.format("Hello! I'm %s", logo));
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        String input1 = scanner1.nextLine();
        while (!input1.equals("bye")) {
            // Add Todo Task
            if (input1.startsWith("todo")) {
                String inter = Tarawrr.removeFirstWord(input1);
                // Check if the description is not empty
                if (!inter.isEmpty()) {
                    counter++;
                    ToDos todo = new ToDos(inter);
                    logbook.add(todo);
                    Tarawrr.writeToFile(DATA_FILE, todo.toStorageString());
                    System.out.println("____________________________________________________________");
                    System.out.println(String.format("Got it. I've added and logged this task:\n\t%s", todo.toString()));
                    System.out.println(String.format("Now you have %s tasks in the list.", counter));
                    System.out.println("____________________________________________________________");
                } else {
                    // Handle empty description
                    System.out.println("____________________________________________________________");
                    System.out.println("OOPS!!! The description of a todo cannot be empty. " +
                            "Please enter the todo description.");
                    System.out.println("____________________________________________________________");
                }
            }
            // Add Deadline Task
            else if (input1.startsWith("deadline")) {
                String inter = Tarawrr.removeFirstWord(input1);
                String[] arr = inter.split("/", 2);
                // Check if the description and deadline is empty
                String date = arr[1].replace("by", "").trim();
                if (arr.length < 2 || arr[0].trim().isEmpty() || date.isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println("OOPS!!! Invalid deadline format. Please provide a deadline description and date.");
                    System.out.println("____________________________________________________________");
                } else {
                    counter ++;
                    Deadline deadline = new Deadline(arr[0].trim(), Tarawrr.removeFirstWord(arr[1].trim()).trim());
                    logbook.add(deadline);
                    Tarawrr.writeToFile(DATA_FILE, deadline.toStorageString());
                    System.out.println("____________________________________________________________");
                    System.out.println(String.format("Got it. I've added and logged this task:\n\t%s", deadline.toString()));
                    System.out.println(String.format("Now you have %s tasks in the list.", counter));
                    System.out.println("____________________________________________________________");
                }
            }
            // Add Event Task
            else if (input1.startsWith("event")) {
                String inter = Tarawrr.removeFirstWord(input1);
                String[] arr = inter.split("/", 3);
                // Check if the description and start and end time is empty
                if (arr.length < 3 || arr[0].isEmpty() || arr[1].isEmpty() || arr[2].isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println("OOPS!!! Invalid event format. Please provide an event description, and start and end times.");
                    System.out.println("____________________________________________________________");
                } else {
                    counter ++;
                    Event event = new Event(arr[0].trim(), Tarawrr.removeFirstWord(arr[1].trim()).trim(),
                            Tarawrr.removeFirstWord(arr[2].trim()).trim());
                    logbook.add(event);
                    Tarawrr.writeToFile(DATA_FILE, event.toStorageString());
                    System.out.println("____________________________________________________________");
                    System.out.println(String.format("Got it. I've added and logged this task:\n\t%s", event.toString()));
                    System.out.println(String.format("Now you have %s tasks in the list.", counter));
                    System.out.println("____________________________________________________________");
                }
            }

            // Handle "mark" and "unmark" tasks
            else if (input1.startsWith("mark")) {
                try {
                    int i = Integer.parseInt(input1.split(" ")[1]) - 1;
                    logbook.get(i).complete();
                    System.out.println("____________________________________________________________");
                    System.out.println(String.format("Nice! I have marked this task as done:\n %s", logbook.get(i).toString()));
                    System.out.println("____________________________________________________________");
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println("OOPS!!! Invalid task number or task doesn't exist.");
                    System.out.println("____________________________________________________________");
                }

            } else if (input1.startsWith("unmark")) {
                try {
                    int i = Integer.parseInt(input1.split(" ")[1]) - 1;
                    logbook.get(i).uncomplete();
                    System.out.println("____________________________________________________________");
                    System.out.println(String.format("OK! I have marked this task as not done yet:\n %s", logbook.get(i).toString()));
                    System.out.println("____________________________________________________________");
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println("OOPS!!! Invalid task number or task doesn't exist.");
                    System.out.println("____________________________________________________________");
                }

            } else if (input1.startsWith("delete")) {
                String[] arr = input1.split(" ", 2);
                int number = Integer.parseInt(arr[1]) - 1; // account zero indexing
                Task t = logbook.get(number);
                logbook.remove(number);
                counter --;
                System.out.println("____________________________________________________________");
                System.out.println(String.format("Got it. I've removed this task: \n\t%s", t.toString()));
                System.out.println(String.format("Now you have %s tasks in the list.", counter));
                System.out.println("____________________________________________________________");

            } else if (input1.equals("list")) {
                // List all tasks
                String logbookString = Tarawrr.logbookToString(logbook);
                System.out.println("____________________________________________________________\n"
                        + "Here are the tasks in your list:\n"
                        + logbookString
                        + "____________________________________________________________");
            }
            // Handle unknown commands
            else {
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("____________________________________________________________");
            }

            // Continue to read the next input
            input1 = scanner1.nextLine();
        }

        // Exit message
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");

        scanner1.close();
    }
}
*/

//Final class should look like this
public class Tarawrr {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Tarawrr(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (TarawrrException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        //...
    }

    public static void main(String[] args) {
        new Tarawrr("data/dataFile.txt").run();
    }
}





