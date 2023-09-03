package acumuladores;

public class Acumuladores {
	//1)
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if (matrizVacia(mat) || esNegativo(num)) return false;
		boolean algunaFila = false;
		for (int fila = 0; fila < mat.length; fila++) {
			algunaFila = algunaFila || todasLasColumnasSonMultiplos(mat[fila], num);
		}
		return algunaFila;
	}
	private boolean todasLasColumnasSonMultiplos(int [] mat, int num) { /* Auxiliar */
		boolean sonMultiplos = true;
		for (int columna = 0; columna < mat.length; columna++) {
			sonMultiplos = sonMultiplos && esMultiplo(mat[columna],num);
		}
		return sonMultiplos;
	}
	private boolean esMultiplo(int numMultiplo, int num) { /* Auxiliar */
		return numMultiplo % num == 0;
	}
	private boolean esNegativo(int num) { /* Auxiliar */
		return num <= 0;
	}
	private boolean matrizVacia(int[][] mat) { /* Auxiliar */
		return mat == null || mat.length == 0 || mat[0].length == 0;
	}
	
	//2)
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) {
		if (matrizVacia(mat1) || matrizVacia(mat2) || !(mat1.length == mat2.length)) return false;
		boolean interseccionEnFila = true;
		for (int fila = 0; fila < mat1.length; fila++) {
			interseccionEnFila = interseccionEnFila && ocurreLaInterseccion(mat1[fila],mat2[fila]);
		}
		return interseccionEnFila;
	}
	private boolean ocurreLaInterseccion(int[] mat1, int[] mat2) { /* Auxiliar */
		boolean interseccion = false;
		for (int columnasMat1 = 0; columnasMat1 < mat1.length; columnasMat1++) {
			for (int columnasMat2 = 0; columnasMat2 < mat2.length; columnasMat2++) {
				interseccion = interseccion || mat1[columnasMat1] == mat2[columnasMat2];
			}
		}
		return interseccion;
	}
	//3)
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if (matrizVacia(mat) || columnaInvalida(nColum, mat)) {
			return false;
		}
		boolean sumaFilaMayorSumaColumna = false;
		for (int fila = 0; fila < mat.length; fila++) {
			sumaFilaMayorSumaColumna = sumaFilaMayorSumaColumna || laFilaSuperaALaColumna(mat,acumuladorTotalDeFila(mat,fila),nColum);
		}
		return sumaFilaMayorSumaColumna;
	}
	private int acumuladorTotalDeFila(int[][] mat,int fila) { /* Auxiliar */
		int contadorTotalFilas = 0;
		for (int columna = 0; columna < mat[0].length; columna++) {
			contadorTotalFilas += mat[fila][columna];
		}
		return contadorTotalFilas;
	}
	private boolean laFilaSuperaALaColumna(int[][] mat,int contadorFilas,int nColum) { /* Auxiliar */
		boolean filaMayorQueColumna = true;
		return filaMayorQueColumna = filaMayorQueColumna && contadorFilas > acumuladorTotalDeColumna(mat,nColum);
	}
	private int acumuladorTotalDeColumna(int[][] mat, int nColum) { /* Auxiliar */
		int contadorColumna = 0;
		for (int fila = 0; fila < mat.length; fila++) {
			contadorColumna += mat[fila][nColum];
		}
		return contadorColumna;
	}
	private boolean columnaInvalida(int nColum, int[][] mat) { /* Auxiliar */
		return nColum < 0 || nColum == mat.length || nColum > mat.length;
	}
	//4)
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) {
		if (matrizVacia(mat1) || matrizVacia(mat2) || mat1[0].length != mat2[0].length) return false;
		boolean ocurreInterseccion = true;
		for (int columna = 0; columna < mat1[0].length; columna++) {
			ocurreInterseccion = ocurreInterseccion && interseccionEnColumnas(mat1,mat2,columna);
		}
		return ocurreInterseccion;
	}
	private boolean interseccionEnColumnas(int[][] mat1,int[][] mat2,int columna) { /* Auxiliar */
		boolean algunaInterseccion = false;
		for (int filaMatriz1 = 0; filaMatriz1 < mat1.length; filaMatriz1++) {
			for (int filaMatriz2 = 0; filaMatriz2 < mat2.length; filaMatriz2++) {
				algunaInterseccion = algunaInterseccion || mat1[filaMatriz1][columna] == mat2[filaMatriz2][columna];
			}
		}
		return algunaInterseccion;
	}
}

