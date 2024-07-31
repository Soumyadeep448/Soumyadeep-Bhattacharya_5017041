//3. Implementation

public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}


//Using HashMap

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Product> productMap;

    public Inventory() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void deleteProduct(int productId) {
        productMap.remove(productId);
    }

    public Product getProduct(int productId) {
        return productMap.get(productId);
    }

    public void displayProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }
}

//for Testing
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 20, 499.99);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.displayProducts();

        product1.setPrice(899.99);
        inventory.updateProduct(product1);

        System.out.println("After updating:");
        inventory.displayProducts();

        inventory.deleteProduct(2);

        System.out.println("After deletion:");
        inventory.displayProducts();
    }
}
