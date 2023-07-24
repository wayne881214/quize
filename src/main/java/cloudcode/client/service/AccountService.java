package cloudcode.client.service;

import cloudcode.client.database.Sql2oDbHandler;
import cloudcode.client.model.Account;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

@Service
public class AccountService {
  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public List<Account> getAccounts() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select 電子郵件 email, 密碼 password"
          + " from 帳密資料";
      return connection.createQuery(query).executeAndFetch(Account.class);
    }
  }

  public String addAccount(final Account account) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("INSERT INTO `quize`.`account` "
          + "(`account`, `password`, `name`) "
          + "VALUES ('%s','%s','%s');", account.getAccount(), account.getPassword(),account.getName());
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();

      returnMessage = query + "寫入成功";

    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  public Object checkLogin(final Account account) {
    //檢查登入 陽春版
    System.out.println("checkLogin");

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query =  String.format("SELECT * FROM quize.account "
          + "WHERE account='%s' "
          + "and password='%s';", account.getAccount(), account.getPassword());
      System.out.println(query);
      return connection.createQuery(query).executeScalar();
    }
  }
}
