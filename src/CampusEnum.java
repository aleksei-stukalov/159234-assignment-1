public enum CampusEnum {
    AUCKLAND("Auckland"),
    PN("PN");

    private final String value;

    private CampusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
