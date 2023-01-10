package Project;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	
		public static void main(String[] args )
		{
			
			Scanner sc = new Scanner(System.in);
			Mosaico mosaico= null;
			int opcion=0;
			boolean creado=false;
			do{
				try
				{
					muestraMenu(creado);
					opcion=Integer.parseInt(sc.nextLine());
					switch(opcion)
				
				{
					case 1:
						if(creado==true)
						{
							System.out.println("Opcion no disponible");
						}
						else
						{
							mosaico = new Mosaico("MosaicoDeTeselas.txt");
							creado=true;
						}
						break;
				
					case 2:
						mosaico.salvarAFichero("MosaicoSalida.txt");
//					crearRegion(sc, mosaico);
						break;
					
					case 3:
						totalNumeroTeselasPorClase(mosaico);
						//					desordenarRegion(sc, mosaico);
						break;

						
/*					case 4:
					ordenarRegionPorCoordenada(sc, mosaico);
						break;
				
					case 5:
					ordenarRegiones(mosaico);
						break;
					
					case 6:
					visualizarRegiones(mosaico);
						break;  
*/
				}
				}catch(Exception e)
				{
					System.out.println("Error:"+e.getMessage());
				}
			}while(opcion !=4);
					
				
					
				
			}

		private static void visualizarRegiones(Mosaico mosaico)
		{
			if(mosaico==null)
			{
				System.out.println("Hay que crear un mosaico previamente");
			}
			else 
			{
				System.out.println(mosaico.toStringRegiones());
				
			}
		}

		private static void ordenarRegiones(Mosaico mosaico)
		{
			if(mosaico==null)
			{
				System.out.println("Hay que crear un mosaico previamente");
			}
			else 
			{
				mosaico.ordenarRegionesXAreaAsc();
			}
		}

		private static void ordenarRegionPorCoordenada(Scanner sc, Mosaico mosaico)
		{
			if(mosaico==null)
			{
				System.out.println("Hay que crear un mosaico previamente");
			}
			else 
			{

				System.out.println("Introduce el nombre:");
				String nombre= sc.nextLine();
				RegionRectangular rr = mosaico.getRegion(nombre);
					if(rr != null)
					{
						rr.ordenarXCoordenadaAsc();
					}
					else
					{
						System.out.println("Region no encontrada");	
					}
			}
		}

		private static void desordenarRegion(Scanner sc, Mosaico mosaico)
		{
			if(mosaico==null)
			{
				System.out.println("Hay que crear un mosaico previamente");
			}
			else 
			{
				System.out.println("Introduce el nombre:");
				String nombre= sc.nextLine();
				RegionRectangular rr = mosaico.getRegion(nombre);
				if(rr != null)
					{
						rr.desordenar();
					}
				else
				{
					System.out.println("Region no encontrada");	
				}
			}
		}

		private static void crearRegion(Scanner sc, Mosaico mosaico)
		{
			if(mosaico==null)
			{
				System.out.println("Hay que crear un mosaico previamente");
			}
			else 
			{
				try
				{
					System.out.println("Introduce el nombre:");
					String nombre= sc.nextLine();
					System.out.println("Introduce f0:");
					int f0= Integer.parseInt(sc.nextLine());
					System.out.println("Introduce c0:");
					int c0= Integer.parseInt(sc.nextLine());
					System.out.println("Introduce w:");
					int w= Integer.parseInt(sc.nextLine());
					System.out.println("Introduce h:");
					int h= Integer.parseInt(sc.nextLine());

					RegionRectangular rr= new RegionRectangular(mosaico,nombre,f0,c0,w,h);
					mosaico.añadirRegion(rr);
				}catch(NumberFormatException e) 
				{
					System.out.println("Se introdujo algun dato incorrecto:"+e.getMessage());
				}
			}
		}
		
		private static void totalNumeroTeselasPorClase(Mosaico mosaico)
		{
			int resultado=mosaico.totalNumeroFigurasClase("Circulo");
			if(resultado>0)
			{
				System.out.println("Number of tiles with figure ‘Circulo’: "+resultado);
			}
			int solucion=mosaico.totalNumeroFigurasClase("Rectangulo");
			if(solucion>0)
			{
				System.out.println("Number of tiles with figure ‘Rectangulo’: "+solucion);
			}
			System.out.println("Number of tiles without figure: "+ mosaico.totalNumeroTeselasSinFigura());
		}
		
		static void muestraMenu(boolean creado)
		{
			if(creado==false)
			{
				System.out.println("1. Crear Mosaico");
			}
			System.out.println("2. Salvar a Fichero");
			System.out.println("3. Total número de teselas x clase de figura");
//			System.out.println("2. Crear y añadir region");
//			System.out.println("3. Desordenar region");
//			System.out.println("4. Ordenar region por coordenada");
//			System.out.println("5. Ordenar regiones");
//			System.out.println("6. Visualizar regiones");
			System.out.println("4. Salir");
		}
		
}