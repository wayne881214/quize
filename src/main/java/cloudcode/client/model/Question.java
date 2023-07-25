package cloudcode.client.model;
// id varchar(256) Not Null
// teacher_id varchar(256) Not Null
// type varchar(32) Not Null
// answer varchar(32) Not Null
// subject varchar(32) Not Null
// content varchar(32) Not Null
// options varchar(32) Not Null
public class Question {
    private int id;
    private String teacher_id;
    private String type;
    private String answer;
    private String subject;
    private String content;
    private String options;

    public Question(int id, String teacher_id, String type, String answer, String subject, String content, String options) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.type = type;
        this.answer = answer;
        this.subject = subject;
        this.content = content;
        this.options = options;
    }

    // getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
