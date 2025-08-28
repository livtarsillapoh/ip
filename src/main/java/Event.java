public class Event extends Task {
    private String start;
    private String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E] " +
                super.toString() +
                " (" + this.start.replaceAll("from", "from:") +
                this.end.replaceAll("to", "to:") + ")";
    }

    @Override
    public String toStorageString() {
        return String.format("E | %d | %s | %s", super.isDone() ? 1 : 0, super.getDescription(),
                this.start + " to " + this.end);
    }

}
