package Project;

public class Circulo extends Figura
{
	//Atributos
	private int radio;		//en porcentaje
	
	//Atributos estaticos
	//T1 atributo estatico valor PI
	
	private static final double PI=3.14;
	
	//Contructor
	
	Circulo (int radio , Color color)
	{
		//Crear codigo del constructor
		super(color);
		this.radio = radio;
	}
	//Contructor alternativo para un circulo sin color
//	Circulo (int radio)
//	{
		//Crear codigo del constructor
//		super(null);
//		this.radio = radio;
//	}
	
	/**
	 * Metodo que calcula el area del circulo
	 * @return el area
	 */
	//metodos no estaticos o de instancia
	public double area()
	{
		//Calcular el area porcentual
		return (PI*radio*radio)/100;
	}
	
	/**
	 * Comprueba si dos circulos son iguales
	 * @param circulo el circulo con el que comparar
	 * @return true si son iguales , false si son distintos
	 */

	
	public boolean esIgualA (Circulo circulo)
	{
		if (circulo==null)
		{
			return false;
		}
		//Compara el circulo del metodo con el pasado por el argumento
		if(this.radio==circulo.radio && this.getColor().esIgualA(circulo.getColor()))
		{
		return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString () 
	{
			return "Radio: " + radio + ", Color: " + getColor();
	}
	
	//Getters y Setters
	
	/**
	 * Geters y Seters del radio que forma el circulo
	 * @return el valor del atributo que solicitan o que devuelven al atributo
	 */
	
	public int getRadio()
	{
		return radio;
	}
	
	
	public void setRadio(int radio)
	{
		this.radio=radio;
	}
}