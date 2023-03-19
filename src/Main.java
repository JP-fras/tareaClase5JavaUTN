import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Scanner tomarParametros = new Scanner(System.in);
        int[] valoresDelUsuario = new int[3];
        System.out.println("Ingrese el primer valor: ");
        valoresDelUsuario[0] = Integer.parseInt(tomarParametros.nextLine());
        System.out.println("Ingrese el segundo valor: ");
        valoresDelUsuario[1] = Integer.parseInt(tomarParametros.nextLine());
        System.out.println("Ingrese el tercer valor: ");
        valoresDelUsuario[2] = Integer.parseInt(tomarParametros.nextLine());
        System.out.println("Ingrese la letra \"A\" si quiere ordenarlos de forma ascendente o la letra \"D\" si quiere ordenarlos de manera descendente");
        String ascedenteOdescendente = tomarParametros.nextLine();
        if (Objects.equals(ascedenteOdescendente, "A")) {
            ordenarMenorAMayor(valoresDelUsuario);
            for (int valor : valoresDelUsuario) {
                System.out.println(valor);
            }
        } else if (Objects.equals(ascedenteOdescendente, "D")){
            ordenarMayorAMenor(valoresDelUsuario);
            for (int valor : valoresDelUsuario) {
                System.out.println(valor);
            }
        }
        System.out.println("Ingrese \"M\" si quiere multiplicar o ingrese \"S\" si quiere sumar los numeros del archivo");
        String sumaOmultiplicacion = tomarParametros.nextLine();
        if (Objects.equals(sumaOmultiplicacion, "S")) {
            System.out.println(suma(leerArchivo()));
        } else if (Objects.equals(sumaOmultiplicacion, "M")){
            System.out.println(multiplicacion(leerArchivo()));
        }
    }


    public static void ordenarMayorAMenor(int[] valoresDelUsuario) {
        for (int i = 0; i < valoresDelUsuario.length; i++) {
            for (int j = 0; j < valoresDelUsuario.length - 1; j++) {
                if (valoresDelUsuario[j] < valoresDelUsuario[j + 1]) {
                    int aux = valoresDelUsuario[j];
                    valoresDelUsuario[j] = valoresDelUsuario[j + 1];
                    valoresDelUsuario[j + 1] = aux;
                }
            }
        }
    }

    public static void ordenarMenorAMayor(int[] valoresDelUsuario) {
        for (int i = 0; i < valoresDelUsuario.length; i++) {
            for (int j = 0; j < valoresDelUsuario.length - 1; j++) {
                if (valoresDelUsuario[j] > valoresDelUsuario[j + 1]) {
                    int aux = valoresDelUsuario[j];
                    valoresDelUsuario[j] = valoresDelUsuario[j + 1];
                    valoresDelUsuario[j + 1] = aux;
                }
            }
        }
    }

    public static String leerArchivo() throws  java.io.IOException {
        String archivoLeido = "C:\\Users\\Pc\\Documents\\Tareas\\archivoDado.txt";
        String linea = Files.readString(Paths.get(archivoLeido));
        return linea;
    }

    public static int suma(String archivoLeido) {
        int sumaTotal = 0;
        for (int i = 0; i < archivoLeido.length();i++) {
            sumaTotal = sumaTotal + (Character.getNumericValue(archivoLeido.toCharArray()[i]));
        }
        return sumaTotal;
    }

    public static int multiplicacion(String archivoLeido) {
        int multiplicaciomTotal = 0;
        int aux = 0;
        for (int i = 0; i < archivoLeido.length();i++) {
            aux = i;
            multiplicaciomTotal = multiplicaciomTotal + (aux * (Character.getNumericValue(archivoLeido.toCharArray()[i])));
        }
        return multiplicaciomTotal;
    }
}
