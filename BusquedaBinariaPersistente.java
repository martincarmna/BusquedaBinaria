import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

        int[] arreglo = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arreglo[i] = lista.get(i);
        }
        return arreglo;
    }

    // Búsqueda binaria
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

    public static void main(String[] args) {

        String ruta = "C://archivos/numeros.txt";

        int[] numeros = leerArchivo(ruta);

        // ORDENAR para poder aplicar búsqueda binaria
        Arrays.sort(numeros);

        // Mostrar números ordenados
        System.out.println("=== Números ordenados ===");
        for (int n : numeros) {
            System.out.println(n);
        }

        int buscar = 45; // <-- cambia el número a buscar

        int resultado = busquedaBinaria(numeros, buscar);

        if (resultado != -1) {
            System.out.println("Número encontrado en el índice ordenado: " + resultado);
        } else {
            System.out.println("Número no encontrado.");
        }
    }
}
