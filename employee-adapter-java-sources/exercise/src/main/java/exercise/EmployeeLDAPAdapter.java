package exercise;

public class EmployeeLDAPAdapter implements Employee {
  private final EmployeeLDAP ldap;

  public EmployeeLDAPAdapter(EmployeeLDAP ldap) {
    this.ldap = ldap;
  }

  @Override
  public String getId() {
    return ldap.get("uid");
  }

  @Override
  public String getFirstName() {
    return ldap.get("givenName");
  }

  @Override
  public String getLastName() {
    return ldap.get("sn");
  }

  @Override
  public String getEmail() {
    return ldap.get("mail");
  }
    
}
