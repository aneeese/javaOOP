package JavaOOP.Assignment_3;

public class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice() {
        partNumber = null;
        partDescription = null;
        quantity = 0;
        pricePerItem = 0.0;
    }

    public double getPaymentAmount() {
        return (quantity * pricePerItem);
    }
}
