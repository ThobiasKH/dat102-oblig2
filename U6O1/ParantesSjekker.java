package U6O1;
public class ParantesSjekker {
    private boolean erStartParantes(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    private boolean erSluttParantes(char c) {
        return c == '}' || c == ']' || c == ')';
    }

    private boolean erParantesPar(char start, char slutt) {
        return (start == '{' && slutt == '}') ||
               (start == '[' && slutt == ']') ||
               (start == '(' && slutt == ')');
    }

    public boolean sjekkParanteser(String s) {
        LenketStabel stabel = new LenketStabel();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (erStartParantes(c)) {
                stabel.leggPå(c);
            }
            else if (erSluttParantes(c)) {
                if (stabel.erTom() || !erParantesPar(stabel.taAv(), c)) {
                    return false;
                }
            }
        }

        return stabel.erTom();
    }

}
