import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class TaskDataBKP {
    Set<Task> allTasks = new HashSet<>();

    /* a method that reads tasks from a SetsOperationsData.csv file in this package
        - takes a String parameter called assignee which can be either "Ann", "Bob", "Carol" or "All"
        - if assignee is "All" read tasks beginnig on line after "All Tasks" and ending on line before the next blank line
        - if assignee is "Ann", "Bob" or "Carol" read tasks beginning on line after "Ann Tasks", "Bob Tasks" or "Carol Tasks" respectively and ending on line before the next blank line

     */
    public Set<Task> getTaskByAssignee(String assignee) {
        Set<Task> tasks = new HashSet<>();
        if (assignee.equals("All")) {
            tasks = allTasks;
        } else {
            for (Task task : allTasks) {
                if (task.getAssignee().equals(assignee)) {
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }

    public void loadAllTasksFromFile() {
        String line;
        String assignee = "unassigned";
        boolean isReadingAssigneesTasks = false;
        Set<Task> tasks = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(".\\src\\SetsOperationsData.csv"))) {
            while ((line = br.readLine()) != null) {
                assignee = switch (line) {
                    case "Ann's Tasks" -> "Ann";
                    case "Bob's Tasks" -> "Bob";
                    case "Carol's Tasks" -> "Carol";
                    default -> assignee;
                };

                if (!line.equals("Carol's Tasks") && !line.equals("Ann's Tasks") && !line.equals("Bob's Tasks") && !line.equals("All Tasks") && !line.isBlank()) {

                    Task task = getTaskFromLine(assignee, line);
                    if (!tasks.contains(task)) {
                        tasks.add(task);
                    } else {
                        System.out.println("Current assignee: " + assignee);
                        System.out.println("Task already exists");
                        System.out.println(task);
                        if (!task.getAssignee().equals("unassigned")) {
                            System.out.println("Assignee: " + task.getAssignee());
                            tasks.remove(task);
                            tasks.add(task);

                        }
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        allTasks = tasks;
    }

    private static Task getTaskFromLine(String assignee, String line) {
        String[] lineArray;
        System.out.println(line);
        lineArray = line.split(",");
        String project = lineArray[0].trim();
        String description = lineArray[1].trim();
        String priority = lineArray[2].trim();

        return new Task(project, description, priority, assignee);
    }


}
