import java.util.Scanner;

public class notas {

     
    public static double [][]crearMatriz (int filas,int columnas){
        double [][]matriz = new double[filas][columnas];
        return matriz;
    } 
    
    static double []crearVector(int tamano){
        double vector[] = new double[tamano];
        return vector;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        String usuario = "usuario";
        
        System.out.println("Ingrese la cantidad de materias");
        int cantidadMaterias = scanner.nextInt();
        //vector unidimencional -> para las filas 
        String[] materias = new String[cantidadMaterias]; //aqui van las materias
     
        for (int i = 0; i < materias.length; i++) {
            System.out.println("Ingrese la materia " + (i+1));
            materias[i] = scanner.next();
            
        }
        
        int cantidadNotas = 3;

        //entrada por teclado cantidad de notas (dato para el tamano de las columnas)
        //asignacion de los tamanos de filas y columnas de las 2 matrices.
        
        double notas[][] = crearMatriz(cantidadMaterias,cantidadNotas); //notas
        double porcentajes[][] = crearMatriz(cantidadNotas, cantidadNotas);//porcentajes
        
        double promedioMateria[] = crearVector(cantidadNotas);
        double sumaNotaFinal = 0.0;
        double promedioSemestre = 0;

        //for para cargar
        for (int f = 0; f < materias.length; f++) { //filas
            System.out.println("Ingrese la cantidad de notas de la materia " + materias[f]);
            cantidadNotas = scanner.nextInt();

            System.out.println("la materia " + materias[f]); //                ->materias[ posicion f];
            for (int c = 0; c < cantidadNotas; c++) { //columnas
                //notas
                System.out.println("Ingrese la nota: " + c);
                notas[f][c] = scanner.nextDouble();
                //porcentajes
                System.out.println(" ingrese el porcentaje de la nota: " + c);
                porcentajes[f][c] = scanner.nextDouble();
                // promedio[f][c]+=(matriz[f][c]*matriz2[f][c])/100;
                //     sumaNotaFinal=sumaNotaFinal + (matriz[f][c]*matriz2[f][c]);
            }
        }
        //for para recorrer
        System.out.println(usuario);
        for (int f = 0; f < cantidadMaterias; f++) { //filas
            System.out.println("las notas de la materia " + materias[f]);
            for (int c = 0; c < cantidadNotas; c++) { // columnas                   
                //System.out.println("Nota :" + c + " " + matriz[f][c]); //notas   
                //System.out.println("Porcentaje :" + c + " " + matriz2[f][c]); //porcentajes
                sumaNotaFinal += (notas[f][c] * porcentajes[f][c]) / 100;  //sumar notas de una materia
            }
            promedioMateria[f] = sumaNotaFinal; // guardar sumatoria de notas de una materia en cada posicion del arreglo.
            System.out.println("El promedio la materia " + materias[f] + " es " + promedioMateria[f]);
            promedioSemestre += promedioMateria[f]; //sumatoria del promedio de cada materia
            sumaNotaFinal = 0.0;

        }
        System.out.println("Promedio del semestre " + promedioSemestre / cantidadMaterias); //promedio del semestre
    }
}
