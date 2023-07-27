package cloudcode.client.model;

public class Question {
  private int id;
  private String teacher_id;
  private String student_id;
  private String type;
  private String answer;
  private String subject;
  private String content;
  private String options_a;
  private String options_b;
  private String options_c;
  private String options_d;


  public Question(String teacher_id, String student_id, String type,
                  String answer, String subject, String content,
                  String options_a, String options_b, String options_c,
                  String options_d) {
    this.teacher_id = teacher_id;
    this.student_id = student_id;
    this.type = type;
    this.answer = answer;
    this.subject = subject;
    this.content = content;
    this.options_a = options_a;
    this.options_b = options_b;
    this.options_c = options_c;
    this.options_d = options_d;
  }

  public Question(int id, String teacher_id, String student_id, String type,
                  String answer, String subject, String content,
                  String options_a, String options_b, String options_c,
                  String options_d) {
    this.id = id;
    this.teacher_id = teacher_id;
    this.student_id = student_id;
    this.type = type;
    this.answer = answer;
    this.subject = subject;
    this.content = content;
    this.options_a = options_a;
    this.options_b = options_b;
    this.options_c = options_c;
    this.options_d = options_d;
  }

  // getters and setters for all fields
  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getTeacher_id() { return teacher_id; }

  public void setTeacher_id(String teacher_id) { this.teacher_id = teacher_id; }

  public String getStudent_id() { return student_id; }

  public void setStudent_id(String student_id) { this.student_id = student_id; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public String getAnswer() { return answer; }

  public void setAnswer(String answer) { this.answer = answer; }

  public String getSubject() { return subject; }

  public void setSubject(String subject) { this.subject = subject; }

  public String getContent() { return content; }

  public void setContent(String content) { this.content = content; }

  public String getOptions_a() { return options_a; }

  public void setOptions_a(String options_a) { this.options_a = options_a; }

  public String getOptions_b() { return options_b; }

  public void setOptions_b(String options_b) { this.options_b = options_b; }

  public String getOptions_c() { return options_c; }

  public void setOptions_c(String options_c) { this.options_c = options_c; }

  public String getOptions_d() { return options_d; }

  public void setOptions_d(String options_d) { this.options_d = options_d; }
}
