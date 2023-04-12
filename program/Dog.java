package program;
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
        commands = new String[]{"bark", "fetch", "roll over"};
    }

    @Override
    public String getType() {
        return "Dog";
    }
    
}
