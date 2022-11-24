public class Flat extends Room{
    private double numberOfPeople;
    public Flat(double space, double price,double numberOfPeople){
        super(space, price);
        this.numberOfPeople = numberOfPeople;
    }
    public void Show(){
        System.out.println("Space is: " + this.space);
        System.out.println("Price is: " + this.price);
        System.out.println("Number of people are: "+ this.numberOfPeople);
    }


    public double getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(double numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

}
