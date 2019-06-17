package shalgueva.sophia;

public class Product {
    public int id;
    public String good;
    public double price;

    public Product(int id, String good, double price) {
        this.id = id;
        this.good = good;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Товар: %s | Цена: %s ",
                this.id, this.good, this.price);
    }
}
