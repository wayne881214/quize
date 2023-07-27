package cloudcode.client.controller;

import cloudcode.client.model.Question;
import cloudcode.client.model.Test;
import cloudcode.client.service.QuestionService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("CheckStyle")
@RestController
public class QuestionController {
  @Autowired private QuestionService questionService;

  @GetMapping("/api/getAllQuestion")
  public List<Question> getAllQuestion() {
    System.out.println("取得所有題庫");
    List<Question> response = questionService.getALLQuestion();

    // List<Arrays> responseQ = testManager.getALLTestQ();
    // Arrays a = responseQ.get(0);
    // System.out.println(Arrays.toString(a));

    return response;
  }
  @PostMapping("/api/addQuestion")
  @ResponseBody
  public Boolean
  addQuestion(@RequestParam String teacher_id, @RequestParam String student_id,
              @RequestParam String type, @RequestParam String answer,
              @RequestParam String subject, @RequestParam String content,
              @RequestParam String options_a, @RequestParam String options_b,
              @RequestParam String options_c, @RequestParam String options_d,
              HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    // 檢查所有參數是否包含字符串 'undefined'
    if (teacher_id.contains("undefined") || student_id.contains("undefined") ||
        type.contains("undefined") || answer.contains("undefined") ||
        subject.contains("undefined") || content.contains("undefined") ||
        options_a.contains("undefined") || options_b.contains("undefined") ||
        options_c.contains("undefined") || options_d.contains("undefined")) {
      return false;
    }
    if (teacher_id == null || teacher_id.isEmpty() || student_id == null ||
        student_id.isEmpty() || type == null || type.isEmpty() ||
        answer == null || answer.isEmpty() || subject == null ||
        subject.isEmpty() || content == null || content.isEmpty() ||
        options_a == null || options_a.isEmpty() || options_b == null ||
        options_b.isEmpty() || options_c == null || options_c.isEmpty() ||
        options_d == null || options_d.isEmpty()) {
      return false;
    }
    System.out.println("addQuestion");
    Question question =
        new Question(teacher_id, student_id, type, answer, subject, content,
                     options_a, options_b, options_c, options_d);
    questionService.addQuestion(question);
    return true;
  }

  // other controller methods for CRUD operations
}
