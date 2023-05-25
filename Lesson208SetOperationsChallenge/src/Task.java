enum Priority {LOW, MEDIUM, HIGH}
enum Status {QUEUE, ASSIGNED, IN_PROGRESS, DONE}

public class Task implements Comparable<Task>{
    private String assignee;
    private String project;
    private String description;
    private Status status;
    private String priority;

    public Task(String project, String description, String priority, Status status, String assignee) {
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
    }

    public Task(String project, String description, String priority, String assignee) {
        this(project, description, priority,
                assignee.equals("unassigned") ? Status.QUEUE : Status.ASSIGNED,
                assignee);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!project.equals(task.project)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = project.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        // return  project + "\t" + description + "\t" + priority + "\t" + status + "\t" + assignee;
        return"%-20s %-30s %-10s %-15s %-10s".formatted(project, description, priority, status, assignee);
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Object getAssignee() {
        return assignee;
    }

    @Override
    public int compareTo(Task o) {
        int result = this.project.compareTo(o.project);
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }
        return result;
    }
}
