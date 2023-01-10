package Project;

public abstract class Figura implements Luminosity
{
	private Color color;
	
	/**
	 * Geters y Seters del color 
	 * @return el valor del atributo que solicitan o que devuelven al atributo
	 */
	
	public void setColor(Color color)
	{
		this.color=color;
	}
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Asigna un color a la figura
	 */
	
	public Figura(Color color)
	{
		this.color=color;
	}
	
	/**
	 * Compara el color de las figuras mediante la funcion es igual de la clase color
	 */
	
	public boolean esIgualA(Figura figura)
	{
		return color.esIgualA(figura.color);
	}
	
	/**
	 * Funcion para cambiar la luminosidad +- del valor dado
	 * @return el valor del atributo inicial +- el dado
	 */
	
public void changeLuminosity(int value) {
		
		if(color.getB()+value>255)
		{
			int nuevoColor;
			nuevoColor=(color.getB()+value)-256;
			color.setB(nuevoColor);
		}else if(color.getB()+value<0) 
		{
			int nuevoColor;
			nuevoColor=(color.getB()+value)+256;
			color.setB(nuevoColor);
		}else 
		{
			int nuevoColor;
			nuevoColor=(color.getB()+value);
			color.setB(nuevoColor);
		}
	
		
		if(color.getG()+value>255)
		{
			int nuevoColor;
			nuevoColor=(color.getG()+value)-256;
			color.setG(nuevoColor);
		}else if(color.getG()+value<0) 
		{
			int nuevoColor;
			nuevoColor=(color.getG()+value)+256;
			color.setG(nuevoColor);
		}else 
		{
			int nuevoColor;
			nuevoColor=(color.getG()+value);
			color.setG(nuevoColor);
		}
		
		
		if(color.getR()+value>255)
		{
			int nuevoColor;
			nuevoColor=(color.getR()+value)-256;
			color.setR(nuevoColor);
		}else if(color.getR()+value<0) 
		{
			int nuevoColor;
			nuevoColor=(color.getR()+value)+256;
			color.setR(nuevoColor);
		}else 
		{
			int nuevoColor;
			nuevoColor=(color.getR()+value);
			color.setR(nuevoColor);
		}
		
		
	}

}

