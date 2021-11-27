package Assignment_4;


import java.util.*;


public class library{

    public static void main(String[] args) {
        List<books> book_list = new ArrayList<>();
        List<Integer> bar_list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
       /*    book_list.add(new books("A1",10,3));
        book_list.add(new books("A1",9,3));
        book_list.add(new books("A2",10,3));
        book_list.add(new books("A1",10,2));
        book_list.add(new books("A3",10,7));
        book_list.add(new books("A3",10,2));
        */

        System.out.println("WELCOME");
        System.out.println("Enter no of books");
        int n = sc.nextInt();
        System.out.println("Enter no of racks");
        int k= sc.nextInt();
        sc.nextLine();//BUFFER clear
        int slot=n/k;
        int unique=1;



        for (int i=0; i<n ;i++){
            System.out.println("ENTER BOOK NAME");
            String name= sc.nextLine();
            System.out.println("ENTER ISBN CODE");
            int isbn= sc.nextInt();
            System.out.println("ENTER BARCODE(6 digits only)");
            int code = sc.nextInt();
            if (bar_list.contains(code)){
                unique=0;
                System.out.println("Enter unique barcode only");
                 int new_code = sc.nextInt();
                 if (new_code!= code){
                     unique=1;
                 }

            }else{
                bar_list.add(code);
            }

            sc.nextLine();//BUFFER clear
            if (unique==1){
            book_list.add(new books(name,isbn,code));
            System.out.println("BOOK ADDED!!");}
            else System.out.println("BOOK NOT ADDED");
        }


        Collections.sort(book_list);
        int cur_rack=1;
        int cur_slot=1;

        for (int i=0; i<book_list.size();i++){
            if (cur_slot>slot){
                cur_slot=1;
                cur_rack++;
            }
            books b1 =book_list.get(i);
            b1.setRack(cur_rack);
            b1.setSlot(cur_slot);
            System.out.println("Title: "+b1.getTitle()+" ISBN: "+b1.getISBN()+" Barcode: "+b1.getBarcode() +" Rack number: "+b1.getRack()+" Slot number: "+b1.getSlot()  );
            cur_slot++;
        }

    }
}