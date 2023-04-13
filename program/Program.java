import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean process = true;
        while (process) {
            System.out.println("Реестр животных");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список животных");
            System.out.println("3. Обучить животное");
            System.out.println("4. Узнать количество животных");
            System.out.println("5. Посмотреть навыки");
            System.out.println("6. Выход");
            System.out.print("-------- ");
            
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1) {
                Registry.addAnimal();
                Counter.add();
            } else if (choice == 2) {
                Registry.listAnimals();
            } else if (choice == 3) {
                Registry.trainAnimal();
            } else if (choice == 6) {
                process = false;
            } else if (choice == 4) {
                System.out.println(Counter.count);
            } else if (choice == 5) {
                Registry.skills();
            } else {
                System.out.println("Некорректный ввод");
            }
            System.out.println();
        }
    }
}
