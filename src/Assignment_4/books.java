package Assignment_4;

public class books implements Comparable<books> {
    private String Title;
    private int ISBN;
    private int barcode;
    private int rack;
    private int slot;

    public books(String Title, int ISBN, int barcode) {
        this.Title = Title;
        this.ISBN = ISBN;
        this.barcode = barcode;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public int getBarcode() {
        return barcode;
    }

    public int getRack() {
        return rack;
    }

    public int getSlot() {
        return slot;
    }

    @Override
    public int compareTo(books o) {
        int name= this.Title.compareTo(o.getTitle());
        int isbn=this.ISBN-o.getISBN();
        int barcode =this.barcode-o.getBarcode();
        if (name == 0) {
            if (isbn == 0) {
                return barcode;
            }
            return isbn;
        }
        return name;

    }
}
