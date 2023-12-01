package srp;

public class SrpExample3 {
    private String name;
    private String email;

    public SrpExample3(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Нарушение принципа SRP, класс хранит информацию о сотруднике и одновременно занимается её проверкой
    public boolean isValid() {
        return email.contains("@");
    }
}
