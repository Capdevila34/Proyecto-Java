package Project;

public class Tesela implements Luminosity {

    private Color color;
    private Figura figura;
    private String posicion;
    private int estado=1;
    private int luminosityChange;
    private Color colorAnterior;
    private static final int APAGADO=0;
    private static final int ENCENDIDO=1;
    private static final int FIGURAAPAGADA=2;

    public static final String R = "R";
    public static final String U = "U";
    public static final String C = "C";
    public static final String D = "D";
    public static final String L = "L";

    private static int wTesela;
    private static int hTesela;

    public Color getColor() {
        return color;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        if(estado==APAGADO)
        {
        	if(figura!=null)
        	{
        		figura.setColor(color.NEGRO());
        	}
        	this.colorAnterior=color;
        	color =Color.NEGRO();
        }else if (estado==ENCENDIDO) {
        	if(colorAnterior!=null)
        	{
        		color= colorAnterior;
        	}
        	
        }else {
        	if(figura!= null) {
        	figura.setColor(color.NEGRO());
        	}
        	
        }
        	
        
    }

    public Figura getFigura() {
        return figura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }


    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    //METODOS
    public static void setTamanho(int wTesela, int hTesela) {
        Tesela.wTesela = wTesela;
        Tesela.hTesela = hTesela;
    }

    public static int getAlto() {
        return Tesela.hTesela;
    }

    public static int getAncho() {
        return Tesela.wTesela;
    }

    //Contructor
    public Tesela(Color color) {
        this.color = color;
    }

    public Tesela(Color color, String posicion, Figura figura) {
        this(color);
        this.posicion = posicion;
        this.figura=figura;
    }

    
    public Tesela(String posicion) 
    {
    	color=Color.BLANCO();
        this.posicion = posicion;
    }


    public boolean tieneFigura() {
        if (figura != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esIgualA(Tesela tesela) {
        if (tesela == null) {
            return false;
        }

        if (!this.color.esIgualA(tesela.color)) {
            return false;
        }
        if (this.figura != null && this.figura.esIgualA(tesela.figura)) {
            return true;
        }
        if (this.figura == null && this.figura != null) {
            return false;
        }
     

        return true;
    }

    public String toString() {
        if (tieneFigura() == false) {
            return estado + "{" + color + "}";
        } else if (figura instanceof Rectangulo) 
        {
            Rectangulo rectangulo= (Rectangulo)figura;
        	return estado + "{" + color + ",REC:{" + rectangulo.getColor() + "," + posicion + "," + rectangulo.getBase() + "," + rectangulo.getAltura() + "}}";
        } else //if(circulo!= null)
        {
            Circulo circulo =(Circulo)figura;
        	return estado + "{" + color + ",CIR:{" + circulo.getColor() + "," + posicion + "," + circulo.getRadio() + "}}";
        }
        //	(3,1): 1 {R0G0B255, REC:{R100G100B255, D, 100,0}}	
        //(4,1): 1 {R00G00B255, CIR:{R0G250B255, C,35}}

    }

	@Override
	public void changeLuminosity(int value) {
		
		luminosityChange= luminosityChange+value;
		
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
		if(figura!=null) 
		{
			figura.changeLuminosity(value);
		}
	}

}
