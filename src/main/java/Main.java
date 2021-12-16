public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Petr", "Petrov");
        System.out.println(person1.toString());

        Person person4 = new PersonBuilder()
                .withName("Sasha")
                .withSurname("Smirnov")
                .withAge(12)
                .build();

        person4.setAddress("Moscow");

        person4.happyBirthday();

        System.out.println(person4.toString());

        Person daughter = person4.newChildBuilder("Masha",3)
                .build();
        System.out.println(daughter.toString());
    }
}
