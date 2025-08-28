public class Deadline extends Task {
    private String deadline;
    public Deadline(String name, String date) {
        super(name);
        this.deadline = date;
    }

    @Override
    public String toString() {
        return "[D] " +
                super.toString() +
                " (" + this.deadline.replaceAll("by", "by:") + ")";
    }

    @Override
    public String toStorageString() {
        return String.format("D | %d | %s | %s", super.isDone() ? 1 : 0, super.getDescription(), this.deadline);
    }

}
