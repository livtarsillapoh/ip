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

}
