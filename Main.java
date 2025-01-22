import java.util.Scanner;

public class Main {
    private static final InventoryService service = new InventoryService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewAllItems();
                case 3 -> updateItemQuantity();
                case 4 -> deleteItem();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        service.addItem(name, quantity, price);
        System.out.println("Item added successfully.");
    }

    private static void viewAllItems() {
        service.viewAllItems().forEach(System.out::println);
    }

    private static void updateItemQuantity() {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        service.updateQuantity(id, quantity);
        System.out.println("Item quantity updated successfully.");
    }

    private static void deleteItem() {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        service.deleteItem(id);
        System.out.println("Item deleted successfully.");
    }
}
