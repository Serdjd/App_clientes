import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {
    public static void main(String[] args) throws Exception{
        File fichero = new File("datos.bin");
        FileOutputStream escritura = new FileOutputStream(fichero, true);
        FileInputStream lectura = new FileInputStream(fichero);
        ObjectOutputStream escritura_objetos = new ObjectOutputStream(escritura);
        ObjectInputStream lectura_objetos = new ObjectInputStream(lectura);
    }


}
