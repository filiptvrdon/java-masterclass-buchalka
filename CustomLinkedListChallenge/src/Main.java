import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        // list.traverse(list.getRoot());
/*
        String stringItems = "Bratislava, Trnava, Nitra, Zvolen, Prievidza, Kosice, Trencin, Cadca";
        String[] data = stringItems.split(", ");
        System.out.println(Arrays.toString(data));

        for (String s : data){
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
*/

        String stringItems = "1, 2, 4, 9, 4, 5, 8, 2, 3, 4, 5, 6, ,7, 2";
        String[] data = stringItems.split(", ");
        System.out.println(Arrays.toString(data));


        for (String s : data){
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());

        list.removeItem(new Node("2"));
        list.traverse(list.getRoot());

    }
}