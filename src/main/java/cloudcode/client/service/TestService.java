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

  public List<Arrays> getALLTestQ() {
      Connection connection = sql2oDbHandler.getConnector().open();
      String queryQ = "select question_id From Test ";
      List<Arrays> resultQ = connection.createQuery(queryQ).executeAndFetch(Arrays.class);
      return resultQ;
    } 
  public List<Test> getALLTest() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select * From Test ";
      List<Test> result = connection.createQuery(query).executeAndFetch(Test.class);
      return result;
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