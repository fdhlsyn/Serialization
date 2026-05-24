import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerializationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Participant> participants = new ArrayList<>();

        System.out.print("Masukkan jumlah participant: ");
        int jumlah = sc.nextInt();
        sc.nextLine(); // buang newline

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nParticipant ke-" + (i + 1));

            System.out.print("First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // buang newline

            participants.add(new Participant(firstName, lastName, age));
        }

        System.out.println("\nParticipants : " + participants);

        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "participantData.ser");
        System.out.println("serialization is done");

        System.out.println("\nDeserialize object...");
        List<Participant> newList = demo.deserialize("participantData.ser");

        System.out.println("New List: " + newList);

        sc.close();
    }
}