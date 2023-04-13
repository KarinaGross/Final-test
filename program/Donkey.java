public class Donkey extends Animal {

    public Donkey(String name, int age) {
        super(name, age);
        commands = new String[]{"возить тяжелые повозки"};
    }

    @Override
    public String getType() {
        return "Donkey";
    }
    
    @Override
    public String toString() {
        return getType() + " " + name;
    }
}
