import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class SerializationDemo {

    public void serialize(List<Participant> pList, String fileName) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(pList);

        } catch (IOException ex) {
            System.out.println("a problem accured during serialization \n"
                    + ex.getMessage());
        }
    }

    public List<Participant> deserialize(String fileName) {
        List<Participant> pList = null;

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            pList = (List<Participant>) in.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("a problem accured deserializing %s\n" + fileName);
            System.out.println(ex.getMessage());
        }

        return pList;
    }
}