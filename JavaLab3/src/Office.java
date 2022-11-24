public class Office extends Room{
    private String officeName;
    private double numberOfPeople;
    public Office(double space, double price, String officeName, double numberOfPeople){
        super(space,price);
        this.officeName = officeName;
        this.numberOfPeople = numberOfPeople;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public double getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(double numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }


    public void Show(){
        System.out.println("The space is: " + this.space);
        System.out.println("The price is: " + this.price);
        System.out.println("The office name is: " + this.officeName);
        System.out.println("The number of people is: " + this.numberOfPeople);
    }
}
