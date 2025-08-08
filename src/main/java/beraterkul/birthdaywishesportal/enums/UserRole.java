package beraterkul.birthdaywishesportal.enums;

public enum UserRole {

    TEACHER("Teacher"),ADMIN("Admin"),STUDENT("Student");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
