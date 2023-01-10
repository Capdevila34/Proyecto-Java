package Project;

public class Rectangulo extends Figura
{
	private int base;
	private int altura;
	
	public Rectangulo(int base , int altura , Color color)
	{
		super(color);
		this.base=base;
		this.altura=altura;
	}
	
	public int getBase()
	{
		return base;
	}
	
	public int getAltura()
	{
		return altura;
	}
	
	
	public void setBase(int base)
	{
		this.base=base;
	}
	
	public void setAltura (int altura)
	{
		this.altura=altura;
	}
	
	public double area()
	{
		return (base*altura)/100;
	}
	
	public boolean esIgualA(Rectangulo rectangulo)
	{
		if(rectangulo==null)
		{
			return false;
		}
		
		if(base==rectangulo.base && altura==rectangulo.altura && getColor().esIgualA(rectangulo.getColor()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
	
	
