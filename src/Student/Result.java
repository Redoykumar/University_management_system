
package Student;

public class Result {
    private String Major;
    private String Mark;
    private String Samister;
    private String F_ID ;

    public Result() {
    }

    public Result(String Major, String Mark, String Samister, String F_ID) {
        this.Major = Major;
        this.Mark = Mark;
        this.Samister = Samister;
        this.F_ID = F_ID;
    }

    public String getMajor() {
        return Major;
    }

    public String getMark() {
        return Mark;
    }

    public String getSamister() {
        return Samister;
    }

    public String getF_ID() {
        return F_ID;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public void setMark(String Mark) {
        this.Mark = Mark;
    }

    public void setSamister(String Samister) {
        this.Samister = Samister;
    }

    public void setF_ID(String F_ID) {
        this.F_ID = F_ID;
    }

    @Override
    public String toString() {
        return "Result{" + "Major=" + Major + ", Mark=" + Mark + ", Samister=" + Samister + ", F_ID=" + F_ID + '}';
    }
  
    
}
