package cloudcode.client.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** Defines a controller to handle HTTP requests */
@Controller
public final class ClientController {

  private static String project;
  private static final Logger logger =
      LoggerFactory.getLogger(ClientController.class);

  /**
   * Create an endpoint for the landing page
   *
   * @return the index view template
   */
  @GetMapping("/")
  public String helloWorld(Model model,HttpServletRequest request) {

    // Get Cloud Run environment variables.
    String revision = System.getenv("K_REVISION") == null
                          ? "???"
                          : System.getenv("K_REVISION");
    String service =
        System.getenv("K_SERVICE") == null ? "???" : System.getenv("K_SERVICE");

    // Set variables in html template.
    model.addAttribute("revision", revision);
    model.addAttribute("service", service);
    // Cookie[] cookies = request.getCookies(); //從request中獲取所有的cookie
    // if (cookies != null) {
    //   for (Cookie cookie : cookies) {
    //     if (cookie.getName().equals("account")) { //找到名為name的cookie
    //       String value = cookie.getValue();    //獲取其值
    //       return "/index";
    //     }
    //   }
    // }
    return "index-home";
  }
  @GetMapping("/api/index")
  public String login(Model model) {
    return "/index";
  }
  @GetMapping("/admin/index")
  public String admin(Model model) {
    return "/admin/index.html";
  }
}
