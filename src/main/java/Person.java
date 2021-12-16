import java.lang.reflect.InaccessibleObjectException;

public class Person {
    protected  String name;
    protected  String surname;
    protected String address;
    protected int age;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName(){ return name;}

    public String getSurname(){
        return surname;
    }

    public int getAge() { /*...*/
        return age;
    }

    public String getAddress() { /*...*/
        return address;
    }

    public void setAddress(String addressLine) {
        this.address = addressLine;
    }

    public void happyBirthday() {
        try {
            if (age == 0)
                throw new InaccessibleObjectException("Невозможно применить метод");
        } catch (InaccessibleObjectException e){
            e.printStackTrace();
        }
        age = age + 1;
    }

    public boolean hasAge() {return age != 0; }

    public boolean hasAddress() {return address == null; }

    public PersonBuilder newChildBuilder(String name, int age) {
        PersonBuilder child = new PersonBuilder();
        child.withName(name)
                .withSurname(getSurname())
                .withAddress(getAddress())
                .withAge(age);
        System.out.println(getName() + " есть ребенок: " + name);
        return child;
    }

    @Override
    public String toString(){
        return "Person: " +
                "\n     Name:   " + getName() +
                "\n     Surname:" + getSurname() +
                "\n     Age:    " + getAge() +
                "\n     Address:" + getAddress();
    }

}