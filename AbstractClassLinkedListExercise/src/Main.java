import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        MyLinkedList list = new MyLinkedList(null);

        String stringItems = "Bratislava, Trnava, Nitra, Zazriva, Prievidza, Kosice, Trencin, Cadca";
        String[] data = stringItems.split(", ");
        System.out.println(Arrays.toString(data));

        for (String s : data){
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
        System.out.println("-".repeat(30));

        list.addItem(new Node("Bellova Ves"));
        list.addItem(new Node("Abelova"));
        list.addItem(new Node("Zvolen"));
        list.traverse(list.getRoot());
        System.out.println("-".repeat(30));

        list.removeItem(new Node("Trnava"));
        list.traverse(list.getRoot());
        System.out.println("-".repeat(30));

        list.removeItem(new Node("Abelova"));
        list.traverse(list.getRoot());
        System.out.println("-".repeat(30));
        */

        SearchTree searchTree = new SearchTree(null);
        String stringItemsST = "Bratislava, Trnava, Nitra, Zazriva, Prievidza, Kosice, Trencin, Cadca";
        String[] dataST = stringItemsST.split(", ");
        System.out.println(Arrays.toString(dataST));

        for (String s : dataST){
            searchTree.addItem(new Node(s));
        }

        searchTree.traverse(searchTree.getRoot());


    }

}