import static org.junit.Assert.*;

public class PruebasAgregar {

    @org.junit.Test
    public void add() {
        BinarySearchTree arbol = new BinarySearchTree();
        ComparableAssociation valor = new ComparableAssociation("prueba","Sisi");
        arbol.add(valor);

        assertEquals(1,arbol.size());
    }



}