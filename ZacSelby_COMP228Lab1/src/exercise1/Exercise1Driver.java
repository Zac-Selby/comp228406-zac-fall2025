package exercise1;

import java.time.LocalDate;

public class Exercise1Driver {
    public static void main(String[] args) {
        System.out.println("COMP 228 - Lab 1: Singers Record Demo\n");

        // Create singer1 using no-argument constructor and display defaults
        System.out.println("Default values (no-args constructor)");
        Singers singer1 = new Singers();
        System.out.println(singer1);

        // Set all values with bulk setter, and display
        System.out.println("Set all values using setAll()");
        singer1.setAll(
                101,
                "Zac Selby",
                "123 Main St, Toronto, ON",
                LocalDate.of(2003,10,1),
                3
        );
        System.out.println(singer1);

        // Change each value with individual setters
        System.out.println("Update each field using individual setters, then display with individual getters");
        singer1.setSingerId(202);
        singer1.setSingerName("Zac S.");
        singer1.setSingerAddress("444 Real Rd, Toronto, ON");
        singer1.setDateOfBirth(LocalDate.of(1999,9,9));
        singer1.setAlbumsPublished(4);

        // Display current values with getters
        System.out.println("""
               Singer ID        : %d
               Singer Name      : %s
               Singer Address   : %s
               Date of Birth    : %s
               Albums Published : %d
               """.formatted(
                       singer1.getSingerId(),
                singer1.getSingerName(),
                singer1.getSingerAddress(),
                singer1.getDateOfBirth(),
                singer1.getAlbumsPublished()
        ));
    }
}
