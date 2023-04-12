package program;
public class Horse extends Animal {

    public Horse(String name, int age) {
        super(name, age);
        commands = new String[]{"бежать рысью", "ржать"};
    }

    @Override
    public String getType() {
        return "Horse";
    }
    
}
