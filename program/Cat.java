public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
        commands = new String[]{"jump", "scratch", "meow"};
    }

    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public String toString() {
        return getType() + " " + name;
    }
    
}
