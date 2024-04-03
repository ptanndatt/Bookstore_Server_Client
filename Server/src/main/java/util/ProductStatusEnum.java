package util;

public enum ProductStatusEnum {
    DANG_KINH_DOANH(1, "Đang kinh doanh"),
    NGUNG_KINH_DOANH(0, "Ngừng kinh doanh");

    private final int value;
    private final String description;

    ProductStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static ProductStatusEnum getById(int value) {
        for (ProductStatusEnum e : values()) {
            if (e.value == value) {
                return e;
            }
        }
        return DANG_KINH_DOANH;
    }

    public static ProductStatusEnum getByName(String name) {
        for (ProductStatusEnum e : values()) {
            if (e.name().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return DANG_KINH_DOANH;
    }
}
