package business;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> cart;

    public void addProduct(Product newProduct) {
        cart = new ArrayList<>();
        cart.add(newProduct);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product p: cart) {
            totalPrice += p.getPrice() * p.getQuantity();
        }
        return totalPrice;
    }
}
