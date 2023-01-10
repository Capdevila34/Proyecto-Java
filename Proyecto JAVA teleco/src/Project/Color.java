package Project;

public class Color {
	// Atributos
	private int r;
	private int g;
	private int b;

	// Atributos estáticos
	private static final int MAX = 255;

	// Constructor
	Color(int r, int g, int b) {
		if ((r > MAX) || (g > MAX) || (b > MAX)) {
			this.r = MAX;
			this.g = MAX;
			this.b = MAX;
			// TAREA de PROYECTO: En este caso (durante la realización del proyecto)
			// y después de que hayas aprendido a usar las excepciones deberás
			// generar una excepción para tratar el caso de que alguno
			// de los valores r, g o b sea mayor de 255.
		} else {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

	// Métodos estáticos o de Clase
	public static final Color BLANCO() {
		return new Color(255, 255, 255);
	}

	// TAREA 1. Siguiendo el ejemplo del metodo BLANCO()
	// crea metodos estaticos para los colores: NEGRO, ROJO, AZUL, VERDE,
	// AMARILLO, CYAN y MAGENTA.
	//
	
	/**
	 * Crea el color NEGRO y le asigna los valores
	 * @return el color NEGRO
	 */
	public static final Color NEGRO(){
		return new Color (0,0,0);
	}
	/**
	 * Crea el color ROJO y le asigna los valores
	 * @return el color ROJO
	 */
	public static final Color ROJO (){
		return new Color (255,0,0);
	}
	/**
	 * Crea el color AZUL y le asigna los valores
	 * @return el color AZUL
	 */
	public static final Color AZUL (){
		return new Color (0,0,255);
	}
	/**
	 * Crea el color VERDE y le asigna los valores
	 * @return el color VERDE
	 */
	public static final Color VERDE (){
		return new Color (0,255,0);
	}
	/**
	 * Crea el color AMARILLO y le asigna los valores
	 * @return el color AMARILLO
	 */
	public static final Color AMARILLO (){
		return new Color (255,255,0);
	}
	/**
	 * Crea el color CYAN y le asigna los valores
	 * @return el color CYAN
	 */
	public static final Color CYAN (){
		return new Color (0,255,255);
	}
	/**
	 * Crea el color MAGENTA y le asigna los valores
	 * @return el color MAGENTA
	 */
	public static final Color MAGENTA (){
		return new Color (255,0,255);
	}
	
	// Métodos no estáticos o de Instancia
	/**
	 * Comprueba si dos colores son iguales
	 * @param color el color con el que comparar
	 * @return true si son iguales , false si son distintos
	 */
	public boolean esIgualA(Color color) {
		// TAREA 2 . Completa el código para comparar si el color del objeto this
		// es el mismo que el color del objeto pasado en el argumento del método.
		if (this.r == color.r && this.g == color.g && this.b == color.b)
		{
			return true;
		}
		else
		{		
			return false;
		}
	}
	
	
	public String toString() {
            // Según el fichero MosaicoDeTeselas.txt de la práctica 2, si un color es 0, solo 
            // se guarda el 0  (ejemplo R0), pero si tiene una o dos cifras, deben ponerse ceros
            // a la izquierda (ejmplo R010, G005)
            // Nota: en los ficheros de ejemplo de la práctica, en algunos casos incumple esto
            // y algunas veces si pone un 0 o no, cuando el número tiene una o dos cifras, con lo que
            // nuestra salida no va a ser igual
            String rojo, verde, azul;
 /*           if(r == 0) {
                rojo = "R0";
            } else {
                rojo = String.format("R%03d", r);
            }
            if(g == 0) {
                verde = "G0";
            } else {
                verde = String.format("G%03d", g);
            }
            if(b == 0) {
                azul = "B0";
            } else {
                azul = String.format("B%03d", b);
            }
   */         
            rojo="R"+r;
            verde="G"+g;
            azul="B"+b;
            return rojo + verde + azul;
	}

	/**
	 * Geters y Seters de los atributos que forman un color , r g y b
	 * @return el valor del atributo que solicitan o que devuelven al atributo
	 */
	
	// 	Getters y Setters
	public int getR() {
		return this.r;
	}

	public int getG() {
		return this.g;
	}

	public int getB() {
		return this.b;
	}
	
	public void setR(int r)
	{
		this.r =r;
	}
	
	public void setG(int g)
	{
		this.g=g;
	}
	
	public void setB (int b)
	{
		this.b=b;
	}
}