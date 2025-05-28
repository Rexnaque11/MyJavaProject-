// OnlineStore.java
import java.io.*;
import java.util.*;
import java.util.regex.*;

enum Role {
    CUSTOMER, STAFF, OWNER
}

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Price: PHP " + price + " | Quantity: " + quantity;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

class FinancialOverview {
    double totalSales, expenses;

    FinancialOverview(double totalSales, double expenses) {
        this.totalSales = totalSales;
        this.expenses = expenses;
    }

    double getNetProfit() {
        return totalSales - expenses;
    }
}

class User {
    String username, password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class OnlineStore {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Product> products = new LinkedList<>();
    static LinkedList<String> reports = new LinkedList<>();
    static ArrayList<CartItem> cart = new ArrayList<>();
    static FinancialOverview financialOverview = new FinancialOverview(15000, 4000);
    static HashMap<String, String> staffCredentials = new HashMap<>();
    static final String OWNER_USERNAME = "admin", OWNER_PASSWORD = "admin123";
    static User loggedInUser = null;
    static int nextProductId = 1;

    public static void main(String[] args) {
        loadStaffFromFile();
        staffCredentials.putIfAbsent("staff", "12345");
        loadProductsFromFile();
        loadSampleReports();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Customer\n2. Staff Login\n3. Owner Login\n4. Exit");
            System.out.print("Choose option: ");
            switch (scanner.nextLine()) {
                case "1" -> customerMenu();
                case "2" -> {
                    if (loginStaff()) {
                        System.out.println("Staff Logged in");
                        staffMenu();
                    } else {
                        System.out.println("Access Denied.");
                    }
                }
                case "3" -> {
                    if (login(OWNER_USERNAME, OWNER_PASSWORD)) {
                        System.out.println("Owner Logged in");
                        ownerMenu();
                    } else {
                        System.out.println("Access Denied.");
                    }
                }
                case "4" -> {
                    System.out.println("Exiting...");
                    saveProductsToFile();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void loadProductsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    products.add(new Product(id, name, price, quantity));
                    if (id >= nextProductId) nextProductId = id + 1;
                }
            }
            if (products.isEmpty()) {
                addDefaultProducts();
            }
        } catch (IOException e) {
            System.out.println("No existing product file found. Starting fresh.");
            addDefaultProducts();
        }
    }

    static void addDefaultProducts() {
        products.add(new Product(nextProductId++, "SkyFlakes", 8.50, 50));
        products.add(new Product(nextProductId++, "Royal", 16.00, 30));
        products.add(new Product(nextProductId++, "C2 Green Tea", 25.00, 20));
        products.add(new Product(nextProductId++, "Coffee", 12.00, 40));
        products.add(new Product(nextProductId++, "Lucky Me Pancit Canton", 14.00, 35));
        products.add(new Product(nextProductId++, "Nissin Cup Noodles", 23.00, 25));
        products.add(new Product(nextProductId++, "Coke Mismo", 18.00, 30));
        products.add(new Product(nextProductId++, "Sprite", 18.00, 30));
        products.add(new Product(nextProductId++, "Jack n' Jill Piattos", 20.00, 40));
        products.add(new Product(nextProductId++, "Nova Multigrain", 21.00, 30));
        products.add(new Product(nextProductId++, "Yakult (5 pack)", 50.00, 15));
        products.add(new Product(nextProductId++, "Mineral Water", 12.00, 50));
        products.add(new Product(nextProductId++, "Bread (Tasty)", 45.00, 20));
        products.add(new Product(nextProductId++, "Cheese Whiz Sachet", 12.00, 25));
        products.add(new Product(nextProductId++, "Tuna Flakes in Oil", 35.00, 20));

        saveProductsToFile();
        System.out.println("Default products loaded.");
    }

    static void loadStaffFromFile() {
        File file = new File("staff.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    staffCredentials.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading staff accounts.");
        }
    }

    static void saveStaffToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("staff.txt"))) {
            for (Map.Entry<String, String> entry : staffCredentials.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving staff accounts.");
        }
    }

    static void saveProductsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("products.txt"))) {
            for (Product p : products) {
                bw.write(p.id + "," + p.name + "," + p.price + "," + p.quantity);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving products to file.");
        }
    }

    static void loadSampleReports() {
        reports.add("Low stock: Royal, SkyFlakes");
        reports.add("Top seller: Coffee");
        reports.add("Feedback: Add more drinks");
    }

    static boolean login(String correctUser, String correctPass) {
        System.out.print("Enter username: ");
        String user = scanner.nextLine();
        System.out.print("Enter password: ");
        String pass = scanner.nextLine();
        return user.equals(correctUser) && pass.equals(correctPass);
    }

    static boolean loginStaff() {
        System.out.print("Enter staff username: ");
        String user = scanner.nextLine();
        System.out.print("Enter password: ");
        String pass = scanner.nextLine();
        return staffCredentials.getOrDefault(user, "").equals(pass);
    }

    static void customerMenu() {
        while (true) {
            System.out.println("\n--- Account Info ---");
            if (loggedInUser == null) {
                System.out.println("1. Sign-in\n2. Login\n3. Back");
                switch (scanner.nextLine()) {
                    case "1" -> createAccount();
                    case "2" -> loginCustomer();
                    case "3" -> { return; }
                    default -> System.out.println("Invalid option.");
                }
            } else {
                System.out.println("1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Logout");
                switch (scanner.nextLine()) {
                    case "1" -> viewAllProducts();
                    case "2" -> addToCart();
                    case "3" -> viewCart();
                    case "4" -> checkout();
                    case "5" -> { loggedInUser = null; cart.clear(); }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }

    static void createAccount() {
    try {
        System.out.print("Enter your Gmail: ");
        String email = scanner.nextLine().trim();

        if (!email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            System.out.println("Invalid Gmail.");
            return;
        }

        // Check if email already exists
        File file = new File("users.txt");
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].trim().equalsIgnoreCase(email)) {
                    System.out.println("This Gmail is already taken.");
                    br.close();
                    return;
                }
            }
            br.close();
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true));
        bw.write(email + "," + password);
        bw.newLine();
        bw.close();

        System.out.println("Account created.");
    } catch (IOException e) {
        System.out.println("Error saving account.");
    }
}



    static void loginCustomer() {
        try {
            System.out.print("Enter Gmail: ");
            String email = scanner.nextLine().trim();
            System.out.print("Enter password: ");
            String pass = scanner.nextLine().trim();

            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                if (parts[0].trim().equals(email) && parts[1].trim().equals(pass)) {
                    loggedInUser = new User(email, pass);
                    System.out.println("Login successful!");
                    br.close();
                    return;
                }
            }
            br.close();
            System.out.println("Login failed.");
        } catch (IOException e) {
            System.out.println("Account Was not Created.");
        }
    }

    static void addToCart() {
        viewAllProducts();
        try {
            System.out.print("Enter product ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());

            for (Product p : products) {
                if (p.id == id && qty <= p.quantity) {
                    cart.add(new CartItem(p, qty));
                    System.out.println("Added to cart.");
                    return;
                }
            }
            System.out.println("Product not found or insufficient quantity.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0;
        for (CartItem item : cart) {
            double subtotal = item.quantity * item.product.price;
            System.out.println(item.product.name + " x" + item.quantity + " = PHP " + subtotal);
            total += subtotal;
        }
        System.out.println("Total: PHP " + total);
    }

    static void checkout() {
    if (cart.isEmpty()) {
        System.out.println("Cart is empty.");
        return;
    }

    // Step 1: Display Order Summary
    double total = 0;
    System.out.println("\n--- ORDER SUMMARY ---");
    for (CartItem item : cart) {
        double subtotal = item.quantity * item.product.price;
        System.out.println(item.product.name + " x" + item.quantity + " = PHP " + subtotal);
        total += subtotal;
    }
    System.out.println("TOTAL AMOUNT: PHP " + total);

    // Step 2: Ask for confirmation
    System.out.print("Proceed to payment? (yes/no): ");
    String confirm = scanner.nextLine().trim().toLowerCase();
    if (!confirm.equals("yes")) {
        System.out.println("Checkout cancelled.");
        return;
    }

    // Step 3: Payment Input
    System.out.println("---- Paying Method: GCash ----- ");
    System.out.print("Enter GCash number: ");
    String number = scanner.nextLine();
    if (!number.matches("^09\\d{9}$")) {
        System.out.println("Invalid GCash number.");
        return;
    }

    System.out.print("Enter 4-digit PIN: ");
    String pin = scanner.nextLine();
    if (!pin.matches("^\\d{4}$")) {
        System.out.println("Invalid PIN.");
        return;
    }

    // Step 4: Update quantities & record payment
    for (CartItem item : cart) {
        item.product.quantity -= item.quantity;
    }
    financialOverview.totalSales += total;

    System.out.println("Payment successful!");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("payments.txt", true))) {
        writer.write("Customer: " + loggedInUser.username);
        writer.newLine();
        writer.write("Amount Paid: PHP " + total);
        writer.newLine();
        writer.write("GCash Number: " + number);
        writer.newLine();
        writer.write("Date: " + new Date());
        writer.newLine();
        writer.write("==================================");
        writer.newLine();
        System.out.println("Payment recorded for owner/staff.");
    } catch (IOException e) {
        System.out.println("Failed to record payment.");
    }
    
    cart.clear();
    saveProductsToFile();
}



    static void staffMenu() {
    while (true) {
        System.out.println("\n--- STAFF MENU ---");
        System.out.println("1. View Products");
        System.out.println("2. Add Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Modify Product");
        System.out.println("5. Search Product");
        System.out.println("6. Submit Report");
        System.out.println("7. Logout");
        System.out.print("Choose option: ");

        switch (scanner.nextLine()) {
            case "1" -> viewAllProducts();
            case "2" -> {
                addProduct();
                saveProductsToFile();
            }
            case "3" -> {
                deleteProduct();
                saveProductsToFile();
            }
            case "4" -> {
                modifyProduct();
                saveProductsToFile();
            }
            case "5" -> searchProduct();
            case "6" -> submitReport();
            case "7" -> {
                System.out.println("Logging out...");
                return;
            }
            default -> System.out.println("Invalid option.");
        }
    }
}


    static void addProduct() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());

            products.add(new Product(nextProductId++, name, price, qty));
            System.out.println("Product added.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
    static void deleteProduct() {
    viewAllProducts();
    System.out.print("Enter product ID to delete: ");
    try {
        int id = Integer.parseInt(scanner.nextLine());
        Product toRemove = null;
        for (Product p : products) {
            if (p.id == id) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid ID.");
    }
}
static void modifyProduct() {
    viewAllProducts();
    System.out.print("Enter product ID to modify: ");
    try {
        int id = Integer.parseInt(scanner.nextLine());
        for (Product p : products) {
            if (p.id == id) {
                System.out.print("Enter new name (current: " + p.name + "): ");
                String name = scanner.nextLine();
                System.out.print("Enter new price (current: " + p.price + "): ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter new quantity (current: " + p.quantity + "): ");
                int qty = Integer.parseInt(scanner.nextLine());

                p.name = name;
                p.price = price;
                p.quantity = qty;
                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    } catch (Exception e) {
        System.out.println("Invalid input.");
    }
}
static void searchProduct() {
    System.out.print("Enter product name to search: ");
    String keyword = scanner.nextLine().toLowerCase();
    boolean found = false;

    for (Product p : products) {
        if (p.name.toLowerCase().contains(keyword)) {
            System.out.println(p);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No matching product found.");
    }
}

    
    static void submitReport() {
        try (PrintWriter writer = new PrintWriter("ceo_report.txt")) {
            writer.println("=== CEO REPORT ===");
            for (Product p : products) {
                writer.println(p);
            }
            writer.println("Total Products: " + products.size());
            System.out.println("Report saved.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    static void ownerMenu() {
        while (true) {
            System.out.println("\n--- OWNER MENU ---");
            System.out.println("1. View Products\n2. View Reports\n3. Financial Overview\n4. Add Staff\n5. Logout");
            switch (scanner.nextLine()) {
                case "1" -> viewAllProducts();
                case "2" -> viewReports();
                case "3" -> viewFinancialOverview();
                case "4" -> addStaff();
                case "5" -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void addStaff() {
        System.out.print("Enter staff username: ");
        String user = scanner.nextLine().trim();
        if (staffCredentials.containsKey(user)) {
            System.out.println("Username exists.");
            return;
        }

        System.out.print("Enter password: ");
        String pass = scanner.nextLine().trim();
        if (pass.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        staffCredentials.put(user, pass);
        saveStaffToFile();
        System.out.println("Staff added.");
    }

    static void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- PRODUCT LIST ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    static void viewReports() {
        if (reports.isEmpty()) {
            System.out.println("No reports available.");
            return;
        }

        System.out.println("\n--- REPORTS ---");
        int count = 1;
        for (String report : reports) {
            System.out.println(count++ + ". " + report);
        }
    }

    static void viewFinancialOverview() {
        System.out.println("\n--- FINANCIAL OVERVIEW ---");
        System.out.printf("Total Sales   : PHP %.2f%n", financialOverview.totalSales);
        System.out.printf("Expenses      : PHP %.2f%n", financialOverview.expenses);
        System.out.printf("Net Profit    : PHP %.2f%n", financialOverview.getNetProfit());
    }
}
