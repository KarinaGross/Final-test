import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {
    String name;
    int age;
    String[] commands;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getType();

    public void getCommands() {
        System.out.println(getType() + " " + name + " умеет: \n");
        for (String command : commands) {
            System.out.println("- " + command + "\n");
        }

    }

    public void addCommands(String newCommands) {
        List<String> commandList = new ArrayList<>(Arrays.asList(commands));
        commandList.addAll(Arrays.asList(newCommands.split(", ")));
        commands = commandList.toArray(new String[commandList.size()]);
    }

    @Override
    public String toString() {
        return getType() + " " + name;
    }
    
}