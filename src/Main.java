import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        File fichero = new File("/home/serdjd_05/datos.bin");
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
            
            ArrayList<Cliente> lista = new ArrayList<>();
            Cliente clients = new Cliente();
            String ape1,ape2;
            switch(exit) {
                

                case 1:
                while(lectura_objetos.available()>0){
                    lista.add((Cliente) lectura_objetos.readObject());
                }
                for(int i = 0; i<lista.size();i++){
                    System.out.println(lista.get(i));
                }
                break;

                case 2:
                System.out.print("Primer apellido:");
                ape1 = leer.nextLine();
                System.out.print("Segundo apellido");
                ape2 = leer.nextLine();
                while(lectura_objetos.available()>0){
                    clients = (Cliente) lectura_objetos.readObject();
                    if(clients.getApellido_1().equals(ape1)){
                        if(clients.getApelido_2().equals(ape2)){
                            clients.toString();
                            break;
                        }
                    }
                }
                if(lectura_objetos.available()==0){
                    System.out.println("No hay ningún cliente con esos apellidos");
                }
                break;

                case 3:
                FileOutputStream escrituraReacer = new FileOutputStream(fichero);
                ObjectOutputStream escritura_objetosReacer = new ObjectOutputStream(escrituraReacer);
                ArrayList<Cliente> list = new ArrayList<>();
                while(lectura_objetos.available()>0){
                    list.add((Cliente) lectura_objetos.readObject());
                }
                
                System.out.print("Nombre: ");
                String nomb = leer.nextLine();
                System.out.print("Primer apellido:");
                ape1 = leer.nextLine();
                System.out.print("Segundo apellido");
                ape2 = leer.nextLine();
                for(int i=0; i<list.size();i++){
                    if(lista.get(i).getNombre().equals(nomb)){
                        if(lista.get(i).getApellido_1().equals(ape1)){
                            if(lista.get(i).getApelido_2().equals(ape2)){
                                System.out.print("Nueva edad:");
                                lista.get(i).setEdad(leer.nextInt());

                                System.out.print("Nueva dirección: ");
                                lista.get(i).setDireccion(leer.nextLine());

                                escritura_objetosReacer.writeObject(list);
                                break;
                            }   
                        }
                    }
                    if(i==list.size()){
                    System.out.println("No existe ese cliente");
                    break;
                    }
                }
                escrituraReacer.close();
                escritura_objetosReacer.close();
                break;

                case 4:
                System.out.print("Nombre: ");
                clients.setNombre(leer.nextLine());
                System.out.print("Primer apellido: ");
                clients.setApellido_1(leer.nextLine());
                System.out.print("Segundo apellido: ");
                clients.setApelido_2(leer.nextLine());
                System.out.print("Dirección: ");
                clients.setDireccion(leer.nextLine());
                leer.nextLine();
                System.out.print("Edad: ");
                clients.setEdad(leer.nextInt());
                escritura_objetos.writeObject(clients);
                break;

                default: 
                    System.out.println("Número no valido");
                break;
                 
            }
            leer.close();
        }
        escritura_objetos.close();
        escritura.close();
        lectura.close();
        lectura_objetos.close();
    }


}
