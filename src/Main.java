
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedWriter;

class Main {
    public static void main(String[]args){



        int res = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido lector de cartas ");
        System.out.println("Seleccione la implementacion que desea utizar para el stack: ");
        System.out.println("[ 1 ] HashMap.");
        System.out.println("[ 2 ] TreeMap.");
        System.out.println("[ 3 ] LinkedHashMap.");

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


        try{
            File file = new File("diccionario.txt");
            Scanner input = new Scanner (file);
            while(input.hasNextLine()){
                String dato = input.nextLine();
                String[] partes = dato.split(",");
                String ingles = partes[0];
                String español = partes[1];
                String frances = partes[2];

            }

        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
