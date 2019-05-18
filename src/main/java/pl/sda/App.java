package pl.sda;

import pl.sda.json.JsonParser;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        JsonParser parser = new JsonParser();
        parser.readJson("/home/michal/SDA/Java15/Projekty/SDA_J15_Files/src/main/resources/person.json");

    }
}
