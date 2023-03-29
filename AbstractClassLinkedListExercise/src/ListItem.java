public abstract class ListItem {
    // write code here
    ListItem rightLink = null;
    ListItem leftLink = null;
    Object value = null;

    public ListItem (Object value){
        this.value = value;
    }

    public Object getValue(){
        return this.value;
    }

    public Object setValue(Object value){
        this.value = value;
        return this.value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem newItem);

}