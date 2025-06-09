public class Teacher {
    private String username;
    private String password;
    private String teacherId;

    public Teacher(String username, String password, String teacherId) {
        this.username = username;
        this.password = password;
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}
