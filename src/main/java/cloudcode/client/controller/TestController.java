package cloudcode.client.controller;

import cloudcode.client.model.Test;
import cloudcode.client.service.TestService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("CheckStyle")
@RestController
public class TestController {
  @Autowired TestService testManager;

  @GetMapping("/api/try")
  public String getTry() {
    System.out.println("TRY");
    return "try";
  }

  @GetMapping("/api/getAllTest")
  public List<Test> getAllTest() {
    System.out.println("取得所有考券");
    List<Test> response = testManager.getALLTest();

    // List<Arrays> responseQ = testManager.getALLTestQ();
    // Arrays a = responseQ.get(0);
    // System.out.println(Arrays.toString(a));

    return response;
  }

  @PostMapping("/api/setTest")
  @ResponseBody
  public String searchAsllTest(@RequestParam String id,
                                  HttpServletRequest request,
                                  HttpServletResponse response)
      throws IOException {
    System.out.println("id is " + id);
    Cookie cookie = new Cookie("testId", id);
    cookie.setPath("/");
    response.addCookie(cookie);
    return id;
  }

  @PostMapping("/api/searchAllTest")
  @ResponseBody
  public List<Test> searchAllTest(@RequestParam String student_id,
                                  HttpServletRequest request,
                                  HttpServletResponse response)
      throws IOException {
    System.out.println("student_id is " + student_id);
    return testManager.getALLTest();
  }

  @PostMapping("/api/searchTest")
  @ResponseBody
  public List<Test>
  searchTest(@RequestParam String TestId, @RequestParam String student_id,
             HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    System.out.println("TestId is " + TestId);
    System.out.println("student_id is " + student_id);
    return testManager.getALLTest();
  }

  
}
