import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(System.getProperty("user.dir"));

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> byPriority = Comparator.comparing(Task::getPriority);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, byPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's Tasks", bobsTasks, byPriority);

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol's Tasks", carolsTasks, byPriority);

        /*
        CHALLENGE:
        1.  What is the full task list? -> Tasks in "all tasks" plus any tasks assigned to Ann, Bob, or Carol that are not in the all tasks list.
        2.  Which tasks are assigned to at least one of the team members?
        3.  Which tasks still need to be assigned?
        4.  Which tasks are assigned to multiple team members?

        Create methods:
        - getUnion
        - getIntersection
        - getDifference
         */

        // 1.  What is the full task list? -> Tasks in "all tasks" plus any tasks assigned to Ann, Bob, or Carol that are not in the all tasks list.
        // Set<Task> fullTaskList = getUnion(tasks, annsTasks, bobsTasks, carolsTasks);
        List<Set<Task>> allSets = new ArrayList<>();
        allSets.add(tasks);
        allSets.add(annsTasks);
        allSets.add(bobsTasks);
        allSets.add(carolsTasks);

        Set<Task> fullTaskList = getUnion(allSets);
        sortAndPrint("Full Task List", fullTaskList, byPriority);

        // 2.  Which tasks are assigned to at least one of the team members?
        List<Set<Task>> assignedTasks = new ArrayList<>();
        assignedTasks.add(annsTasks);
        assignedTasks.add(bobsTasks);
        assignedTasks.add(carolsTasks);
        Set<Task> assignedToAtLeastOne = getUnion(assignedTasks);
        sortAndPrint("Assigned to at least one", assignedToAtLeastOne, byPriority);

        // 3.  Which tasks still need to be assigned?
        Set<Task> tasksStillNeedToBeAssigned = getDifference(tasks, assignedToAtLeastOne);
        sortAndPrint("Tasks still need to be assigned", tasksStillNeedToBeAssigned, byPriority);

        // 4.  Which tasks are assigned to multiple team members?
        Set<Task> assignedToMultiple = getUnion(List.of(
                getIntersection(annsTasks, bobsTasks),
                getIntersection(annsTasks, carolsTasks),
                getIntersection(bobsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to multiple", assignedToMultiple, byPriority);

//        // 5.  Which tasks are assigned to all the team members?
//        Set<Task> assignedToAll = getIntersectionOf3Sets(annsTasks, bobsTasks, carolsTasks);
//        sortAndPrint("Assigned to multiple", assignedToAll, byPriority);

        // 6. Task missing from boss's list
        Set<Task> missingTasks = getDifference(fullTaskList, tasks);
        sortAndPrint("Missing tasks", missingTasks, byPriority);



    }

    private static Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

//    private static Set<Task> getIntersectionOf3Sets(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks) {
//        Set<Task> intersection = new HashSet<>(annsTasks);
//        intersection.retainAll(bobsTasks);
//        intersection.retainAll(carolsTasks);
//        return intersection;
//    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> difference = new HashSet<>(a);
        difference.removeAll(b);
        return difference;
    }

    private static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        sets.forEach(union::addAll);
        return union;
    }

    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }


    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> comparator){
        String lineSeparator = "-".repeat(100);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(comparator);
        list.forEach(System.out::println);




    }

}