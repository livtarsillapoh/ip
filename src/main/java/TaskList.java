import java.util.ArrayList;

/**
 * TaskList contains the task list and has operations to add/delete tasks in the list
 */
public class TaskList {
    private ArrayList<Task> taskList;
    private int counter = 0;

    /**
     * Constructor initialises an empty TaskList
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Constructor initialises a TaskList given an ArrayList of Tasks
     */
    public TaskList(ArrayList<Task> list) {
        this.taskList = list;
        this.counter = list.size();
    }

    /**
     * Returns the number of Tasks in TaskList
     */
    public int numberOfTasks() {
        return this.counter;
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public void markTask(int i) {
       this.taskList.get(i - 1).complete();
    }

    public void unmarkTask(int i) {
        this.taskList.get(i - 1).uncomplete();
    }

    /**
     * Adds a Task to TaskList
     */
    public void addToTaskList(Task task) {
        this.taskList.add(task);
        counter++;
    }

    /**
     * Removes a Task from TaskList given its position
     */
    public void removeFromTaskList(int taskNumber) {
        int taskIndex = taskNumber - 1;
        this.taskList.remove(taskIndex);
        counter--;
    }

    @Override
    public String toString() {
        String logbookString = "";
        for (int i = 0; i < this.numberOfTasks(); i++) {
            logbookString += Integer.toString(i + 1) + ". " + this.taskList.get(i).toString() + "\n";
        }
        return logbookString;
    }
}




