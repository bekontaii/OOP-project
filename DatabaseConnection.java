import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/OOP-DB"; // Укажите ваше имя базы данных
    private static final String USER = "postgres"; // Укажите ваше имя пользователя
    private static final String PASSWORD = "bekarys7"; // Укажите ваш пароль

    static {
        try {
            // Ручная загрузка драйвера
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
