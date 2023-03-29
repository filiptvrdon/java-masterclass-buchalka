import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // LinkedList<String> placesToVisit = new LinkedList<>()
        var placeToVisit = new LinkedList<String>();

        placeToVisit.add("Sydney");
        placeToVisit.add(0, "Canberra");
        System.out.println(placeToVisit);

        addMoreElements(placeToVisit);
        System.out.println(placeToVisit);

        removeElements(placeToVisit);
        System.out.println(placeToVisit);
    }


    private static void addMoreElements (LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");
        // queue methods //
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // stack methods //
        list.push("Alice Springs");
    }

    private static void removeElements (LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");
        System.out.println(list);

        String s1 = list.removeFirst();
        System.out.println(s1 + " was removed!");

        String p1 = list.poll();
        System.out.println(p1 + " was removed!");

        String p2 = list.removeLast;();
        System.out.println(list);


    }
}