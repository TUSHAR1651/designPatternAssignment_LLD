package exercise;

public class EmployeeDbAdapter implements Employee {
  private final EmployeeDB db;

  public EmployeeDbAdapter(EmployeeDB db) {
    this.db = db;
  }

  @Override
  public String getId() {
    return String.valueOf(db.getId());
  }

  @Override
  public String getFirstName() {
    return db.getFirstName();
  }

  @Override
  public String getLastName() {
    return db.getSurname();
  }

  @Override
  public String getEmail() {
    return db.getEmailAddress();
  }
    
}
