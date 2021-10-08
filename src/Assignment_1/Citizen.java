package Assignment_1;

public class Citizen {
    private String name;
    private int age;
    private long id;
    private String status;
    private boolean eligible;
    private Vaccine current;

    public Citizen(String name,int age, long id){

        this.status="NOT VACCINATED";
        this.name = name;
        this.age = age;
        this.id = id;
        if (age<18){
            eligible=false;
            System.out.println("Only above 18 are allowed");
        }else
            eligible=true;
    }

    public void update_status(String status){
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setCurrent(Vaccine current) {
        this.current = current;
    }
}
