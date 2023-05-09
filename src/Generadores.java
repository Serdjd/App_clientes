import java.util.Map;
import java.util.HashMap;
public class Generadores {
    
    public static String nombre(){
        int rand_number = (int) Math.floor(Math.random()*7+1);
        Map<Integer,String> nombres = new HashMap<>();
        nombres.put(1,"Pepe");
        nombres.put(2,"Javier");
        nombres.put(3,"Juan Paco");
        nombres.put(4,"Manuel");
        nombres.put(5,"Raul");
        nombres.put(6,"Alex");
        nombres.put(7,"Andrés");
        return nombres.get(rand_number);
    }

    public static String Apellido(){
        int rand_apellido = (int) Math.floor(Math.random()*10+1);
        Map<Integer,String> apellidos = new HashMap<>();
        apellidos.put(1,"Gonzalez");
        apellidos.put(2,"Muñoz");
        apellidos.put(3,"Perez");
        apellidos.put(4,"Canovas");
        apellidos.put(5,"Gutierrez");
        apellidos.put(6,"Sotos");
        apellidos.put(7,"Arriza");
        apellidos.put(8, "García");
        apellidos.put(8,"Martinez");
        apellidos.put(10,"Fernandez");
        return apellidos.get(rand_apellido);
    }  

    public static int Edad(){
        return (int) Math.floor(Math.random()*60+18);
    }

    public static String direccion(){
        int rand_direc = (int) Math.floor(Math.random()*7+1);
        Map<Integer,String> calles = new HashMap<>();
        calles.put(1,"Pedro Salinas");
        calles.put(2,"Guadalquivir");
        calles.put(3,"Corredera");
        calles.put(4,"Cataño");
        calles.put(5,"Reyes Católicos");
        calles.put(6,"Constitución");
        calles.put(7,"Rey de España");
        return calles.get(rand_direc);
    }
}
