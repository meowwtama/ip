package anita;

/**
 * An abstract class to be inherited by other tasks.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * The constructor for the Task class.
     *
     * @param description The raw user input.
     */
    public Task(String description, String status) {
        assert description != null : "Description should not be null";
        this.description = description;
        this.isDone = Boolean.parseBoolean(status);
    }

    /**
     * Checks if the task is completed and returns an icon representing the state.
     *
     * @return 'X' if task is completed else " ".
     */
    private String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }
}
