package Assignment_1;

public class Vaccine {
    public String name;
    private int no_of_doses;
    private int gap_in_doses;


    public Vaccine(String name , int no_of_doses , int gap_in_doses){
        this.name=name;
        this.no_of_doses=no_of_doses;
        this.gap_in_doses= gap_in_doses;
    }

    public int getNo_of_doses() {
        return no_of_doses;
    }

    public int getGap_in_doses() {
        return gap_in_doses;
    }

    public String getName() {
        return name;
    }

}
