package Project;

public class Coordenada implements Comparable<Coordenada>
{
	private int fila;
	private int columna;
	
	/**
	 * Geters y Seters de los atributos que forman una coordenada
	 * @return el valor del atributo que solicitan o que devuelven al atributo
	 */
	
	public void setFila(int fila)
	{
		this.fila=fila;
	}
	
	public void setColumna(int columna)
	{
		this.columna=columna;
	}
	
	public int getFila()
	{
		return fila;
	}
	
	public int getColumna()
	{
		return columna;
	}
	
	/**
	 * Guarda los datos de las filas y columnas en la coordenada
	 */
	
	public Coordenada(int fila, int columna) 
	{
		this.fila=fila;
		this.columna=columna;
	}

	/**
	 * Compara dos coordenadas para ver si son iguales
	 * @return el valor 0 en caso de que sean iguales
	 */
	
	@Override
	public int compareTo(Coordenada o)
	{
		if(fila== o.getFila() && columna== o.getColumna())
		{
		return 0;
		}
		else if(fila> o.getFila() ) 
		{
			return 1;
		}
		else if(fila< o.getFila() )
		{
			return -1;
		}
		else if(columna> o.getColumna())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	
	
	}
}