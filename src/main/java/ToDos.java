public class ToDos extends Task {
    // no new fields
    public ToDos(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}
