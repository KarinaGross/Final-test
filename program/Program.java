package program;
import java.util.Scanner;

import Registry;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean process = true;
        while (process) {
            System.out.println("Реестр животных");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список животных");
            System.out.println("3. Обучить животное");
            System.out.println("4. Выход");
            System.out.print("-------- ");
            
            int choice = input.nextInt();
            
            if (choice == 1) {
                Registry.addAnimal();
            } else if (choice == 2) {
                Registry.listAnimals();
            } else if (choice == 3) {
                Registry.trainAnimal();
            } else if (choice == 4) {
                process = false;
            } else {
                System.out.println("Некорректный ввод");
            }
            // switch (choice) {
            //     case 1:
            //         Registry.addAnimal();
            //         break;
            //     case 2:
            //         Registry.listAnimals();
            //         break;
            //     case 3:
            //         Registry.trainAnimal();
            //         break;
            //     case 4:
            //         System.exit(0);
            //         break;
            //     default:
            //         System.out.println("Invalid choice");
            //         break;
            // }
        }
    }
}
