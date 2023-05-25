import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private static String tasks = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            """;

    private static String annsTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
            """;

    private static String bobsTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
            """;

    private static String carolsTasks = """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
            """;

    public static Set<Task> getTasks(String assignee) {
        Set<Task> taskList = new HashSet<>();
        String taskOwner = ("ann,bob, carol".contains(assignee.toLowerCase())) ? assignee : "all";

        String selectedList = switch (taskOwner.toLowerCase()) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            default -> tasks;
        };

        for (String task : selectedList.split("\n")) {
            String[] taskData = task.split(",");

            Status status;
            if (taskData.length == 4){
                if (taskData[3].trim().equalsIgnoreCase("In Progress")){
                    status = Status.IN_PROGRESS;
                } else if (taskData[3].trim().equalsIgnoreCase("Done")){
                    status = Status.DONE;
                } else {
                    status = Status.QUEUE;
                }
            } else {
              status = Status.QUEUE;
            }

            taskList.add(new Task(
                    taskData[0].trim(),
                    taskData[1].trim(),
                    taskData[2].trim(),
                    status,
                    assignee));
        }

        return taskList;
    }


}
