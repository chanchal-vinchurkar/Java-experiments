class Manager extends FullTimeEmployee {
    double travelAllowance;
    double eduAllowance;

    Manager(String name, String PANNo, String joiningDate,
            String designation, int empId,
            String role, double baseSalary,
            double perfBonus, double hiringCommission,
            double travelAllowance, double eduAllowance) {

        super(name, PANNo, joiningDate, designation, empId,
              role, baseSalary, perfBonus, hiringCommission);

        this.travelAllowance = travelAllowance;
        this.eduAllowance = eduAllowance;
    }

    @Override
    double calcCTC() {
        return baseSalary + perfBonus + travelAllowance + eduAllowance;
    }

    void displayManager() {
        System.out.println("\n--- Manager ---");
        displayDetails();
        System.out.println("Travel Allowance: " + travelAllowance);
        System.out.println("Education Allowance: " + eduAllowance);
        System.out.println("Manager CTC: " + calcCTC());
    }
}