public class Main {
    public static void main(String[] args) {
        Person men = new PersonBuilder()
                .setName("Алексей")
                .setSurname("Перов")
                .setAge(24)
                .setAddress("Скопин")
                .build();

        Person daughter = men.newChildBuilder()
                .setName("Валя")
                .build();

        System.out.println(men);
        System.out.println(daughter);

        men.happyBirthday();
        daughter.happyBirthday();

        System.out.println();
        System.out.println(men);
        System.out.println(daughter);

        try {
            new PersonBuilder()
                    .setAge(31)
                    .setAddress("Вологда")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setName("Максим")
                    .setSurname("Растеряев")
                    .setAge(-10)
                    .setAddress("Балашиха")
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
