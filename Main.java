import java.util.Scanner;

public class Main {
    private static final InventoryService service = new InventoryService(new ItemDAO());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Delete Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewAllItems();
                case 3 -> deleteItem();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item type (electronics/food): ");
        String type = scanner.next();
        System.out.print("Enter item name: ");
        String name = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        String extra;
        if (type.equalsIgnoreCase("electronics")) {
            System.out.print("Enter warranty period (1nths): ");
            extra = scanner.next();
        } else if (type.equalsIgnoreCase("food")) {
            System.out.print("Enter expiration date (YYYY-MM-DD): ");
            extra = scanner.next();
        } else {
            System.out.println("Invalid item type. Please try again.");
            return;
        }

        service.addItem(type, name, quantity, price, extra);
        System.out.println("Item added successfully.");
    }

    private static void viewAllItems() {
        service.viewAllItems().forEach(System.out::println);
    }

    private static void deleteItem() {
        System.out.print("Enter the ID of the item to delete: ");
        int id = scanner.nextInt();
        service.deleteItem(id);
        System.out.println("Item deleted successfully.");
    }
}
