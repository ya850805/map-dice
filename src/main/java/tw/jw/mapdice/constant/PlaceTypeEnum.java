package tw.jw.mapdice.constant;

public enum PlaceTypeEnum {
    RESTAURANT("restaurant");

    private String value;

    PlaceTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
