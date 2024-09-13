package ir.freeland.spring.dto;

public class Item {

    private int id;
    private String name;
    private String catalog;
    private int price;

    public Item(String name, String catalog, int price) {
        this.name = name;
        this.catalog = catalog;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", catalog=" + catalog + ", price=" + price
                + "]";
    }

}
