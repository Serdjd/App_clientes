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
            leer.close();
        }
        int exit = 9;
        while(exit!=0){
            System.out.println("Mostrar listado completo--> 1\nBuscar cliente por apellidos--> 2\nActualizar los datos de un cliente (solo dirección y edad)--> 3\nAñadir cliente--> 4\nExit--> 0");
            Scanner leer = new Scanner(System.in);
            exit=leer.nextInt();
            switch(exit){
                ArrayList<Cliente> lista = new ArrayList<>();

                case 1:
                while(lectura_objetos.available()>0){
                    lista.add(lectura_objetos.readObject());
                }
                for(int i = 0; i<lista.size();i++){
                    System.out.println(lista.get(i));
                }
                break;

                case 2:
                Cliente clients = new Clientes();
                System.out.print("Primer apellido:");
                String ape1 = leer.nextLine();
                System.out.print("Segundo apellido");
                String ape2 = leer.nextLine();
                while(lectura_objetos.available()>0){
                    clients = lectura_objetos.readObject();
                    if(clients.getApellido_1().equals(ape1)){
                        if(clients.getApelido_2().equals(ape2)){
                            clients.toString();
                            break;
                        }
                    }
                }
                if(lectura_objetos.available()==0){
                    System.out.prinln("No hay ningún cliente con esos apellidos");
                }
                break;
                case default: 
                break;

                case 3:
                
                
            }
        }
        
    }


}
