import java.util.ArrayList;
import java.util.Scanner;

public class Tarawrr {

    // Skip first word and space in a string
    public static String removeFirstWord(String string) {
        int i = string.indexOf(" ");
        String result = string.substring(i + 1);
        return result;
    }

    public static void main(String[] args) {
        String logo = "TARAWRR";
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("____________________________________________________________");
        System.out.println(String.format("Hello! I'm %s", logo));
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
        String input1 = scanner1.nextLine();
        ArrayList<Task> logbook = new ArrayList<>();
        int counter = 0;

        // when user inputs a task
        while(!input1.equals("bye")) {

            if (!input1.startsWith("mark") && !input1.startsWith("unmark") && !input1.equals("list")) {


                if (input1.startsWith("todo")) {
                    counter++;
                    String inter = Tarawrr.removeFirstWord(input1);
                    ToDos todo = new ToDos(inter);  // No need to split for todo tasks
                    logbook.add(todo);
                    System.out.println("____________________________________________________________");
                    System.out.println(String.format("Got it. I've added this task: \n\t%s",
                            todo.toString()));
                    System.out.println(String.format("Now you have %s tasks in the list.", counter));
                    System.out.println("____________________________________________________________");

                } else if (input1.startsWith("deadline")) {
                    counter++;
                    String inter = Tarawrr.removeFirstWord(input1);
                    String[] arr = inter.split("/");
                    if (arr.length < 2) {
                        System.out.println("Invalid deadline format. Please provide a deadline description and date.");
                    } else {
                        Deadline deadline = new Deadline(arr[0], arr[1]);
                        logbook.add(deadline);
                        System.out.println("____________________________________________________________");
                        System.out.println(String.format("Got it. I've added this task: \n\t%s",
                                deadline.toString()));
                        System.out.println(String.format("Now you have %s tasks in the list.", counter));
                        System.out.println("____________________________________________________________");
                    }

                } else if (input1.startsWith("event")) {
                    counter++;
                    String inter = Tarawrr.removeFirstWord(input1);
                    String[] arr = inter.split("/");
                    if (arr.length < 3) {
                        System.out.println("Invalid event format. Please provide event description, date, and time.");
                    } else {
                        Event event = new Event(arr[0], arr[1], arr[2]);
                        logbook.add(event);
                        System.out.println("____________________________________________________________");
                        System.out.println(String.format("Got it. I've added this task: \n\t%s",
                                event.toString()));
                        System.out.println(String.format("Now you have %s tasks in the list.", counter));
                        System.out.println("____________________________________________________________");
                    }
                }



            } else if (input1.startsWith("mark")) {
                // mark case
                int i = Integer.parseInt(input1.split(" ")[1]) - 1;
                logbook.get(i).complete();
                System.out.println("____________________________________________________________");
                System.out.println(String.format("Nice! I have marked this task as done:\n %s", logbook.get(i).toString()));
                System.out.println("____________________________________________________________");

            } else if (input1.startsWith("unmark")) {
                // unmark case
                int i = Integer.parseInt(input1.split(" ")[1]) - 1;
                logbook.get(i).uncomplete();
                System.out.println("____________________________________________________________");
                System.out.println(String.format("OK! I have marked this task as not done yet:\n %s", logbook.get(i).toString()));
                System.out.println("____________________________________________________________");

            } else if (input1.equals("list")) {
                // list tasks
                String logbookString = "";
                for (int i = 0; i < logbook.size(); i++) {
                    logbookString += Integer.toString(i + 1) + ". " + logbook.get(i).toString() + "\n";
                }

                System.out.println("____________________________________________________________\n"
                        + "Here are the tasks in your list:\n"
                        + logbookString
                        + "____________________________________________________________");
            }

            // Continue to read the next input
            input1 = scanner1.nextLine();
        }

        // Bye message
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");

        scanner1.close();
    }
}


