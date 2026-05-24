package Constant;

public enum StatusEnum {
    ENABLE("Enabled"),
    DISABLE("Disabled");

    private final String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}