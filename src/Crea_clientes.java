import java.util.ArrayList;

public class Crea_clientes {
    public static ArrayList<Cliente> lista_generada (int cantidad_clientes){
        ArrayList<Cliente> lista = new ArrayList<>();
        for(int i=0;i<cantidad_clientes;i++){
            Cliente pagador = new Cliente(Generadores.nombre(), Generadores.Apellido(), Generadores.Apellido(), Generadores.Edad(), Generadores.direccion());
            lista.add(pagador);
        }
        return lista;
    }
}
  