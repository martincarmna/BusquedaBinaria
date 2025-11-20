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
     // Algoritmo de búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int dato) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arreglo[medio] == dato) {
                return medio; 
            }

            if (arreglo[medio] < dato) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }