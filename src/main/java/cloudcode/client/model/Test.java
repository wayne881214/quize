package cloudcode.client.model;

import java.util.List;

// id varchar(256) Not Null
// question_id varchar(256) Not Null
// teacher_id varchar(256) Not Null
// student_id varchar(256) Not Null
// name varchar(32) Not Null
// integral int Not Null
// score int Not Null
public class Test {
  private int id;
  private List<String> question_id;
  private String teacher_id;
  private String student_id;
  private String name;
  private int integral;
  private int score;
  // private String student_answer;

  public Test(int id) {
    this.id = id;
  }
    public Test(int id,  String teacher_id,
               String name, int integral, int score) {
    this.id = id;
    this.teacher_id = teacher_id;
    this.name = name;
    this.integral = integral;
    this.score = score;
  }
  public Test(int id, List<String> question_id, String teacher_id,
              String student_id, String name, int integral, int score) {
    this.id = id;
    this.question_id = question_id;
    this.teacher_id = teacher_id;
    this.student_id = student_id;
    this.name = name;
    this.integral = integral;
    this.score = score;
  }

  // getters and setters
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }
  public List<String> getQuestionId() { return question_id; }

  public void setQuestionId(List<String> question_id) {
    this.question_id = question_id;
  }

  public String getTeacherId() { return teacher_id; }

  public void setTeacherId(String teacher_id) { this.teacher_id = teacher_id; }

  public String getStudentId() { return student_id; }

  public void setStudentId(String student_id) { this.student_id = student_id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public int getIntegral() { return integral; }

  public void setIntegral(int integral) { this.integral = integral; }

  public int getScore() { return score; }

  public void setScore(int score) { this.score = score; }
}
