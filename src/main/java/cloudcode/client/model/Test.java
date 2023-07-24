package cloudcode.client.model;

public class Test {
  private String question_id;
  private String teacher_id;
  private String student_id;
  private String name;
  private int integral;
  private int score;
  private String student_answer;

  public Test(String question_id, String teacher_id, String student_id,
              String name, int integral, int score, String student_answer) {
    this.question_id = question_id;
    this.teacher_id = teacher_id;
    this.student_id = student_id;
    this.name = name;
    this.integral = integral;
    this.score = score;
    this.student_answer = student_answer;
  }

  // getters and setters
  public String getQuestionId() { return question_id; }

  public void setQuestionId(String question_id) {
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

  public String getStudentAnswer() { return student_answer; }

  public void setStudentAnswer(String student_answer) {
    this.student_answer = student_answer;
  }
}
