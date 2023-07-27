package cloudcode.client.controller;

import cloudcode.client.model.Question;
import cloudcode.client.model.Test;
import cloudcode.client.service.QuestionService;
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
  @Autowired QuestionService questionManager;

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

  @PostMapping("/api/addTest")
  @ResponseBody
  public Boolean
  addQuestion(@RequestParam String question_id, @RequestParam String teacher_id,
              @RequestParam String student_id, @RequestParam String name,
              @RequestParam int integral, @RequestParam int score,
              HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    System.out.println("addTest");
    Test test =
        new Test(question_id, teacher_id, student_id, name, integral, score);
    testManager.addTest(test);
    return true;
  }
  @PostMapping("/api/searchTestQuestion")
  @ResponseBody
  public List<Question> searchTestQuestion(@RequestParam String TestId,
                                           @RequestParam String student_id,
                                           HttpServletRequest request,
                                           HttpServletResponse response)
      throws IOException {
    System.out.println("TestId is " + TestId);
    System.out.println("student_id is " + student_id);
    String questionList = testManager.searchTest(TestId);
    return questionManager.searchQuestion(questionList);
  }
  @PostMapping("/api/delTest")
  @ResponseBody
  public Boolean delTest(@RequestParam String TestId,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

    System.out.println("delTest");
    
    testManager.delTest(TestId);
    return true;
  }
}
