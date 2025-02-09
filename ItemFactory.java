public class ItemFactory {
    public static Item createItem(String type, int id, String name, int quantity, double price, String extra) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Item type cannot be null or empty.");
        }
        return switch (type.toLowerCase()) {
            case "electronics" -> new ElectronicsItem(id, name, quantity, price, Integer.parseInt(extra));
            case "food" -> new FoodItem(id, name, quantity, price, extra);
            default -> throw new IllegalArgumentException("Invalid item type: " + type);
        };
    }
}
