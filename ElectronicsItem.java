public class ElectronicsItem extends Item {
    private int warrantyPeriod;

    public ElectronicsItem(int id, String name, int quantity, double price, int warrantyPeriod) {
        super(id, name, quantity, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() { return warrantyPeriod; }

    @Override
    public String toString() {
        return super.toString() + ", Warranty Period: " + warrantyPeriod + " months";
    }
}
