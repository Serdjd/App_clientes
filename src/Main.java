import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        File fichero = new File("D:\\Datos.bin");
        if(!fichero.exists()){
            System.out.println("El archivo no existe");
            System.exit(0);
        }
        FileOutputStream escritura = new FileOutputStream(fichero);

        ObjectOutputStream escritura_objetos;
        Scanner leer = new Scanner(System.in);
        
        if(fichero.length() == 0){
            escritura_objetos = new ObjectOutputStream(escritura);
            
            System.out.print("Número de clientes: ");
            ArrayList<Cliente> lista = new ArrayList<>();
            lista.addAll(Crea_clientes.lista_generada(leer.nextInt()));
            for(int i = 0;i<lista.size();i++){
                escritura_objetos.writeObject(lista.get(i));
            }
            
            escritura_objetos.close();
            leer.nextLine();
        }
        int exit = 9;
        while(exit!=0){
            System.out.println("Mostrar listado completo--> 1\nBuscar cliente por apellidos--> 2\nActualizar los datos de un cliente (solo dirección y edad)--> 3\nAñadir cliente--> 4\nExit--> 0");
            exit=leer.nextInt();
            leer.nextLine();
            ArrayList<Cliente> lista = new ArrayList<>();
            Cliente clients = new Cliente();
            String ape1,ape2;
            switch(exit) {
                

                case 1:
                    FileInputStream lectura1 = new FileInputStream(fichero);
                    ObjectInputStream lectura_objetos1 = new ObjectInputStream(lectura1);
                
                while(lectura1.available()>0){
                    lista.add((Cliente) lectura_objetos1.readObject());
                }
                for(int i = 0; i<lista.size();i++){
                    System.out.println(lista.get(i).toString());
                }
                lectura_objetos1.close();
                lectura1.close();
                break;

                case 2:
                    boolean haycliente = false;
                    FileInputStream lectura2 = new FileInputStream(fichero);
                    ObjectInputStream lectura_objetos2 = new ObjectInputStream(lectura2);
                System.out.print("Primer apellido:");
                ape1 = leer.nextLine();
                System.out.print("Segundo apellido:");
                ape2 = leer.nextLine();
                while(lectura2.available()>0){
                    clients = (Cliente) lectura_objetos2.readObject();
                    if(clients.getApellido_1().equals(ape1)){
                        if(clients.getApelido_2().equals(ape2)){
                            System.out.println(clients.toString());
                            haycliente=true;
                            break;
                        }
                    }
                }
                if(haycliente==false){
                    System.out.println("No hay ningún cliente con esos apellidos");
                }
                lectura_objetos2.close();
                lectura2.close();
                break;

                case 3:
                    FileInputStream lectura3 = new FileInputStream(fichero);
                FileOutputStream escrituraReacer = new FileOutputStream(fichero);
                ObjectOutputStream escritura_objetosReacer = new ObjectOutputStream(escrituraReacer);
                    ObjectInputStream lectura_objetos3 = new ObjectInputStream(lectura3);
                ArrayList<Cliente> list = new ArrayList<>();
                while(lectura_objetos3.available()>0){
                    list.add((Cliente) lectura_objetos3.readObject());
                }
                System.out.print("Nombre: ");
                String nomb = leer.nextLine();
                System.out.print("Primer apellido:");
                ape1 = leer.nextLine();
                System.out.print("Segundo apellido");
                ape2 = leer.nextLine();
                for(int i=0; i<list.size();i++){
                    if(list.get(i).getNombre().equals(nomb)){
                        if(list.get(i).getApellido_1().equals(ape1)){
                            if(list.get(i).getApelido_2().equals(ape2)){
                                System.out.print("Nueva edad:");
                                list.get(i).setEdad(leer.nextInt());

                                System.out.print("Nueva dirección: ");
                                list.get(i).setDireccion(leer.nextLine());

                                //escritura_objetosReacer.writeObject(list);
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
                lectura_objetos3.close();
                lectura3.close();
                break;

                case 4:
                escritura_objetos = new ObjectOutputStream(escritura);
                
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
                
                escritura_objetos.close();

                break;

                default: 
                    System.out.println("Número no valido");
                break;

            }
        }
        leer.close();
        escritura.close();
    }


}
