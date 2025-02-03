import java.util.List;

public class InventoryService {
    private final ItemDAO itemDAO = new ItemDAO();

    public void addItem(String name, int quantity, double price) {
        Item item = new Item(0, name, quantity, price);
        itemDAO.addItem(item);
    }

    public List<Item> viewAllItems() {
        return itemDAO.getAllItems();
    }

    public void deleteItem(int id) {
        itemDAO.deleteItem(id);
    }

    public void updateQuantity(int id, int newQuantity) {
        itemDAO.updateQuantity(id, newQuantity);
    }
}
