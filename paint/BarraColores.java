import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BarraColores implements MouseListener{

	public static JToolBar barra_colores;
	public static JButton negro, azul, cian, gris_oscuro, gris_claro, gris, verde, magenta, naranja, rosa, rojo, blanco, amarillo;
	public static Color color, color2, fondo;
	public static String espacios = "      ";

	public BarraColores(){
		barra_colores = new JToolBar("Barra de Colores");
		barra_colores.addMouseListener(this);
		barra_colores.setFloatable(false);
		barra_colores.setRollover(false);
		
		color = Color.BLACK;
		color2 = Color.WHITE;
		fondo = Color.WHITE;
	
		negro		= new JButton(espacios);
		azul		= new JButton(espacios);
		cian		= new JButton(espacios);
		gris_oscuro 	= new JButton(espacios);
		gris_claro 	= new JButton(espacios);
		gris 		= new JButton(espacios);
		verde 		= new JButton(espacios);
		magenta 	= new JButton(espacios);
		naranja 	= new JButton(espacios);
		rosa 		= new JButton(espacios);
		rojo 		= new JButton(espacios);
		blanco 		= new JButton(espacios);
		amarillo 	= new JButton(espacios);
		
		negro.setToolTipText("Negro");
		azul.setToolTipText("Azul");
		cian.setToolTipText("Cian");
		gris_oscuro.setToolTipText("Gris Oscuro");
		gris_claro.setToolTipText("Gris Claro");
		gris.setToolTipText("Gris");
		verde.setToolTipText("Verde");
		magenta.setToolTipText("Magenta");
		naranja.setToolTipText("Naranja");
		rosa.setToolTipText("Rosa");
		rojo.setToolTipText("Rojo");
		blanco.setToolTipText("Blanco");
		amarillo.setToolTipText("Amarillo");
		
		negro.addMouseListener(this);
		azul.addMouseListener(this);
		cian.addMouseListener(this);
		gris_oscuro.addMouseListener(this);
		gris_claro.addMouseListener(this);
		gris.addMouseListener(this);
		verde.addMouseListener(this);
		magenta.addMouseListener(this);
		naranja.addMouseListener(this);
		rosa.addMouseListener(this);
		rojo.addMouseListener(this);
		blanco.addMouseListener(this);
		amarillo.addMouseListener(this);
		
		negro.setBackground(Color.BLACK);
		azul.setBackground(Color.BLUE);
		cian.setBackground(Color.CYAN);
		gris_oscuro.setBackground(Color.DARK_GRAY);
		gris_claro.setBackground(Color.LIGHT_GRAY);
		gris.setBackground(Color.GRAY);
		verde.setBackground(Color.GREEN);
		magenta.setBackground(Color.MAGENTA);
		naranja.setBackground(Color.ORANGE);
		rosa.setBackground(Color.PINK);
		rojo.setBackground(Color.RED);
		blanco.setBackground(Color.WHITE);
		amarillo.setBackground(Color.YELLOW);
		
		barra_colores.add(negro);
		barra_colores.add(azul);
		barra_colores.add(cian);
		barra_colores.add(gris_oscuro);
		barra_colores.add(gris_claro);
		barra_colores.add(gris);
		barra_colores.add(verde);
		barra_colores.add(magenta);
		barra_colores.add(naranja);
		barra_colores.add(rosa);
		barra_colores.add(rojo);
		barra_colores.add(blanco);
		barra_colores.add(amarillo);
	}
	
	public void clickIzquierdo(MouseEvent event){
		if(event.getSource()==negro)
			color = Color.BLACK;
		if(event.getSource()==azul)
			color = Color.BLUE;
		if(event.getSource()==cian)
			color = Color.CYAN;
		if(event.getSource()==gris_oscuro)
			color = Color.DARK_GRAY;
		if(event.getSource()==gris_claro)
			color = Color.LIGHT_GRAY;
		if(event.getSource()==gris)
			color = Color.GRAY;
		if(event.getSource()==verde)
			color = Color.GREEN;
		if(event.getSource()==magenta)
			color = Color.MAGENTA;
		if(event.getSource()==naranja)
			color = Color.ORANGE;
		if(event.getSource()==rosa)
			color = Color.PINK;
		if(event.getSource()==rojo)
			color = Color.RED;
		if(event.getSource()==blanco)
			color = Color.WHITE;
		if(event.getSource()==amarillo)
			color = Color.YELLOW;
	}
	
	public void clickDerecho(MouseEvent event){
		if(event.getSource()==negro)
			color2 = Color.BLACK;
		if(event.getSource()==azul)
			color2 = Color.BLUE;
		if(event.getSource()==cian)
			color2 = Color.CYAN;
		if(event.getSource()==gris_oscuro)
			color2 = Color.DARK_GRAY;
		if(event.getSource()==gris_claro)
			color2 = Color.LIGHT_GRAY;
		if(event.getSource()==gris)
			color2 = Color.GRAY;
		if(event.getSource()==verde)
			color2 = Color.GREEN;
		if(event.getSource()==magenta)
			color2 = Color.MAGENTA;
		if(event.getSource()==naranja)
			color2 = Color.ORANGE;
		if(event.getSource()==rosa)
			color2 = Color.PINK;
		if(event.getSource()==rojo)
			color2 = Color.RED;
		if(event.getSource()==blanco)
			color2 = Color.WHITE;
		if(event.getSource()==amarillo)
			color2 = Color.YELLOW;
	}
	
	public void mousePressed(MouseEvent event){}
	public void mouseDragged(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
	public void mouseClicked(MouseEvent event){
		if(event.getButton()==MouseEvent.BUTTON1){
			clickIzquierdo(event);
			BarraDibujo.color_sel.setBackground(color);
		}
		if(event.getButton()==MouseEvent.BUTTON3){
			clickDerecho(event);
			BarraDibujo.color2_sel.setBackground(color2);
		}
	}
	public void mouseEntered(MouseEvent event){
		if(event.getSource()==barra_colores){
			BarraEstado.estado_label.setText(null);
		}
	}
}
