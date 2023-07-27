package cloudcode.client.controller;

import cloudcode.client.model.Account;
import cloudcode.client.service.AccountService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("CheckStyle")
@RestController
public class AccountController {
  @Autowired AccountService accountManager;

  @SuppressWarnings("checkstyle:RegexpSingleline")
  @GetMapping("/api/getAllAccounts")
  public List<Account> getAccounts() {
    System.out.println("取得所有帳密");
    return accountManager.getAccounts();
  }

  public Boolean checkAccount(Account account) {
    if (accountManager.checkLogin(account) == null) {
      System.out.println("null");
      return false;
      //錯誤
    }
    System.out.println("sucess");
    return true;
  }

  @PostMapping("/api/login")
  @ResponseBody
  public boolean getLoginData(@RequestParam String account,
                              @RequestParam String password,
                              HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    //接收前端帳密資料
    System.out.println("email is " + account);
    System.out.println("password is " + password);
    Account accountData = new Account(account, password);

    //檢查帳密正確
    // checkAccount(account);
    if (accountManager.checkLogin(accountData) == null) {
      System.out.println("登入失敗");
      resp.sendRedirect("/login.html");
      return false;
      //錯誤
    } else {
      System.out.print("登入成功");
      Cookie cookie = new Cookie("account", account);
      cookie.setPath("/");
      resp.addCookie(cookie);
      resp.sendRedirect("/index.html");
      //相關說明:https://www.uj5u.com/ruanti/1020.html
      return true;
      //比對成功
    }
  }

  @PostMapping("/api/singup")
  @ResponseBody

  public boolean singUpAll(@RequestParam String account,
                           @RequestParam String password,
                           @RequestParam String name,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
    System.out.println("account is " + account);
    System.out.println("password is " + password);
    // //
    // //if(後端檢查註冊_function()==ture&&檢查重複_function()==ture).........
    Account accountData = new Account(account, password,name);
    // // Member member = new Member(email, name, imageUrl, phoneNumber,
    // address);
    // // //連線資料庫
    accountManager.addAccount(accountData);
    // // accountManager.addMember(member);
    response.sendRedirect("/admin/index.html");
    return true;
  }
  // SELECT * FROM quize.account;
}
