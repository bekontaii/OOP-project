public class FoodItem extends Item {
    private String expirationDate;

    public FoodItem(int id, String name, int quantity, double price, String expirationDate) {
        super(id, name, quantity, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() { return expirationDate; }

    @Override
    public String toString() {
        return super.toString() + ", Expiration Date: " + expirationDate;
    }
}
