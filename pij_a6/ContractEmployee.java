class ContractEmployee extends Employee {
    int noOfHrs;
    double hourlyRate;

    ContractEmployee(String name, String PANNo, String joiningDate,
                     String designation, int empId,
                     int noOfHrs, double hourlyRate) {

        super(name, PANNo, joiningDate, designation, empId);
        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calcCTC() {
        return noOfHrs * hourlyRate;
    }

    void displayContract() {
        System.out.println("\n--- Contract Employee ---");
        displayDetails();
        System.out.println("Hours Worked: " + noOfHrs);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("CTC: " + calcCTC());
    }
}