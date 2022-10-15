import java.util.OptionalInt;


public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("У человека должны быть имя и фамилия.");
        } else if (age.isPresent()) {
            if (age.getAsInt() >= 0) {
                return new Person(name, surname, age.getAsInt(), city);
            } else {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
        } else {
            return new Person(name, surname, city);
        }

    }
}


