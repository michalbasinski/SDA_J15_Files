package pl.sda.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class JsonJacksonParser {

    private static final String UTF_8 = "UTF-8";

    Person readJson(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String content = new String(bytes, UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Person.class);
    }

}