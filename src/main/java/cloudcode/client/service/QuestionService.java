package cloudcode.client.service;

import cloudcode.client.database.Sql2oDbHandler;
import cloudcode.client.model.Question;
import cloudcode.client.model.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

@Service
public class QuestionService {
  @Autowired private Sql2oDbHandler sql2oDbHandler;

  public List<Question> getALLQuestion() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select * From quize.question ";
      System.out.println(query);
      List<Question> result =
          connection.createQuery(query).executeAndFetch(Question.class);
      System.out.println(result);
      return result;
    }
  }
  public String addQuestion(final Question question) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format(
          "INSERT INTO `quize`.`question` (`teacher_id`, `student_id`, `type`, `answer`, `subject`, `content`, `options_a`, `options_b`, `options_c`, `options_d`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
          question.getTeacher_id(), question.getStudent_id(),
          question.getType(), question.getAnswer(), question.getSubject(),
          question.getContent(), question.getOptions_a(), question.getOptions_b(),
          question.getOptions_c(), question.getOptions_d());
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();

      returnMessage = "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
}
