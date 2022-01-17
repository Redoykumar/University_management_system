
package Student;

public class Course {
    private String Course_ID;
    private String Course_name;
    private String Duration;
    private String Fee;

    public Course() {
    }

    public Course(String Course_ID, String Course_name, String Duration, String Fee) {
        this.Course_ID = Course_ID;
        this.Course_name = Course_name;
        this.Duration = Duration;
        this.Fee = Fee;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public String getDuration() {
        return Duration;
    }

    public String getFee() {
        return Fee;
    }

    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }

    public void setCourse_name(String Course_name) {
        this.Course_name = Course_name;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public void setFee(String Fee) {
        this.Fee = Fee;
    }

    @Override
    public String toString() {
        return "Course{" + "Course_ID=" + Course_ID + ", Course_name=" + Course_name + ", Duration=" + Duration + ", Fee=" + Fee + '}';
    }
    
    
    
}
