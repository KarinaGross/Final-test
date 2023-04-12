package program;
public class Hamster extends Animal {

    public Hamster(String name, int age) {
        super(name, age);
        commands = new String[]{"шуршать", "прятаться"};
    }

    @Override
    public String getType() {
        return "Hamster";
    }
    
}
