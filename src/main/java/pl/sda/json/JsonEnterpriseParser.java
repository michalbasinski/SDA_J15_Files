package pl.sda.json;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.model.Address;
import pl.sda.model.EnterprisePerson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class JsonEnterpriseParser {

    private static final String UTF_8 = "UTF-8";

    EnterprisePerson readJson(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String content = new String(bytes, UTF_8);

        JSONObject json = new JSONObject(content);

        //Lista przechowująca obiekty klasy Address zbudowane na bazie listy z JSONa
        List<Address> parsedAddresses = new ArrayList<>();

        //Pobranie z JSONa tablicy adresów
        JSONArray addresses = json.getJSONArray("addresses");
        for (int i = 0; i < addresses.length(); i++) {
            Object addressRaw = addresses.get(i);
            JSONObject addressJSON = new JSONObject(addressRaw.toString());
            Address parsedAddress = new Address();
            parsedAddress.setCity(addressJSON.getString("city"));
            parsedAddress.setStreet(addressJSON.getString("street"));
            parsedAddress.setPostalCode(addressJSON.getString("postalCode"));
            parsedAddresses.add(parsedAddress);
        }
        EnterprisePerson person = new EnterprisePerson();
        person.setAddresses(parsedAddresses);
        return person;
    }
}
