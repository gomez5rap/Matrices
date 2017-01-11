package ejerciciosMatricesObjetos;

import utiles.*;

public class TestMatriz {
	/**
	 * 
	 * */
	private static Matriz matriz;
	/**
	 * 
	 * */
	private static Matriz matriz2;
	/**
	 * 
	 * */
	private static int min;
	/**
	 * 
	 * */
	private static int max;
	
	public static void main(String[] args) {
		int filas = pedir("Fila de la Matriz:");
		int columnas = pedir("Columna de la Matriz:");
		min = pedir("Minimo:");
		max = pedir("Maximo:");
		matriz= new Matriz(filas,columnas,min,max);
		matriz2 = new Matriz(filas,columnas,min,max);
		int opcion;
		do{
			Menu menu = new Menu("Menu",new String[]{"-Sumar","-Restar","-Multiplicar","-Trasponer","-Salir"});
			opcion = menu.gestionar();
			gestionarMenu(opcion);
		}while(opcion != 5 && opcion != 3 && opcion !=4);
		
	}
	
	/**
	 * 
	 * */
	private static void gestionarMenu(int opcion){
		switch(opcion){
		case 1:
			sumar();
			break;
		case 2:
			restar();
			break;
		case 3:
			multiplicar();
			break;
		case 4: 
			trasponer();
			break;
		case 5: System.out.println("Adios.");
			break;
		}
	}
	
	/**
	 * 
	 * */
	private static void trasponer() {
		System.out.println(matriz.mostrar("MATRIZ"));
		matriz.trasponer();
		System.out.println(matriz.mostrar("MATRIZ TRASPUESTA"));
	}
	
	/**
	 * 
	 * */
	private static void multiplicar() {
		System.out.println(matriz.mostrar("FACTOR1"));
		int filasDeColumnaFactor1 = Teclado.leerEntero("Indica las filas deben ser iguales que las columnas del factor1");
		int columnas = Teclado.leerEntero("Introduce las columnas");
		matriz2 = new Matriz(filasDeColumnaFactor1,columnas,min,max);
		System.out.println(matriz2.mostrar("FACTOR2"));
		Matriz multiplicacion = matriz.multiplicar(matriz2);
		System.out.println(multiplicacion.mostrar("PRODUCTO"));
	}
	
	/**
	 * 
	 * */
	private static void restar() {
		System.out.println(matriz.mostrar("MINUENDO"));
		System.out.println(matriz2.mostrar("SUSTRAENDO"));
		Matriz resta = matriz.restar(matriz2);
		System.out.println(resta.mostrar("DIFERENCIA"));
	}
	
	/**
	 * 
	 * */
	private static void sumar() {
		System.out.println(matriz.mostrar("SUMANDO1"));
		System.out.println(matriz2.mostrar("SUMANDO2"));
		Matriz suma = matriz.sumar(matriz2);
		System.out.println(suma.mostrar("RESULTADO"));
	}
	
	/**
	 * 
	 * */
	private static int pedir(String mensaje){
		return Teclado.leerEntero(mensaje);
	}
	
	
	
		
}
