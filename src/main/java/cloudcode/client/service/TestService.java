package cloudcode.client.service;

import cloudcode.client.database.Sql2oDbHandler;
import cloudcode.client.model.Question;
import cloudcode.client.model.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

@Service
public class TestService {
  @Autowired private Sql2oDbHandler sql2oDbHandler;

  public List<Arrays> getALLTestQ() {
    Connection connection = sql2oDbHandler.getConnector().open();
    String queryQ = "select question_id From Test ";
    List<Arrays> resultQ =
        connection.createQuery(queryQ).executeAndFetch(Arrays.class);
    return resultQ;
  }
  public List<Test> getALLTest() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select * From Test ";
      List<Test> result =
          connection.createQuery(query).executeAndFetch(Test.class);
      return result;
    }
  }
  public String searchTest(String id) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query =
          String.format("select question_id From Test where id='%s'", id);
      List<Test> result =
          connection.createQuery(query).executeAndFetch(Test.class);
      for (Test test : result) {
        return test.getQuestionId();
      }
      return null;
    }
  }
  public List<Test> searchTest() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select id,teacher_id,name,integral,score  From Test ";
      List<Test> result =
          connection.createQuery(query).executeAndFetch(Test.class);
      return result;
    }
  }
  public String addTest(final Test test) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format(
          "INSERT INTO `quize`.`test` (`question_id`, `teacher_id`, `student_id`, `name`, `integral`,`score`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
          test.getQuestionId(), test.getTeacherId(), test.getStudentId(),
          test.getName(), test.getIntegral(), test.getScore());
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
  public String delTest(String testId) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query =
          String.format("DELETE FROM test  where id='%s'", testId);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = "寫入成功";
    } catch (Exception ex) {
      // 除了SQLException以外之錯誤
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
}