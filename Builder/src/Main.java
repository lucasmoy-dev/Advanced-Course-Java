import models.Person;

import static models.Person.Builder.aPerson;

public class Main {

    public static void main(String[] args) {
        Person p = aPerson()
                .withFirstname("Lucas")
                .withLastname("Moy")
                .withPhone("123123123")
                .withEmail("lucasmoy@yahoo.com")
                .build();


        if ("Moy".equals(p.getLastname())) {
            System.out.println("Yes");
        }

    }

}
