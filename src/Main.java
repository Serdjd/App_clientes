import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        File fichero = new File("datos.bin");
        if(!fichero.exists()){
            System.out.println("El archivo no existe");
            System.exit(0);
        }
        FileOutputStream escritura = new FileOutputStream(fichero, true);
        FileInputStream lectura = new FileInputStream(fichero);
        ObjectOutputStream escritura_objetos = new ObjectOutputStream(escritura);
        ObjectInputStream lectura_objetos = new ObjectInputStream(lectura);
        if(lectura.available()==0){
            Scanner leer = new Scanner(System.in);
            System.out.print("Número de clientes: ");
            ArrayList<Cliente> lista = new ArrayList<>();
            lista.addAll(Crea_clientes.lista_generada(leer.nextInt()));
            escritura_objetos.writeObject(lista);
        }

        
    }


}
