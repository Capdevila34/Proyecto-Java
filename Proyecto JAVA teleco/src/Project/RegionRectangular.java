package Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


// TODO hacerla interna a mosaico
public class RegionRectangular extends Region 
{
	private int w;
	private int h;

	
	
	
	
	public int getW()
	{
		return w;
	}
	
	public void setW(int w)
	{
		this.w=w;
	}
	
	public int getH()
	{
		return h;
	}
	
	public void setH(int h)
	{
		this.h=h;
	}
	
	
	
	public RegionRectangular (Mosaico m, String nombre, int fila, int columna, int w, int h) 
	{
		super(m, nombre);
		if(m.getFilas()>=fila && m.getColumnas()>=columna &&fila>0 && columna>0)
		{
			setOrigen(new Coordenada(fila,columna));
			this.w=w;
			this.h=h;
			
			for(int f=0; f<w; f++)
				for (int c=0; c<h; c++)
					getCoordenadas().add(new Coordenada(f+fila,c+columna));
		}
		else
		{
			this.w=0;
			this.h=0;
			setOrigen(new Coordenada(1,1));
		}
	}
	
	 @Override
		public String toString()
		{
			 String cadena="";
			 for (Coordenada coordenada : getCoordenadas())
			{
				 //[(2,2), (1,1), (3,1), (1,3), (2,1), (2,3), (3,3), (3,2), (1,2)]
				cadena=cadena+"("+coordenada.getFila()+","+coordenada.getColumna()+"), ";
			}
			 if(!cadena.equals(""))
			 {
			 cadena=cadena.substring(0, cadena.length()-2);
			 }
			 return getNombre()+":("+origen().getFila()+","+origen().getColumna()+"),"+w+"-"+h+":["+cadena +"]";
		}
	

	 
		

	
}

