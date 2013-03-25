import java.awt.*;
import java.awt.event.*;

public class Papel extends Canvas implements MouseListener, MouseMotionListener{

	public static int x, y;
	public static int ancho, alto;
	public static int drawX, drawY;
	public static int OrWidth = 0, OrHeight = 0;
	public static int Orx, Ory;
	public static int mousex, mousey;
	
	public static int eraserLength = 15;
	public static int prevx = 0;
	public static int prevy = 0;
	
	public boolean InicialRect = true;
	public boolean InicialCirc = true;
	public boolean InicialLinea = true;
	public boolean InicialRectLleno = true;
	public boolean InicialCircLleno = true;
	public boolean InicialRect2 = true;
	public boolean InicialRectRedondo = true;
	
	public boolean InicialBorrador = true;
	
	public Papel(){
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(1000,600);
		setBackground(Color.WHITE);
	}
	
	public void Coordenadas(){
		if (ancho < Orx || alto < Ory) {
				if (ancho < Orx) {
					OrWidth = Orx - ancho;
					drawX = Orx - OrWidth;
				} else {
					drawX = Orx;
					OrWidth = ancho - Orx;
				}
				if (alto < Ory) {
					OrHeight = Ory - alto;
					drawY = Ory - OrHeight;
				}
				else {
					drawY = Ory;
					OrHeight = alto - Ory;
				}
			}
			else {
				drawX = Orx;
				drawY = Ory;
				OrWidth = ancho - Orx;
				OrHeight = alto - Ory;
			}
	}
	
	public void setGraphicalDefaults(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
		prevx = e.getX();
		prevy = e.getY();
		Orx = e.getX();
		Ory = e.getY();
		drawX = e.getX();
		drawY = e.getY();
		OrWidth = 0;
		OrHeight = 0;
	}
	
	public void mousePressed(MouseEvent e){
		this.x=e.getX();
		this.y=e.getY();
	}
	
	public void mouseDragged(MouseEvent e){
		Graphics g= getGraphics();
		g.setColor(BarraColores.color);
		if(e.getButton()==MouseEvent.BUTTON1){
			g.setColor(BarraColores.color2);
		}
		
		if(BarraDibujo.estado.equals("Lapiz")){
			g.drawLine(x, y, e.getX(), e.getY());
			this.x=e.getX();
			this.y=e.getY();
		}
		
		if(BarraDibujo.estado.equals("Borrador")){
			if (InicialBorrador){
				setGraphicalDefaults(e);
				InicialBorrador = false;
				g.fillRect(mousex - eraserLength, mousey - eraserLength,eraserLength * 2, eraserLength * 2);
				g.setColor(Color.black);
				g.drawRect(mousex - eraserLength, mousey - eraserLength,eraserLength * 2, eraserLength * 2);
				prevx = mousex;
				prevy = mousey;
			}
			
			g.setColor(BarraColores.color2);
			g.drawRect(prevx - eraserLength, prevy - eraserLength,eraserLength * 2, eraserLength * 2);
			mousex = e.getX();
			mousey = e.getY();
			g.setColor(BarraColores.color2);
			g.fillRect(mousex - eraserLength, mousey - eraserLength,eraserLength * 2, eraserLength * 2);
			g.setColor(Color.black);
			g.drawRect(mousex - eraserLength, mousey - eraserLength,eraserLength * 2, eraserLength * 2);
			prevx = mousex;
			prevy = mousey;
		}
		
		if(BarraDibujo.estado.equals("Rect")){
			g.setXORMode(getBackground());
			g.drawRect(drawX, drawY, OrWidth, OrHeight);
			ancho=e.getX();
			alto=e.getY();
			
			if(InicialRect){
				setGraphicalDefaults(e);
				Orx = e.getX();
				Ory = e.getY();
				InicialRect = false;
			}
				
			Coordenadas();
			
			g.drawRect(drawX, drawY, OrWidth, OrHeight);	
		}
				
		if(BarraDibujo.estado.equals("Rect2")){	
			g.setXORMode(getBackground());
			g.drawRoundRect(drawX, drawY, OrWidth, OrHeight, 50, 50);
			ancho=e.getX();
			alto=e.getY();
			
			if(InicialRect2){
				setGraphicalDefaults(e);
				Orx = e.getX();
				Ory = e.getY();
				InicialRect2 = false;
			}
				
			Coordenadas();
			
			g.drawRoundRect(drawX, drawY, OrWidth, OrHeight, 50, 50);			
		}
		
		if(BarraDibujo.estado.equals("Circulo")){
			g.setXORMode(getBackground());
			g.drawOval(drawX, drawY, OrWidth, OrHeight);
			ancho=e.getX();
			alto=e.getY();
			
			if(InicialCirc){
				setGraphicalDefaults(e);
				Orx = e.getX();
				Ory = e.getY();
				InicialCirc = false;
			}
				
			Coordenadas();			
			
			g.drawOval(drawX, drawY, OrWidth, OrHeight);
		}
		
		
		if(BarraDibujo.estado.equals("Rect_lleno")){
			g.setXORMode(getBackground());
			g.fillRect(drawX, drawY, OrWidth, OrHeight);
			ancho=e.getX();
			alto=e.getY();
			
			if(InicialRectLleno){
				setGraphicalDefaults(e);
				Orx = e.getX();
				Ory = e.getY();
				InicialRectLleno = false;
			}
				
			Coordenadas();
			
			g.fillRect(drawX, drawY, OrWidth, OrHeight);			
		}
		
		if(BarraDibujo.estado.equals("Rect2_lleno")){
			g.setXORMode(getBackground());
			g.fillRoundRect(drawX, drawY, OrWidth, OrHeight, 50, 50);
			ancho=e.getX();
			alto=e.getY();
			
			if(InicialRectRedondo){
				setGraphicalDefaults(e);
				Orx = e.getX();
				Ory = e.getY();
				InicialRectRedondo = false;
			}
				
			Coordenadas();
			
			g.fillRoundRect(drawX, drawY, OrWidth, OrHeight, 50, 50);
		}
		
		if(BarraDibujo.estado.equals("Circulo_lleno")){
			g.setXORMode(getBackground());
			g.fillOval(drawX, drawY, OrWidth, OrHeight);
			ancho=e.getX();
			alto=e.getY();
			
			if(InicialCircLleno){
				setGraphicalDefaults(e);
				Orx = e.getX();
				Ory = e.getY();
				InicialCircLleno = false;
			}
					
			Coordenadas();
			
			g.fillOval(drawX, drawY, OrWidth, OrHeight);
		}
		
		if(BarraDibujo.estado.equals("Linea")){
			
			g.setXORMode(getBackground());
			g.drawLine(Orx, Ory, mousex, mousey);
			mousex=e.getX();
			mousey=e.getY();
			
			if(InicialLinea){
				Orx = e.getX();
				Ory = e.getY();
				InicialLinea = false;
			}
			
			g.drawLine(Orx, Ory, mousex, mousey);			
		}
		
		g.dispose();
	}
	
	public void mouseReleased(MouseEvent e){
		Graphics g= getGraphics();
		g.setColor(BarraColores.color);
		if(e.getButton()==MouseEvent.BUTTON3){
			g.setColor(BarraColores.color2);
		}
		
		if(BarraDibujo.estado.equals("Borrador")){
			InicialBorrador = true;
			g.setColor(BarraColores.color2);
			setGraphicalDefaults(e);
			g.drawRect(mousex - eraserLength, mousey - eraserLength, eraserLength * 2, eraserLength * 2);
		}
	
		if(BarraDibujo.estado.equals("Rect")){
			InicialRect = true;
			g.drawRect(drawX, drawY, OrWidth, OrHeight);
			setGraphicalDefaults(e);
		}
		
		if(BarraDibujo.estado.equals("Rect2")){
			InicialRect2 = true;
			g.drawRoundRect(drawX, drawY, OrWidth, OrHeight, 50, 50);
			setGraphicalDefaults(e);
		}
		
		if(BarraDibujo.estado.equals("Circulo")){
			InicialCirc = true;
			g.drawOval(drawX, drawY, OrWidth, OrHeight);
			setGraphicalDefaults(e);
		}
		
		
		if(BarraDibujo.estado.equals("Rect_lleno")){
			InicialRectLleno = true;
			g.fillRect(drawX, drawY, OrWidth, OrHeight);
			setGraphicalDefaults(e);
		}
		
		if(BarraDibujo.estado.equals("Rect2_lleno")){
			InicialRectRedondo = true;
			g.fillRoundRect(drawX, drawY, OrWidth, OrHeight, 50, 50);
			setGraphicalDefaults(e);
		}
		
		if(BarraDibujo.estado.equals("Circulo_lleno")){
			InicialCircLleno = true;
			g.fillOval(drawX, drawY, OrWidth, OrHeight);
			setGraphicalDefaults(e);
		}
		
		if(BarraDibujo.estado.equals("Linea")){
			if ((Math.abs(Orx - mousex) + Math.abs(Ory - mousey)) != 0) {
				InicialLinea = true;
				g.drawLine(Orx, Ory, mousex, mousey);
				setGraphicalDefaults(e);
			}
		}
		
		g.dispose();
	}
	
	public void mouseClicked(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	public void mouseEntered(MouseEvent e){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("iconos/pencil.gif");
		Point hotSpot = new Point(0,0);
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Lapiz");
		if(BarraDibujo.estado.equals("Lapiz")){
			setCursor(cursor);
		} else
		if(BarraDibujo.estado.equals("")){
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		} else
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		BarraEstado.estado_label.setText(null);
	}
}