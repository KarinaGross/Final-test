import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registry {
    static Scanner input = new Scanner(System.in);
    static List<Animal> listAnimals = new ArrayList<>();

    public static void addAnimal() {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Кот");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осёл");
        System.out.println("-------- ");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("Введите имя: ");
        String name = input.nextLine();

        System.out.println("Введите возраст: ");
        int age = input.nextInt();
        input.nextLine();

        Animal animal;

        if (choice == 1 && name != null) {
            animal = new Cat(name, age);
        } else if (choice == 2 && name != null) {
            animal = new Dog(name, age);
        } else if (choice == 3 && name != null) {
            animal = new Hamster(name, age);
        } else if (choice == 4 && name != null) {
            animal = new Horse(name, age);
        } else if (choice == 5 && name != null) {
            animal = new Camel(name, age);
        } else if (choice == 6 && name != null) {
            animal = new Donkey(name, age);
        } else {
            System.out.println("Некорректный ввод");
            return;
        }

        listAnimals.add(animal);
        System.out.println("Животное добавлено!");
    }

    public static void listAnimals() {
        if (listAnimals.size() == 0) {
            System.out.println("В реестре нет животных");
        } else {
            System.out.println("Реестр животных:");
            for (Animal animal : listAnimals) {
                System.out.println("- " + animal.toString());
            }
        }
    }

    private static Animal findAnimalByName(String name) {
        for (Animal animal : listAnimals) {
            if (animal.name.equals(name)) {
                return animal;
            }
        }

        return null;
    }

    public static void trainAnimal() {
        System.out.println("Введите имя животного, которое нужно обучить:");
        String name = input.nextLine();

        Animal animal = findAnimalByName(name);

        if (animal == null) {
            System.out.println("Животное с таким именем не найдено");
            return;
        }

        System.out.println("Введите новые команды через запятую:");
        String commandsString = input.nextLine();
        animal.addCommands(commandsString);

        System.out.println("Животное успешно обучено новым командам");
    }

    public static void skills() {
        input.nextLine();
        System.out.println("Введите имя животного:");
        String name = input.nextLine();
        input.nextLine();

        Animal animal = findAnimalByName(name);

        if (animal == null) {
            System.out.println("Животное с таким именем не найдено");
            return;
        }
        animal.getCommands();
            
    }
    
}
