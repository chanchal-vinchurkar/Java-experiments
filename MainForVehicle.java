import java.time.Year;
public class MainForVehicle {
    public static void main(String[] args) {
        Vehicle defV = new Vehicle();
        Vehicle v2 = new Vehicle(
                "Honda",
                "City",
                400000.99,
                "HON98822",
                "TN01AB1234",
                Year.of(2022)
        );
        Vehicle v3 = new Vehicle(v2);
        v3.setMfgCode("HON98765");
        v3.color = "Orange";
        Vehicle v4 = new Vehicle(
                "Mercedes",
                "S Class",
                9000000.00,
                "MER12345",
                "TN09ZZ9999",
                Year.of(2023)
        );
        Vehicle[] myFleet = new Vehicle[]{defV, v2, v3, v4};
        System.out.printf("%-15s %-15s %-15s %-15s\n",
                "Brand Name", "Model Name", "Price", "Mileage");
        System.out.println("----------------------------------------------------------------");
        for (Vehicle myV : myFleet) {
            double mileage = myV.calcMileage(300, 20);
            System.out.printf("%-15s %-15s %-15.2f %-15.2f\n",
                    myV.brandName,
                    myV.modelName,
                    myV.price,
                    mileage);
        }
        // Method calls
        System.out.println("\nVehicle Actions:\n");
        for (Vehicle myV : myFleet) {
            myV.start(30);
            myV.changeSpeed(80);
            myV.drive(1, 30, 100);
            myV.stop();
            System.out.println();
        }
    }
}

