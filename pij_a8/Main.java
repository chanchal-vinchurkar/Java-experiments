import java.util.*;

// Product interface
interface Product {
    void displayDetails();
}

// Legacy class
class LegacyItem {
    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

// Adapter class
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        legacyItem.print();
    }
}

// New product class
class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}

// Singleton InventoryManager
class InventoryManager {
    private static InventoryManager instance;
    private List<Product> productList;

    // Private constructor
    private InventoryManager() {
        productList = new ArrayList<>();
    }

    // Get single instance
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Add product
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Return iterator
    public Iterator<Product> returnInventory() {
        return productList.iterator();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Singleton instance
        InventoryManager manager = InventoryManager.getInstance();

        // Add new products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Smartphone"));

        // Add legacy items using adapter
        LegacyItem oldItem1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem oldItem2 = new LegacyItem(102, "Old Monitor");

        manager.addProduct(new ProductAdapter(oldItem1));
        manager.addProduct(new ProductAdapter(oldItem2));

        // Iterate using Iterator
        Iterator<Product> iterator = manager.returnInventory();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayDetails();
        }
    }
}