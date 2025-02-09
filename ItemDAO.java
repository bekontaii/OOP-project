import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements ItemRepository {
    @Override
    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }

        String type = item instanceof ElectronicsItem ? "electronics" : "food";
        String extra = item instanceof ElectronicsItem
                ? String.valueOf(((ElectronicsItem) item).getWarrantyPeriod())
                : ((FoodItem) item).getExpirationDate();

        if (type == null || extra == null) {
            throw new IllegalArgumentException("Item type and extra cannot be null.");
        }

        String sql = "INSERT INTO items (name, quantity, price, type, extra) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getQuantity());
            pstmt.setDouble(3, item.getPrice());
            pstmt.setString(4, type);
            pstmt.setString(5, extra);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("type");
                if (type == null || type.isEmpty()) {
                    System.err.println("Warning: Skipping item with ID " + rs.getInt("id") + " due to null or empty type.");
                    continue; // Пропускаем записи с некорректным значением type
                }
                String extra = rs.getString("extra");
                Item item = ItemFactory.createItem(
                        type,
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        extra
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


    @Override
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                System.err.println("No item found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

