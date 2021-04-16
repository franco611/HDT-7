import static org.junit.Assert.*;

public class PruebasBuscar {

    @org.junit.Test
    public void contains() {
        BinarySearchTree arbol = new BinarySearchTree();
        ComparableAssociation valor = new ComparableAssociation("prueba","Sisi");
        arbol.add(valor);
        ComparableAssociation val = new ComparableAssociation("prueba");

        assertEquals(true, arbol.contains(val));
    }



}