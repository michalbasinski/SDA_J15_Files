package pl.sda.json;

import org.json.JSONObject;
import pl.sda.model.Address;
import pl.sda.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class JsonParser {

    private static final String UTF_8 = "UTF-8";

    Person readJson(String filePath) throws IOException {

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String content = new String(bytes, UTF_8);

        JSONObject json = new JSONObject(content);

        Person person = new Person();
        String name = json.getString("name");
        String lastName = json.getString("lastName");

        JSONObject address =
                new JSONObject(json.get("address").toString());
        String city = address.getString("city");
        String street = address.getString("street");
        String postalCode = address.getString("postalCode");
        Address addressObject = new Address();
        addressObject.setCity(city);
        addressObject.setStreet(street);
        addressObject.setPostalCode(postalCode);

        person.setName(name);
        person.setLastName(lastName);
        person.setAddress(addressObject);

        return person;
    }
}