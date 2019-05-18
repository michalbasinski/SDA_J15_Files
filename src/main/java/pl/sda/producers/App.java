package pl.sda.producers;

import pl.sda.model.Address;
import pl.sda.model.Person;

public class App {
    //Przykład generowania obiektu i zapisanie go do pliku
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Michał");
        person.setLastName("Basiński");

        Address address = new Address();
        address.setCity("Poznań");
        address.setStreet("Rynek Jeżycki 1");
        address.setPostalCode("60-123");
        person.setAddress(address);

        JSONProducer producer = new JSONProducer();

        //Zmieńcie ścieżkę na odpowiednią dla Waszych maszyn
        producer.write(person, "/home/michal/person_demo.json");
    }
}
