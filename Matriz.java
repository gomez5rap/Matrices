package ejerciciosMatricesObjetos;
/**
 * Supongamos que queremos modelar una clase denominada Matriz. Queremos poder realizar las distin- tas operaciones típicas de una matriz:
 *<ul>
 *<li>Sumar matrices</li>
 *<li>Restar matrices</li>
 *<li>Multiplicar matrices</li>
 *<li>Trasponer una matriz.</li>
 *</ul>
 *En todos estos procesos está implicada al menos una matriz (estructura de filas y columnas).
 * 
 * @author Javier Ponferrada Lopez
 * @version 1.0
 * */
public class Matriz {
	/**
	 * campo vector
	 * */
	private int[][] matriz;
	
	/**
	 * constructor por defecto declara la matriz
	 * @param filas, almacenan el numero de filas que constara la matriz
	 * @param columnas, almacenan el numero de columnas que constara la matriz
	 * */
	public Matriz(int filas, int columnas){
		matriz = new int[filas][columnas];
	}
	
	/**
	 * constructor que controlara que las filas y las columnas no sean 0 y que el minimo no sea mayor que maximo. Tambien inicializa la matriz con numeros aleatorios.
	 * */
	public Matriz(int filas, int columnas, int min, int max){
		if (filas == 0 || columnas == 0){
			filas = 1;
			columnas = 1;
		}else if(min>max){
			max=min;
		}
		
		matriz = new int[filas][columnas];
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				matriz[i][j] = (int)(Math.round(Math.random()*(max-min)+min));
			}
		}
		
	}
	
	/**
	 * 
	 * */
	public String mostrar(String msg) {
		String cadena= msg+"\n";
		for(int i=0;i<filas();i++){
			for(int j=0;j<columnas();j++){
				cadena+=matriz[i][j]+"\t";
			}
			cadena+="\n";
		}
		
		return cadena;
	}
	
	/**
	 * 
	 * */
	public String mostrar() {
		String cadena="";
		for(int i=0;i<filas();i++){
			for(int j=0;j<columnas();j++){
				cadena+=matriz[i][j]+"\t";
			}
			cadena+="\n";
		}
		
		return cadena;
	}
	
	/**
	 * 
	 * */
	public Matriz sumar( Matriz s2){
		if (!mismasDimensiones(s2)) {
			System.out.print("\nNo puedo sumar las matrices porque son de distintas dimensiones.");
			return null;
		}
		int filas = filas();
		int columnas = columnas();
		Matriz suma = new Matriz(filas, columnas);
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				suma.matriz[i][j] = matriz[i][j] + s2.matriz[i][j];
			}
		}
		return suma;

	}
	
	/**
	 * 
	 * */
	public Matriz restar(Matriz sustraendo) {
		if (!mismasDimensiones(sustraendo)) {
			System.out.print("\nNo puedo restar las matrices porque son de distintas dimensiones.");
			return null;
		}
		int filas = filas();
		int columnas = columnas();
		Matriz resta = new Matriz(filas, columnas);
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				resta.matriz[i][j] = matriz[i][j] - sustraendo.matriz[i][j];
			}
		}
		return resta;
	}
	
	/**
	 * 
	 * */
	public Matriz multiplicar(Matriz p2) {
			int filas = filas();
			int columnas = columnas();
			Matriz resultado = new Matriz(filas,p2.matriz[0].length);
			for(int i=0;i<resultado.matriz.length;i++){
				for (int j=0;j<resultado.matriz[i].length;j++){
					for(int k=0;k<p2.matriz.length;k++){
						resultado.matriz[i][j] += matriz[i][k]*p2.matriz[k][j];
					}	
				}
			}
			return resultado;
		}
	
	/**
	 * 
	 * */
	public  void trasponer(){
		int filas = filas();
		int columnas = columnas();
		int[][] trasposicion = new int[columnas][filas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				trasposicion[j][i] = matriz[i][j];
			}
		}
		matriz = trasposicion;
	}
	
	/**
	 * 
	 * */
	private boolean mismasDimensiones(Matriz matriz2) {
		if(matriz2.matriz.length==matriz.length)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * */
	private int filas() {
		return matriz.length;
	}
	
	/**
	 * 
	 * */
	private int columnas() {
		return matriz[0].length;
	}

}
