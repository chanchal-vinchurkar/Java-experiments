public class EmployeeTest {
    public static void main(String[] args) {

        FullTimeEmployee swe = new FullTimeEmployee(
                "Rohan Patil",
                "AAAAA1111A",
                "10-06-2023",
                "Software Engineer",
                101,
                "SWE",
                800000,
                100000,
                0
        );

        FullTimeEmployee hr = new FullTimeEmployee(
                "Neha Sharma",
                "BBBBB2222B",
                "15-02-2022",
                "HR Executive",
                102,
                "HR",
                600000,
                0,
                75000
        );

        ContractEmployee contract = new ContractEmployee(
                "Vikas Kumar",
                "CCCCC3333C",
                "01-01-2025",
                "Consultant",
                201,
                150,
                1000
        );

        Manager manager = new Manager(
                "Priya Mehta",
                "DDDDD4444D",
                "20-09-2020",
                "Project Manager",
                301,
                "SWE",
                1400000,
                200000,
                0,
                70000,
                30000
        );

        swe.displayFullTime();
        hr.displayFullTime();
        contract.displayContract();
        manager.displayManager();
    }
}