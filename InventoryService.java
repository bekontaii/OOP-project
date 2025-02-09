import java.util.List;

public class InventoryService {
    private final ItemRepository itemRepository;

    public InventoryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(String type, String name, int quantity, double price, String extra) {
        Item item = ItemFactory.createItem(type, 0, name, quantity, price, extra);
        itemRepository.addItem(item);
    }

    public List<Item> viewAllItems() {
        return itemRepository.getAllItems();
    }

    public void deleteItem(int id) {
        itemRepository.deleteItem(id);
    }
}
