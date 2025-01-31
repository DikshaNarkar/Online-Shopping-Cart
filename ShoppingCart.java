import java.util.ArrayList;
class Product {
 String name;
 double price;
 public Product(String name, double price) {
 this.name = name;
 this.price = price;
 }
}
class ShoppingCart {
 ArrayList<Item> items;
 public ShoppingCart() {
 this.items = new ArrayList<>();
 }
 public void addItem(Product product, int quantity) {
 Item item = new Item(product, quantity);
 this.items.add(item);
 }
 public void removeItem(Product product) {
 for (int i = 0; i < this.items.size(); i++) {
 if (this.items.get(i).product == product) {
 this.items.remove(i);
 break;
 }
 }
 }
 public double calculateTotal() {
 double total = 0;
 for (Item item : this.items) {
 total += item.product.price * item.quantity;
 }
 return total;
 }
 public void displayCart() {
 if (this.items.isEmpty()) {
 System.out.println("Your shopping cart is empty.");
 } else {
 System.out.println("Your shopping cart:");
 for (Item item : this.items) {
 System.out.println(item.product.name + " - $" + item.product.price + " x " + 
item.quantity);
 }
 System.out.println("Total: $" + calculateTotal());
 }
 }
}
class Item {
 Product product;
 int quantity;
 public Item(Product product, int quantity) {
 this.product = product;
 this.quantity = quantity;
 }
}
class Main {
 public static void main(String[] args) {
 // Creating some products
 Product product1 = new Product("Laptop", 999);
 Product product2 = new Product("Mouse", 20);
 Product product3 = new Product("Keyboard", 50);
 // Creating a shopping cart
 ShoppingCart cart = new ShoppingCart();
 // Adding products to the cart
 cart.addItem(product1, 1);
 cart.addItem(product2, 2);
 cart.addItem(product3, 1);
 // Displaying the cart
 cart.displayCart();
 // Removing a product from the cart
 cart.removeItem(product2);
 // Displaying the cart again
 cart.displayCart();
 }
}
