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

}
