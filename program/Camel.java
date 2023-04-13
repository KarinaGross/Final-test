public class Camel extends Animal {

    public Camel(String name, int age) {
        super(name, age);
        commands = new String[]{"плеваться", "долго не пить"};
    }

    @Override
    public String getType() {
        return "Camel";
    }
    
    @Override
    public String toString() {
        return getType() + " " + name;
    }
}
