package pl.sda.producers;

import org.json.JSONObject;
import pl.sda.model.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JSONProducer {

    public void write(Person person, String filePath) {
        JSONObject jsonToSave = new JSONObject();
        jsonToSave.put("name",person.getName());
        jsonToSave.put("lastName", person.getLastName());

        JSONObject addressToSave = new JSONObject();
        addressToSave.put("city", person.getAddress().getCity());
        addressToSave.put("street", person.getAddress().getStreet());
        addressToSave.put("postalCode", person.getAddress().getPostalCode());

        jsonToSave.put("address", addressToSave);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(jsonToSave.toString(2));
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
