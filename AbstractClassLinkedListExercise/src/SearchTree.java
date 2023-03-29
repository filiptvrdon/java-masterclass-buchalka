public class SearchTree implements NodeList{
    private ListItem root;

    public SearchTree(ListItem root){
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        int comparison;
        while (currentItem != null){
            comparison = (currentItem.compareTo(newItem));

            if (comparison > 1){
                if (currentItem.previous() == null){
                    currentItem.setPrevious(newItem);
                    return true;
                } else {
                    currentItem = currentItem.previous();
                }
            } else if (comparison < 1){
                if (currentItem.next() == null){
                    currentItem.setNext(newItem);
                    return true;
                } else {
                    currentItem = currentItem.next();
                }
            } else {
                System.out.println("duplicates not allowed");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {

    }

    @Override
    public void traverse(ListItem root) {
        if (root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
