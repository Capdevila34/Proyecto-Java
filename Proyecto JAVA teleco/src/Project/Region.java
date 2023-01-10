package Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Region implements Luminosity, Status
{
	private Mosaico mosaico;
	private String nombre;
	private Coordenada origen;
	private ArrayList<Coordenada>coordenadas=new ArrayList<>();
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	
	public Coordenada origen()
	{
		return origen;
	}
	
	public void setOrigen(Coordenada origen)
	{
		this.origen=origen;
	}
	
	public Mosaico getMosaico()
	{
		return mosaico;
	}
	
	public void setMosaico(Mosaico mosaico)
	{
		this.mosaico=mosaico;
	}
	
	@Override
	public void changeLuminosity(int value) 
	{
		for (Coordenada coordenada : coordenadas) 
		{
			Tesela teselaUno=mosaico.getTesela(coordenada);
			if(teselaUno!=null)
			{
				teselaUno.changeLuminosity(value);
			}
		}
		
	}
	
	

	@Override
	public void changeStatus(int estado) 
	{
		for (Coordenada coordenada : coordenadas) 
		{
			Tesela teselaUno=mosaico.getTesela(coordenada);
			System.out.println(teselaUno);
			if(teselaUno!=null)
			{
				teselaUno.setEstado(estado);
			}
			System.out.println("---");
			System.out.println(teselaUno);
		}
		
	}
	
	 public void desordenar()
	 {
		 Collections.shuffle(coordenadas);
	 }
	 
	 public void ordenarXCoordenadaAsc()
	 {
		 Collections.sort(coordenadas);
	 }
	 
	 public int area ()
	 {
		 return coordenadas.size();
	 }
	 
	 
	 public Collection<Coordenada> getCoordenadas ()
	 {
		 return coordenadas;
	 }
	
	 static class CompararPorArea implements Comparator<Region>
	 {
		 @Override
		 public int compare(Region o1, Region o2)
		 {
			 if(o1.area()>o2.area())                   //Asi orden ascendente , si pusiera negativo en el 1 y positivo en el -1 seria descendente
			 {
				 return 1;
			 }
			 else if(o1.area()<o2.area())
			 {
				 return -1;
			 }
			 else 
			 {
				 return o1.nombre.compareTo(o2.nombre);
			 }
		 }
	}
	 
	


	 
	 
	 public Region (Mosaico m, String nombre)
		{
			mosaico=m;
			this.nombre=nombre;
			
		}
		
}

