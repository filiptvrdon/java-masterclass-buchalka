import java.util.List;

public class MyLinkedList implements NodeList {
    // write code here
    private ListItem root = null;

    public MyLinkedList (ListItem root){
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        ListItem root = this.getRoot();

        if (root == null){
            // root is null -> list is empty //
            this.root = newItem;
            return true;
        }

        // otherwise continue checking list items //
        ListItem currentItem = root;

        int comparison;
        while (currentItem != null) {

            comparison = currentItem.compareTo(newItem);
            if (comparison > 0) {
                if (currentItem.previous() == null) {
                    // replacing root
                    currentItem.setPrevious(newItem).setNext(currentItem);
                    this.root = newItem;
                } else {
                    // replacing in the chain
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    currentItem.setPrevious(newItem).setNext(currentItem);
                }
                return true;
            } else if (comparison < 0) {
                if (currentItem.next() == null){
                    // replacing tail
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                } else {
                    currentItem = currentItem.next();
                }
            } else {
                System.out.println("Duplicate items are not allowed!");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem itemToBeRemoved) {
        ListItem root = this.getRoot();

        if (root == null){
            // root is null -> list is empty //
            System.out.println("List is empty!");
            return false;
        }

        ListItem currentItem = root;
        boolean isRoot = true;
        while (currentItem != null){
            if (currentItem.getValue().equals(itemToBeRemoved.getValue())){
                // match, now unlink current item and link remaining nodes //

                if (currentItem.previous() == null){
                    // root //
                    currentItem.next().setPrevious(null);
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                }

                if (currentItem.next() == null){
                    // tail//
                    currentItem.previous().setNext(null);
                } else {
                    currentItem.next().setPrevious(currentItem.previous());
                }
                return true;
            }
            currentItem = currentItem.next();
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        System.out.println(root);

        if (root == null){
            System.out.println("The list is empty");
            return;
        }

        while (root != null){
            System.out.println(root.getValue());
            root = root.next();
        }

    }
}