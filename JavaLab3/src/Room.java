public class Room {
    protected double space;
    protected double price;
    public Room(double space, double price){
        this.space = space;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getSpace() {
        return space;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSpace(double space) {
        this.space = space;
    }
    public void Show(){
        System.out.println("Space is: " + this.space);
        System.out.println("Price is: " + this.price);
    }
}

