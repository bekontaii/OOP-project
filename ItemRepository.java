import java.util.List;

public interface ItemRepository {
    void addItem(Item item);
    List<Item> getAllItems();
    void deleteItem(int id);
}
