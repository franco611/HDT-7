
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedWriter;

class Main {
    public static void main(String[]args){

        int res = 0;
        int res2 = 0;
        String idioma = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido al traductor ");
        System.out.println("Indique el idioma del texto que desea traducir");
        System.out.println("[ 1 ] Ingles.");
        System.out.println("[ 2 ] Español.");
        System.out.println("[ 3 ] Frances.");

        while(true){
            try{
                res = s.nextInt();

                if(res>=1 && res<=3){
                    break;
                }else{
                    System.out.println("Ingrese valores entre 1 y 3 !");
                }
            }catch(Exception e){
                System.out.println("Ingrese valores numericos ! ! !");
            }
        }

        System.out.println("Indique el idioma al que se traducira el texto");
        if(res==1){
            System.out.println("[ 1 ] Español.");
            System.out.println("[ 2 ] Frances.");
        }else if(res==2){
            System.out.println("[ 1 ] Ingles.");
            System.out.println("[ 2 ] Frances.");
        }else{
            System.out.println("[ 1 ] Ingles.");
            System.out.println("[ 2 ] Español.");
        }

        while(true){
            try{
                res2 = s.nextInt();

                if(res2>=1 && res2<=2){
                    break;
                }else{
                    System.out.println("Ingrese valores entre 1 y 2 !");
                }
            }catch(Exception e){
                System.out.println("Ingrese valores numericos ! ! !");
            }
        }

        if(res==1){
            if(res2==1){
                idioma = "español";
            }else{
                idioma = "frances";
            }
        }else if(res==2){
            if(res2==1){
                idioma = "ingles";
            }else{
                idioma = "frances";
            }
        }else if(res==3){
            if(res2==1){
                idioma = "ingles";
            }else{
                idioma = "español";
            }
        }


        BinarySearchTree arbol = new BinarySearchTree();
        String frase ="";


        try{
            File file = new File("diccionario.txt");
            Scanner input = new Scanner (file);
            while(input.hasNextLine()){
                String dato = input.nextLine();
                String[] partes = dato.split(",");
                String ingles = partes[0];
                String español = partes[1];
                String frances = partes[2];
                ComparableAssociation temp;
                if(res==1){
                     temp = new ComparableAssociation(ingles,partes);
                }else if(res==2){
                     temp = new ComparableAssociation(español,partes);
                }else{
                     temp = new ComparableAssociation(frances,partes);
                }

                arbol.add(temp);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Impreso inorder");
        System.out.println(arbol.iterator());

        try{
            File file = new File("texto.txt");
            Scanner input = new Scanner (file);
            while(input.hasNextLine()){
                String dato = input.nextLine();
                frase = dato;
            }
            input.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        String[] partes = frase.split(" ");
        String nuevo ="";
        for (int i=0; i<=partes.length-1; i++){
            String palabra = (partes[i]).toLowerCase();
            ComparableAssociation n = new ComparableAssociation(palabra);
            if(arbol.contains(n)){
                BinaryTree temp = arbol.locate(arbol.root,n);
                ComparableAssociation tra = (ComparableAssociation) temp.value();
                String[] traduciones = (String[]) tra.getValue();
                if(idioma.equals("ingles")){
                    nuevo += traduciones[0];
                    nuevo += " ";
                }else if (idioma.equals("español")){
                    nuevo += traduciones[1];
                    nuevo += " ";
                }else if (idioma.equals("frances")){
                    nuevo += traduciones[2];
                    nuevo += " ";
                }
            }else{
                nuevo += partes[i];
                nuevo += " ";
            }

        }
        System.out.println(" ");
        System.out.println("La traduccion a "+idioma+" seria:");
        System.out.println(nuevo);


    }
}
