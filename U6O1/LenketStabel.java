package U6O1;
public class LenketStabel {
    private class Node {
        char data;
        Node neste;

        Node(char data) {
            this.data = data;
            this.neste = null;
        }
    }

    private Node topp;

    public LenketStabel() {
        topp = null;
    }

    public void leggPå(char data) {
        Node nyNode = new Node(data);
        nyNode.neste = topp;
        topp = nyNode;
    }

    public char taAv() {
        if (erTom()) {
            throw new IllegalStateException("Stabel tom");
        }
        char data = topp.data;
        topp = topp.neste;
        return data;
    }

    public boolean erTom() {
        return topp == null;
    }
}
