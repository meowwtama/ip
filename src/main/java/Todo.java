public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public static void addTask(String description) throws ArrayIndexOutOfBoundsException {
        String[] tokens = description.split(" ");
        String taskName = "";
        if (tokens.length == 1)
            throw new ArrayIndexOutOfBoundsException("The description of a todo cannot be empty.");

        for (int i = 1; i < tokens.length; i++) {
            taskName += tokens[i] + " ";
        }
        Todo curr = new Todo(taskName.strip());
        Duke.taskList.add(curr);
        Database.writeFile(description);
        if (!Duke.initialize) {
            System.out.println("Yer task has been added: \n  " + curr);
            Task.getNumberOfTasks();
        }
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
