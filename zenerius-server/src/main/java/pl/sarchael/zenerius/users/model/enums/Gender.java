package pl.sarchael.zenerius.users.model.enums;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private String code;

    private Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static Gender getByCode(String code) {
        for (Gender g : Gender.values())
            if (g.getCode().equals(code))
                return g;
        return null;
    }
}
