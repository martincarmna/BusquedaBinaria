import java.io.*;
import java.util.ArrayList;

public class BusquedaBinariaPersistente {

    // Método para leer números desde archivo
    public static int[] leerArchivo(String ruta) {
        ArrayList<Integer> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Integer.parseInt(linea.trim()));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
            // Convertimos ArrayList a arreglo int[]
        int[] arreglo = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arreglo[i] = lista.get(i);
        }

        return arreglo;
    }