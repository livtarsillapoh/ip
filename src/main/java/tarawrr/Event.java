package tarawrr;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate start;
    private LocalDate end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = LocalDate.parse(start);
        this.end = LocalDate.parse(end);
    }

    @Override
    public String toString() {
        String startDate = this.start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        String endDate = this.end.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return "[E] " +
                super.toString() +
                " (from: " +
                startDate +
                " to: " +
                endDate +
                ")";
    }

    @Override
    public String toStorageString() {
        String startDate = this.start.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        String endDate = this.end.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return String.format("E | %d | %s | %s", super.isDone() ? 1 : 0, super.getDescription(),
                startDate + " to " + endDate);
    }

}
