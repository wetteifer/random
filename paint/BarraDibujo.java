import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BarraDibujo implements ActionListener, MouseListener{

	public static JToolBar barra_dibujo;
	public static String estado = "";
	public static Border borde = ( BorderFactory.createEtchedBorder() );
	public static Border borde2 = ( BorderFactory.createLoweredBevelBorder() );
	public static ButtonGroup grupoBotones;
	public static JToggleButton lapiz, borrador, poligono, rect, rect2, circulo, rect_lleno, rect2_lleno, circulo_lleno, linea, texto, gotero;
	public static JButton color_sel, color2_sel;
	public static ImageIcon lapiz_icono, borrador_icono, poligono_icono, rect_icono, rect2_icono, circulo_icono, 
	rectlleno_icono, rect2lleno_icono, circulolleno_icono, linea_icono, texto_icono, gotero_icono, colorsel_icono;

	public BarraDibujo(){
		barra_dibujo = new JToolBar("Barra de Dibujo", JToolBar.VERTICAL);
		barra_dibujo.addMouseListener(this);
		barra_dibujo.setFloatable(false);
	
		lapiz_icono				= new ImageIcon("iconos/lapiz.png");
		borrador_icono		= new ImageIcon("iconos/borrador.png");
		poligono_icono			= new ImageIcon("iconos/poligono.png");
		rect_icono				= new ImageIcon("iconos/rectangulo.png");
		rect2_icono			= new ImageIcon("iconos/redondeado.png");
		circulo_icono			= new ImageIcon("iconos/circulo.png");
		rectlleno_icono		= new ImageIcon("iconos/rectangulo_lleno.png");
		rect2lleno_icono		= new ImageIcon("iconos/redondeado_lleno.png");
		circulolleno_icono		= new ImageIcon("iconos/circulo_lleno.png");
		linea_icono				= new ImageIcon("iconos/linea.png");
		texto_icono			= new ImageIcon("iconos/texto.png");
		gotero_icono			= new ImageIcon("iconos/gotero.png");
		colorsel_icono			= new ImageIcon("iconos/transparente.png");
	
		lapiz	      = new JToggleButton(lapiz_icono);
		borrador      = new JToggleButton(borrador_icono);
		poligono      = new JToggleButton(poligono_icono);
		rect	      = new JToggleButton(rect_icono);
		rect2	      = new JToggleButton(rect2_icono);
		circulo	      = new JToggleButton(circulo_icono);
		rect_lleno    = new JToggleButton(rectlleno_icono);
		rect2_lleno   = new JToggleButton(rect2lleno_icono);
		circulo_lleno = new JToggleButton(circulolleno_icono);
		linea	      = new JToggleButton(linea_icono);
		texto	      = new JToggleButton(texto_icono);
		gotero	      = new JToggleButton(gotero_icono);
		color_sel     = new JButton(colorsel_icono);
		color2_sel    = new JButton(colorsel_icono);
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(lapiz);
		grupoBotones.add(borrador);
		grupoBotones.add(poligono);
		grupoBotones.add(rect);
		grupoBotones.add(rect2);
		grupoBotones.add(circulo);
		grupoBotones.add(rect_lleno);
		grupoBotones.add(rect2_lleno);
		grupoBotones.add(circulo_lleno);
		grupoBotones.add(linea);
		grupoBotones.add(texto);
		grupoBotones.add(gotero);
		
		color_sel.setEnabled(false);
		color2_sel.setEnabled(false);
		color_sel.setBackground(BarraColores.color);
		color2_sel.setBackground(BarraColores.color2);
		
		lapiz.setToolTipText("Lápiz");
		borrador.setToolTipText("Borrador");
		poligono.setToolTipText("Polígono");
		rect.setToolTipText("Rectángulo");
		rect2.setToolTipText("Rectángulo redondeado");
		circulo.setToolTipText("Círculo");
		rect_lleno.setToolTipText("Rectángulo relleno");
		rect2_lleno.setToolTipText("Rectángulo redondeado relleno");
		circulo_lleno.setToolTipText("Círculo relleno");
		linea.setToolTipText("Línea");
		texto.setToolTipText("Texto");
		gotero.setToolTipText("Gotero");
		color_sel.setToolTipText("Color principal");
		color2_sel.setToolTipText("Color secundario");
		
		lapiz.setBorder(borde);
		borrador.setBorder(borde);
		poligono.setBorder(borde);
		rect.setBorder(borde);
		rect2.setBorder(borde);
		circulo.setBorder(borde);
		rect_lleno.setBorder(borde);
		rect2_lleno.setBorder(borde);
		circulo_lleno.setBorder(borde);
		linea.setBorder(borde);
		texto.setBorder(borde);
		gotero.setBorder(borde);
		color_sel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		color2_sel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		lapiz.addActionListener(this);
		borrador.addActionListener(this);
		poligono.addActionListener(this);
		rect.addActionListener(this);
		rect2.addActionListener(this);
		circulo.addActionListener(this);
		rect_lleno.addActionListener(this);
		rect2_lleno.addActionListener(this);
		circulo_lleno.addActionListener(this);
		linea.addActionListener(this);
		texto.addActionListener(this);
		gotero.addActionListener(this);
		
		lapiz.addMouseListener(this);
		borrador.addMouseListener(this);
		poligono.addMouseListener(this);
		rect.addMouseListener(this);
		rect2.addMouseListener(this);
		circulo.addMouseListener(this);
		rect_lleno.addMouseListener(this);
		rect2_lleno.addMouseListener(this);
		circulo_lleno.addMouseListener(this);
		linea.addMouseListener(this);
		texto.addMouseListener(this);
		gotero.addMouseListener(this);
		
		barra_dibujo.add(lapiz);
		barra_dibujo.add(borrador);
		//barra_dibujo.add(poligono);
		barra_dibujo.add(rect);
		barra_dibujo.add(rect2);
		barra_dibujo.add(circulo);
		barra_dibujo.add(rect_lleno);
		barra_dibujo.add(rect2_lleno);
		barra_dibujo.add(circulo_lleno);
		barra_dibujo.add(linea);
		//barra_dibujo.add(texto);
		//barra_dibujo.add(gotero);
		barra_dibujo.add(Box.createHorizontalStrut(10));
		barra_dibujo.add(color_sel);
		barra_dibujo.add(color2_sel);
	}
	
	public void mousePressed(MouseEvent event){}
	public void mouseDragged(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
	public void mouseClicked(MouseEvent event){
		if(event.getButton()==MouseEvent.BUTTON1){
			if(event.getSource()==borrador){
				Papel.eraserLength = Papel.eraserLength + 5;
			}
		}
		if(event.getButton()==MouseEvent.BUTTON3){
			if(event.getSource()==borrador){
				Papel.eraserLength = Papel.eraserLength - 5;
			}
		}
	}
	public void mouseEntered(MouseEvent event){
		if(event.getSource()==barra_dibujo){
			BarraEstado.estado_label.setText(null);
		}
		if(event.getSource()==lapiz){
			BarraEstado.estado_label.setText(" Dibuja una línea de forma libre de un píxel de ancho.");
		}
		if(event.getSource()==borrador){
			BarraEstado.estado_label.setText(" Borra una parte de la imagen.");
		}
		if(event.getSource()==poligono){
			BarraEstado.estado_label.setText(" Dibuja un polígono sin relleno.");
		}
		if(event.getSource()==rect){
			BarraEstado.estado_label.setText(" Dibuja un rectángulo sin relleno.");
		}
		if(event.getSource()==rect2){
			BarraEstado.estado_label.setText(" Dibuja un rectángulo de esquinas redondeadas sin relleno.");
		}
		if(event.getSource()==circulo){
			BarraEstado.estado_label.setText(" Dibuja un círculo sin relleno.");
		}
		if(event.getSource()==rect_lleno){
			BarraEstado.estado_label.setText(" Dibuja un rectángulo con relleno.");
		}
		if(event.getSource()==rect2_lleno){
			BarraEstado.estado_label.setText(" Dibuja un rectángulo de esquinas redondeadas con relleno.");
		}
		if(event.getSource()==circulo_lleno){
			BarraEstado.estado_label.setText(" Dibuja un círculo con relleno.");
		}
		if(event.getSource()==linea){
			BarraEstado.estado_label.setText(" Dibuja una línea recta.");
		}
		if(event.getSource()==texto){
			BarraEstado.estado_label.setText(" Inserta texto dentro de la magen.");
		}
		if(event.getSource()==gotero){
			BarraEstado.estado_label.setText(" Rellena un área con el color del dibujo actual.");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==lapiz)
			estado = "Lapiz";
		if(e.getSource()==borrador)
			estado = "Borrador";
		if(e.getSource()==poligono)
			estado = "Poligono";
		if(e.getSource()==rect)
			estado = "Rect";
		if(e.getSource()==rect2)
			estado = "Rect2";
		if(e.getSource()==circulo)
			estado = "Circulo";
		if(e.getSource()==rect_lleno)
			estado = "Rect_lleno";
		if(e.getSource()==rect2_lleno)
			estado = "Rect2_lleno";
		if(e.getSource()==circulo_lleno)
			estado = "Circulo_lleno";
		if(e.getSource()==linea)
			estado = "Linea";
		if(e.getSource()==texto)
			estado = "Texto";
		if(e.getSource()==gotero)
			estado = "Gotero";
	}
}
