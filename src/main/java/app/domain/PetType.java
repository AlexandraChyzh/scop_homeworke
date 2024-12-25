package app.domain;

public enum PetType {

    DOG("Собака"),
    CAT("Кот"),
    PARROT("Попугай"),
    HAMSTER("Хомяк"),
    RABBIT("Кролик"),
    GUINEAPIG("Морская свинка");

    private final String description;

    PetType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
