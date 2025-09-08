package exercise;

public class EmployeeCSVAdapter implements Employee {

    private final EmployeeCSV csv;

    public EmployeeCSVAdapter(EmployeeCSV csv) {
        this.csv = csv;
    }

    @Override
    public String getId() {
        return csv.tokens()[0];
    }

    @Override
    public String getFirstName() {
        return csv.tokens()[1];
    }

    @Override
    public String getLastName() {
        return csv.tokens()[2];
    }

    @Override
    public String getEmail() {
        return csv.tokens()[3];
    }

}
