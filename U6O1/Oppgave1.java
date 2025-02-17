package U6O1;

public class Oppgave1 {
    public static void main(String[] args) {
        ParantesSjekker sjekker = new ParantesSjekker();

        // Eksempel på teststrenger
        String testStreng1 = "{ [ ( ) ] }";
        System.out.println(testStreng1 + " er korrekt: " + sjekker.sjekkParanteser(testStreng1));

        String testStreng2 = "{ [ ( ) }";
        System.out.println(testStreng2 + " er korrekt: " + sjekker.sjekkParanteser(testStreng2));

        String testStreng3 = "[ ( ) ] }";
        System.out.println(testStreng3 + " er korrekt: " + sjekker.sjekkParanteser(testStreng3));

        String testStreng4 = "{ [ ( ] ) }";
        System.out.println(testStreng4 + " er korrekt: " + sjekker.sjekkParanteser(testStreng4));

        String javaprogram = """
            class HelloWorld {
                public static void main(String[] args) {
                    System.out.println("Hello World!");
                }
            }
        """;
        System.out.println("Java-program er korrekt: " + sjekker.sjekkParanteser(javaprogram));
    }
}
