public class Hamster extends Animal {

    public Hamster(String name, int age) {
        super(name, age);
        commands = new String[]{"шуршать", "прятаться"};
    }

    @Override
    public String getType() {
        return "Hamster";
    }
    
    @Override
    public String toString() {
        return getType() + " " + name;
    }
}
