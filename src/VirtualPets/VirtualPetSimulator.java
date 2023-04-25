package VirtualPets;

import java.util.Scanner;

public class VirtualPetSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Virtual Pet Simulator!");
        System.out.print("Enter your pet's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your pet's age: ");
        int age = scanner.nextInt();
        VirtualPet pet = new VirtualPet(name, age);
        while (!pet.isSick() && !pet.isSad()) {
            pet.printStatus();
            System.out.println("Choose an action:");
            System.out.println("1. Feed");
            System.out.println("2. Drink");
            System.out.println("3. Play");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    pet.feed();
                    System.out.println(pet.getName() + " ate some food.");
                    break;
                case 2:
                    pet.drink();
                    System.out.println(pet.getName() + " drank some water.");
                    break;
                case 3:
                    pet.play();
                    System.out.println(pet.getName() + " played with you.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (pet.isSick()) {
            System.out.println(pet.getName() + " became sick and went to the vet.");
        } else {
            System.out.println(pet.getName() + " became sad and needs some love.");
        }

        scanner.close();
    }
}