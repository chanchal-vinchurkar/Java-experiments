class FullTimeEmployee extends Employee {
    String role;
    double baseSalary;
    double perfBonus;
    double hiringCommission;

    FullTimeEmployee(String name, String PANNo, String joiningDate,
                     String designation, int empId,
                     String role, double baseSalary,
                     double perfBonus, double hiringCommission) {

        super(name, PANNo, joiningDate, designation, empId);
        this.role = role;
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.hiringCommission = hiringCommission;
    }

    @Override
    double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } 
        else if (role.equalsIgnoreCase("HR")) {
            return baseSalary + hiringCommission;
        }
        return baseSalary;
    }

    void displayFullTime() {
        System.out.println("\n--- Full Time Employee ---");
        displayDetails();
        System.out.println("Role: " + role);
        System.out.println("Annual CTC: " + calcCTC());
    }
}