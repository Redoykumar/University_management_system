
package AdminDashboard;

public class Teacher {
    private String T_id ;
    private String name ;
    private int age ;
    private String Email ;
    private String Sex ;
    private String Phone ;
    private String Subject ;
    private String Address ;

    public Teacher() {
    }

    public Teacher(String T_id, String name, int age, String Email, String Sex, String Phone, String Subject, String Address) {
        this.T_id = T_id;
        this.name = name;
        this.age = age;
        this.Email = Email;
        this.Sex = Sex;
        this.Phone = Phone;
        this.Subject = Subject;
        this.Address = Address;
    }

    public String getT_id() {
        return T_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return Email;
    }

    public String getSex() {
        return Sex;
    }

    public String getPhone() {
        return Phone;
    }

    public String getSubject() {
        return Subject;
    }

    public String getAddress() {
        return Address;
    }

    public void setT_id(String T_id) {
        this.T_id = T_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "Teacher{" + "T_id=" + T_id + ", name=" + name + ", age=" + age + ", Email=" + Email + ", Sex=" + Sex + ", Phone=" + Phone + ", Subject=" + Subject + ", Address=" + Address + '}';
    }
    
    
    
}
