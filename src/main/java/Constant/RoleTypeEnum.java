package Constant;


public enum RoleTypeEnum {
    ESS("ESS"),
    ADMIN("Admin");
    private final String value;

    RoleTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
