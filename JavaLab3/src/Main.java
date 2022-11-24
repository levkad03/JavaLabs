public class Main {
    public static void main(String[] args) {
        Room r = new Room(150, 240000);
        r.Show();

        Flat f = new Flat(50,35000,5);
        f.Show();

        Office office = new Office(65, 120000,"Apple", 30);
        office.Show();

        Flat f2 = new Flat(35, 10000, 15);

        House house = new House(3, "White");
        house.add(f);
        house.add(office);
        house.add(f2);
        house.count();
    }
}
