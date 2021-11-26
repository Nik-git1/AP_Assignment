package Assignment_4;


import java.util.*;
import java.util.Comparator;

public class library{

    public static void main(String[] args) {
        List<books> book_list = new ArrayList<>();
        book_list.add(new books("A1",10,3));
        book_list.add(new books("A1",9,3));
        book_list.add(new books("A2",10,3));
        book_list.add(new books("A1",10,2));





        Collections.sort(book_list);

        for (int i=0; i<book_list.size();i++){
            System.out.println(book_list.get(i).getTitle()+" "+book_list.get(i).getISBN()+" "+book_list.get(i).getBarcode() );
        }

    }
}