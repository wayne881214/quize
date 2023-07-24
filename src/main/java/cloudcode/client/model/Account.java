package cloudcode.client.model;

public class Account {

  private String account;
  private String password;
  private String name;

  public Account() {
  }
  public Account(final String account, final String password) {
    this.account = account;
    this.password = password;
  }
  public Account(final String account, final String password, final String name) {
    this.account = account;
    this.password = password;
    this.name = name;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(final String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }


}
