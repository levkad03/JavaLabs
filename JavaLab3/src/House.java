import java.util.ArrayList;
import java.util.Scanner;

public class House {
    private ArrayList<Room> roomslist;
    private int numberOfFloors;
    private String color;
    public House(int numberOfFloors, String color){
        this.roomslist = new ArrayList<>();
        this.numberOfFloors = numberOfFloors;
        this.color = color;
    }

    public void add(Room r){
        this.roomslist.add(r);
    }

    public void count(){
        int k = 0;
        int m = 0;
        for (Room room : this.roomslist) {
            if (room instanceof Flat) {
                k++;
            } else if (room instanceof Office) {
                m++;
            }
        }
        System.out.println("The number of flats: "+ k);
        System.out.println("The number of offices: " + m);
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
