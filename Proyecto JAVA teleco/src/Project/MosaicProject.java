package Project;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MosaicProject {

	static Mosaico mosaico;
	public static void main(String[] args) 
	{
		if(args.length!=1)
		{
			System.out.println("java Project.MosaicProject <instructions_file>");
			System.exit(1);
		}
		 
		try {
				//BufferedReader br = new BufferedReader(new FileReader("Project"+ File.separator+args[0]));
				BufferedReader br = new BufferedReader(new FileReader("D:\\pruebasbateria\\Instructions.txt"));
				String linea;
				while((linea=br.readLine())!=null)
				{
					String[] partes= linea.split(" ");
					switch(partes[0])
					{
					case "ReadMosaic":
						System.out.println("ReadMosaic");
						readMosaic(partes[1]);
						break;
					case "CreateRegion":
						System.out.println("CreateRegion");
						createRegion(partes[1]);
						break;
					case "ChangeLuminosityMosaic":
						System.out.println("ChangeLuminosityMosaic");
						changeLuminosityMosaic(partes[1]);
						break;
					case "ChangeLuminosityRegion":
						System.out.println("ChangeLuminosityRegion");
						changeLuminosityRegion(partes[1]);
						break;
					case "ChangeLuminosityTile":
						System.out.println("ChangeLuminosityTile");
						changeLuminosityTile(partes[1]);
						break;
					case "ChangeStatusMosaic":
						System.out.println("ChangeStatusMosaic");
						break;
					case "ChangeStatusRegion":
						System.out.println("ChangeStatusRegion");
						changeStatusRegion(partes[1]);
						break;
					case "ChangeStatusTile":
						System.out.println("ChangeStatusTile");
						changeStatusTile(partes[1]);
						break;
					case "SortRegionsByArea":
						System.out.println("SortRegionsByArea");
						sortRegionsByArea(partes[1]);
						break;
					case "SaveMosaic":
						System.out.println("SaveMosaic");
						//mosaico.salvarAFichero("Project"+ File.separator+partes[1]);
						mosaico.salvarAFichero("D:\\pruebasbateria\\"+partes[1]);
						break;

        	  	
					}
				}
          
				br.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private static void sortRegionsByArea(String datos)
	{
		PrintWriter pw=null;
		PrintWriter pw2=null;
		List <Region>regiones;
		try
		{	
			//pw=new PrintWriter("Project"+File.separator+"error.txt");
			pw=new PrintWriter("D:\\pruebasbateria\\"+"error.txt");
			//pw2=new PrintWriter("Project"+File.separator+datos);
			pw2=new PrintWriter("D:\\pruebasbateria\\"+datos);
			regiones=new ArrayList(mosaico.getRegiones());
			
			Collections.sort(regiones,new Region.CompararPorArea());
			
			for (Region region : regiones) 
			{
				pw2.println(region.toString());
				
			}
			pw2.close();
	//		<Name>:(<r0>,<c0>),<h>-<w>:[<coordinates>]
			
		}catch(FileNotFoundException e)
		{
			pw.println("FileNotFoundException");
			System.exit(1);
		}
		pw.close();
		
	}

	private static void readMosaic(String fichero) throws NumberFormatException, IOException 
	{
		PrintWriter pw = null;
		try 
		{
			//pw= new PrintWriter("Project"+ File.separator+"error.txt");
			pw= new PrintWriter("D:\\pruebasbateria\\"+"error.txt");
			//mosaico= new Mosaico("Project"+ File.separator+fichero);
			mosaico=new Mosaico("D:\\pruebasbateria\\"+fichero);
		} catch (FileNotFoundException e)
		{
			pw.println("FileNotFoundException");
		}
		catch (TileOutOfBoundsException e) 
			{
				pw.println("TileOutOfBoundsExcepction");
				e.printStackTrace();
				pw.close();
				System.exit(1);
				
			} 
		pw.close();
	}
	
	
	
	private static void createRegion(String datos)
	{
		String partes[];
		partes= datos.split(",");
		String nombre= partes[0];
		int fila=Integer.parseInt(partes[1]);
		int columna=Integer.parseInt(partes[2]);
		int ancho=Integer.parseInt(partes[3]);
		int alto=Integer.parseInt(partes[4]);
		
		Region regionUno = new RegionRectangular(mosaico, nombre, fila, columna, ancho, alto);
		mosaico.anhadirRegion(regionUno);
	}

	private static void changeLuminosityTile(String datos)
	{
		String partes[];
		partes=datos.split(",");
		int value= Integer.parseInt(partes[0]);
		int row=Integer.parseInt(partes[1]);
		int columna=Integer.parseInt(partes[2]);
		Tesela teselaUno=mosaico.getTesela(row, columna);
		teselaUno.changeLuminosity(value);
	}

	private static void changeLuminosityRegion(String datos)
	{
		String partes[];
		partes=datos.split(",");
		int value=Integer.parseInt(partes[0]);
		String regionName= partes[1];
		Region regionUno=mosaico.getRegion(regionName);
		regionUno.changeLuminosity(value);
	}
	
	private static void changeLuminosityMosaic(String datos)
	{
		String partes[];
		partes=datos.split(",");
		int value=Integer.parseInt(partes[0]);
		mosaico.changeLuminosity(value);
	}

	private static void changeStatusTile(String datos)
	{
		String partes[];
		partes=datos.split(",");
		int value=Integer.parseInt(partes[0]);
		int row=Integer.parseInt(partes[1]);
		int columna=Integer.parseInt(partes[2]);
		Tesela teselaUno=mosaico.getTesela(row, columna);
		teselaUno.setEstado(value);
	}
	
	private static void changeStatusRegion(String datos)
	{
		String partes[];
		partes=datos.split(",");
		int value=Integer.parseInt(partes[0]);
		String nombre=partes[1];
		Region regionUno=mosaico.getRegion(nombre);
		System.out.println(regionUno);
		regionUno.changeStatus(value);
	}
}
	