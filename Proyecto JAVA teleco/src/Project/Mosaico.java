package Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Mosaico implements Luminosity{
        // Atributos
        Map<Coordenada,Tesela> teselas;
        private int filas;
        private int columnas;
        private int ancho;
        private int alto;
        private Collection<Region> regiones= new ArrayList<Region>();
        // Atributos estaticos

        // Constructor
        Mosaico (String fichero) throws NumberFormatException, FileNotFoundException, IOException , TileOutOfBoundsException
        {
                BufferedReader br = new BufferedReader(new FileReader(fichero));
                String linea;
                boolean primeraLinea=true;
                while((linea=br.readLine())!=null)
                {
                        if(linea.charAt(0)!='*')
                        {
                                if(primeraLinea)
                                {
                                        primeraLinea=false;
                                        String[]partes = linea.split("[x,]");    //expresion regular para partir la linea
                                        filas = Integer.parseInt(partes[0]);
                                        columnas = Integer.parseInt(partes[1]);
                                        ancho = Integer.parseInt(partes[2].trim());
                                        alto = Integer.parseInt(partes[3]);
                                        teselas=new TreeMap<>();
                                        // TODO comprobar si las teselas tienen diferente tama�o
                                        Tesela.setTamanho(ancho, alto);
                                }
                                else
                                {
                                        // Con replaceAll eliminamos todos los (, ), : y } de la cadena (los cambiamos por una cadena vacía)
                                        // Con split separamos la cadena por  los { y , que haya. El + lo usamos para que varios espacios en blanco los
                                        // considere uno solo (si no por cada espacio har�a  un split)
                                        String[]partes = linea.replaceAll("[(:}]","").split("[{ ,)]+");
                                        int fila= Integer.parseInt(partes[0]);
                                        int columna = Integer.parseInt(partes[1]);
                                        // TODO ver que pasa con el ancho y el alto
                                        
                                        if(fila<1 || columna<1)
                                        {
                                        	throw new TileOutOfBoundsException(null);
                                        }
                                        int estado = Integer.parseInt(partes[2].trim());
                                        // Eliminamos primero la R  o r, ya que como va primera, split devolverá una cadena vacía primero
                                        // en la posición 0, el primer color en la 1,....
                                        String[]coloresTesela = partes[3].replaceAll("[Rr]","").split("[RGBrg]");
                                        
                                        Tesela tesela = new Tesela(new Color(Integer.parseInt(coloresTesela[0]),
                                                Integer.parseInt(coloresTesela[1]),Integer.parseInt(coloresTesela[2])));
                                        tesela.setEstado(estado);
                                        
                                        if (partes.length> 4) //si la linea incluye una figura
                                        {
                                            String tipo = partes[4].trim();
                                            String[]coloresFigura=partes[5].replaceAll("[Rr]","").split("[RGBrgb]");
                                            String posicion = partes[6].trim();
                                            tesela.setPosicion(posicion);
                                            

                                                if(tipo.equalsIgnoreCase("REC"))
                                                {
                                                        int base= Integer.parseInt(partes[7].trim());
                                                        int altura=Integer.parseInt(partes[8]);
                                                        Rectangulo rectangulo = new Rectangulo(base,altura,new Color(Integer.parseInt(coloresFigura[0]),
                                                                        Integer.parseInt(coloresFigura[1]),Integer.parseInt(coloresFigura[2])));
                                                        tesela.setFigura(rectangulo);
                                                }
                                                else if(tipo.equalsIgnoreCase("CIR"))
                                                {
                                                        int radio=Integer.parseInt(partes[7].trim());
                                                        Circulo circulo = new Circulo(radio,new Color(Integer.parseInt(coloresFigura[0]),
                                                                        Integer.parseInt(coloresFigura[1]),Integer.parseInt(coloresFigura[2])));
                                                        tesela.setFigura(circulo);
                                                }
                                        }
                                      //restamos uno  por que los arrays empiezan en 0 , pero el enunciado considera que es la 1
                                        teselas.put(new Coordenada(fila , columna), tesela);
                                }

                        }
                }
                // TAREA de PROYECTO: generar una excepcion para tratar el caso de que
                // el fichero no exista.
        br.close();  
        // Rellenamos las teselas que no vienen en el fichero
        for(int f = 1; f <= filas;f++) {
        	for(int c = 1; c <= columnas; c++) {
        		if(!teselas.containsKey(new Coordenada(f,c))) {
        			teselas.put(new  Coordenada(f, c),new Tesela("C"));
        		}
        	}
        }
        }
        // Metodos de Instancia
        public void inicializar() 
        {
        	for(int f = 0;f< filas;f++)
        		for (int c =0;c<columnas; c++)
        		{
        			Coordenada coo=new Coordenada(f,c);
        			if(teselas.containsKey(coo)==false)
        			{
        				Tesela t= new Tesela(Color.BLANCO());
        				teselas.put(coo, t);
        				
        			}
        		}
        }
        public String toString ()
        {
        	String datos ="";
        	datos=filas+"x"+columnas+","+Tesela.getAncho()+"x"+Tesela.getAlto()+"\n";
        	int filaActual=-1;
        	for (Coordenada coordenada : teselas.keySet())
			{
        		if(coordenada.getFila()!=filaActual)
        		{
        			  filaActual=coordenada.getFila();
        		}
        		Tesela tesela=teselas.get(coordenada);
				datos=datos+"("+ coordenada.getFila() +"," + coordenada.getColumna() + "):"+tesela+"\n";
			
			}
            return datos.trim();        //con trim eliminamos el ultimo \n que queda(incluye saltos de linea)
        }
        // Getters y Setters
        
        /**
    	 * Geters y Seters de la Tesela
    	 * @return la Tesela
    	 */  
        
      public Tesela getTesela (int fila , int columna) 
      {
    	return teselas.get(new Coordenada(fila,columna));  
      }
      public void setTesela (int fila , int columna , Tesela tesela)
      {
    	  teselas.put(new Coordenada(fila,columna), tesela);
      }

      /**
  	 * Guarda el mosaico en un archivo de texto
  	 * @param fichero el fichero donde voy a guardarlo 
  	 */
      
      public void salvarAFichero(String fichero) throws FileNotFoundException
      {
    	  PrintWriter pw= new PrintWriter (fichero);
    	  pw.print(toString());
    	  pw.close();
    	  
      }
      
      
      
      /**
     * Genera el hash del mosaico
     *@return el hash del mosaico
     */
    public int hashCode ()
      {
    	  String s = this.toString();
    	  // elimina los blancos
    	  s = s.replaceAll(" ", "");
    	  return s.hashCode();
    	  }
      
      /**
  	 * Geters y Seters de las filas y columnas de la tesela
  	 * @return el valor del atributo filas y columnas que solicitan ,o , devuelven al atributo el nuevo valor de filas y columnas
  	 */
      
      public int getFilas()
      {
    	  return filas;
      }
      
      public int getColumnas()
      {
    	  return columnas;
      }
      
      public void setFilas(int filas)
      {
    	  this.filas=filas;
      }
      
     public void setColumnas(int columnas)
     {
    	 this.columnas=columnas;
     }
     
     /**
 	 * funcion que anhade una nueva region rectangular
 	 */
     
     public void anhadirRegion(Region r)
     {
    	 regiones.add(r);
     }
     
     
     /**
 	 * Ordena las regiones por su area de manera ascendente
 	 */
     public void ordenarRegionesXAreaAsc()
     {
     	 Collections.sort((List<Region>) regiones, new Region.CompararPorArea());
     	 
     }
     
     public Region getRegion(String nombre)
     {
    	 for (Region region : regiones)
    		 if(region.getNombre().equals(nombre))
    		 {
    			 return region;
    		 }
    	 return null;
     }
     
     public String toStringRegiones()
     {
    	 String cadena="";
    	 for (Region region : regiones)
    	 {
    		 cadena=cadena+region+"\n";
    	 }
    	 return cadena;
     }
     
     public Tesela getTesela(Coordenada c)
     {
    	 return teselas.get(c);
     }
     
     public Collection<String> listaClasesFiguras()
     {
    	Collection<String> figuras = new ArrayList<>();
    	for (Tesela tesela : teselas.values())
		{
			String nombre = tesela.getFigura().getClass().getSimpleName();
			if(figuras.contains(nombre)!=true)
			{
				figuras.add(nombre);
			}
		}
    	return figuras;
     }
     
     public int totalNumeroFigurasClase(String claseFigura)
     {
    	 int num=0;
    	 for (Tesela tesela : teselas.values())
		{
			if(tesela.tieneFigura()&& tesela.getFigura().getClass().getSimpleName().equals(claseFigura))
			{
				num++;
			}
			
		}
    	return num; 
	}
     
     public int totalNumeroTeselasSinFigura()
     {
    	 int num=0;
    	 for (Tesela tesela : teselas.values())
		{
			if(!tesela.tieneFigura())
			{
				num++;
			}
		}
    	 return num;
     }
	@Override
	public void changeLuminosity(int value) 
	{
		for (Tesela tesela : teselas.values()) 
		{
			tesela.changeLuminosity(value);
		}
		
	}
	
	public Collection<Region>getRegiones()
	{
		return regiones;
	}
}