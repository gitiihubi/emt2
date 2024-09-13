package ir.freeland.spring.dto;

public class Example {

    private int id;
    private Item item;
    private String reason;

    public Example(String reason) {

        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Example [id=" + id + ", item=" + item + ", reason=" + reason + "]";
    }

}
