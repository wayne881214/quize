package cloudcode.client.service;

import cloudcode.client.database.Sql2oDbHandler;
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

  public List<Test> getALLTest() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select id,teacher_id,name,integral,score  From Test ";
      List<Test> result = connection.createQuery(query).executeAndFetch(Test.class);
      return result;
    } 
    catch (Exception e) {
      List<Test> tests = new ArrayList<>();
      tests.add(new Test(1, Arrays.asList("Q1", "Q2", "Q3"), "T1", "S1", "Name1", 10, 90));
      tests.add(new Test(2, Arrays.asList("Q4", "Q5", "Q6"), "T2", "S2", "Name2", 20, 80));
      tests.add(new Test(3, Arrays.asList("Q7", "Q8", "Q9"), "T3", "S3", "Name3", 30, 70));
      tests.add(new Test(4, Arrays.asList("Q10", "Q11", "Q12"), "T4", "S4", "Name4", 40, 60));
      return tests;
    }
  }
  public List<Test> searchTest() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select id,teacher_id,name,integral,score  From Test ";
      List<Test> result = connection.createQuery(query).executeAndFetch(Test.class);
      return result;
    } 
  }
}