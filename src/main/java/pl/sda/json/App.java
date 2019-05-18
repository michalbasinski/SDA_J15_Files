package pl.sda.json;

import pl.sda.model.Person;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        JsonParser parser = new JsonParser();

        Person person = parser.readJson("/home/michal/SDA/Java15/Projekty/SDA_J15_Files/src/main/resources/person.json");
    }

}
