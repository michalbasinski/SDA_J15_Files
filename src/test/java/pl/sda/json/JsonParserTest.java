package pl.sda.json;

import org.junit.Test;
import pl.sda.model.Person;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonParserTest {

    @Test
    public void shouldCreateCorrectObjectFromJson() throws IOException {
        //given
        String filePath = this.getClass().getClassLoader()
                .getResource("person.json").getPath();
        JsonParser parser = new JsonParser();

        //when
        Person result = parser.readJson(filePath);

        //then
        assertEquals("Jan", result.getName());
        assertEquals("Kowalski", result.getLastName());
    }

}