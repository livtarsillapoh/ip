import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {
    String type;
    String description;
    Boolean isDone;
    String deadline;
    String startTime, endTime;


    public Parser(String input) {
        if (input != null || !input.isEmpty()) {
            String[] list = input.split(" ", 4);
            this.type = list[0].trim();
            switch(this.type) {
            case "todo":
                this.description = list[1].trim();
            case "deadline":
                this.description = list[1].trim();
                String deadlineString = list[3].trim();
                this.deadline = LocalDate.parse(deadlineString).format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
            case "event":
                this.description = list[1].trim();
                String startString = list[3].trim();
                this.startTime = LocalDate.parse(startString).format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
                String endString = list[5].trim();
                this.endTime = LocalDate.parse(endString).format(DateTimeFormatter.ofPattern("MMM dd yyyy"));

            }
        }
    }


    public static Command parseTask(String input) throws TarawrrException {
        String taskType = input.split(" ")[0].toLowerCase().trim();
        String description = input.substring(taskType.length()).trim();

        switch (taskType) {
        case "todo":
            return new TodoCommand(description);

        case "deadline":
            String[] deadlineParts = description.split(" /by ");
            return new DeadlineCommand(deadlineParts[0].trim(), deadlineParts[1].trim());

        case "event":
            String[] eventParts = description.split(" /from | /to ");
            return new EventCommand(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());

        case "delete":
            int deleteNumber = Integer.parseInt(input.split(" ")[1]);
            return new DeleteCommand(deleteNumber);

        case "list":
            return new ListCommand();

        case "mark":
            int markNumber = Integer.parseInt(input.split(" ")[1]);
            return new MarkCommand(markNumber);

        case "unmark":
            int unmarkNumber = Integer.parseInt(input.split(" ")[1]);
            return new UnmarkCommand(unmarkNumber);

        default:
        throw new TarawrrException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
