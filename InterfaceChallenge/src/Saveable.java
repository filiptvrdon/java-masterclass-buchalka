import java.util.List;

public interface Saveable {
    public List<String> write();
    public void read(List<String> list);
}
