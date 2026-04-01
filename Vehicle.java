import java.time.Year;
public class Vehicle
{
    // Public data members
    public String brandName;
    public String modelName;
    public double price;
    public String color;
    public Year mfgYear;
    public char fuelType; // 'P' Petrol, 'D' Diesel, 'E' Electric, 'H' Hybrid
    // Private data members
    private String mfgCode;
    private String regNo;
    // Getter for mfgCode
    public String getMfgCode()
    {
        return mfgCode;
    }
    // Setter for mfgCode
    public void setMfgCode(String mCode)
    {
        mfgCode = mCode;
    }
    // Getter for regNo
    public String getRegNo()
    {
        return regNo;
    }
    // Setter for regNo
    public void setRegNo(String rNo)
    {
        regNo = rNo;
    }
    // Default constructor
    public Vehicle()
    {
        brandName = "Hyundai";
        modelName = "i10";
        color = "Silver";
        price = 500000.95;
        mfgCode = "HYN12345";
        regNo = "TN10BY8765";
        mfgYear = Year.of(2020);
        fuelType = 'P';
    }
    // Parameterized constructor
    public Vehicle(String brandName, String modelName, double price,
                   String mfgCode, String regNo, Year mfgYear)
    {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.mfgCode = mfgCode;
        this.regNo = regNo;
        this.mfgYear = mfgYear;
    }
    // Copy constructor
    public Vehicle(Vehicle v)
    {
        brandName = v.brandName;
        modelName = v.modelName;
        price = v.price;
        color = v.color;
        mfgCode = v.mfgCode;
        regNo = v.regNo;
        mfgYear = v.mfgYear;
        fuelType = v.fuelType;
    }
    public void start(int initSp)
    {
        System.out.println("Vehicle started with initial speed: " + initSp);
    }
    public void stop()
    {
        System.out.println("That was a nice ride!");
    }
    public void drive(int initGear, int initSp, int tgtSp)
    {
        if(initGear != 1)
            System.out.println("I always start moving in gear 1.");
        if(initSp < 20)
            System.out.println("That is the ideal speed to start with.");
        else
            System.out.println("Be careful");
        if (tgtSp > 200)
            System.out.println("Look out for cops!");
        else
            System.out.println("You are within the ideal speed range.");
    }
    public double calcMileage(double noOfKms, double fuelUsed)
    {
        if(fuelUsed == 0)
            return 0;
        return noOfKms / fuelUsed;
    }
    public void changeSpeed(int newSpeed)
    {
        System.out.println("Speed changed to: " + newSpeed);
    }
}