package Assignment_4;

public class books implements Comparable<books> {
   String Title;
int ISBN;
 int barcode;

    public books(String Title, int ISBN, int barcode) {
        this.Title = Title;
        this.ISBN = ISBN;
        this.barcode = barcode;
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
