
package AdminDashboard;

public class Student {
    private String S_id ;
    private String name ;
    private int age ;
    private String Email ;
    private String Sex ;
    private String Phone ;
    private String Address ;
    private String F_id ;
    private String Department ;

    public Student(String S_id, String name, int age, String Email, String Sex, String Phone, String Address, String F_id, String Department) {
        this.S_id = S_id;
        this.name = name;
        this.age = age;
        this.Email = Email;
        this.Sex = Sex;
        this.Phone = Phone;
        this.Address = Address;
        this.F_id = F_id;
        this.Department = Department;
    }

    public Student() {
    }
    
    public Student(String S_id, String name, int age, String Email, String Sex, String Phone, String Address, String F_id) {
        this.S_id = S_id;
        this.name = name;
        this.age = age;
        this.Email = Email;
        this.Sex = Sex;
        this.Phone = Phone;
        this.Address = Address;
        this.F_id = F_id;
    }

    public String getS_id() {
        return S_id;
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

    public String getAddress() {
        return Address;
    }

    public String getF_id() {
        return F_id;
    }

    public String getDepartment() {
        return Department;
    }
    

    public void setS_id(String S_id) {
        this.S_id = S_id;
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

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setF_id(String F_id) {
        this.F_id = F_id;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    @Override
    public String toString() {
        return "Student{" + "S_id=" + S_id + ", name=" + name + ", age=" + age + ", Email=" + Email + ", Sex=" + Sex + ", Phone=" + Phone + ", Address=" + Address + ", F_id=" + F_id + ", Department=" + Department + '}';
    }
    

   
    
    
    
    
}
