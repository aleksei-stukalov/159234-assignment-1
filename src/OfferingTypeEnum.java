public enum OfferingTypeEnum {
    DISTANCE("Distance"),
    INTERNAL_AUCKLAND("Auckland"),
    INTERNAL_PN("PN");

    private final String value;

    private OfferingTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
