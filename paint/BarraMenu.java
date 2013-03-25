import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BarraMenu extends JMenuBar implements ActionListener, MouseListener, ItemListener{

	public static JMenu archivo_menu, ver_menu, colores_menu, ventana_menu, ayuda_menu;
	public static JMenuItem archivo_nuevo, archivo_salir, colores_plano, colores_plano2, colores_fondo, ventana_ajustar, ayuda_acerca;
	public static JCheckBoxMenuItem ver_botones, ver_colores, ver_estado, ver_barras;

	public BarraMenu(){
		super();
		addMouseListener(this);
	
		archivo_nuevo		= new JMenuItem("Nuevo");
		archivo_salir		= new JMenuItem("Salir");
		ver_botones		= new JCheckBoxMenuItem("Barra de Dibujo", true);
		ver_colores		= new JCheckBoxMenuItem("Barra de Colores", true);
		ver_estado		= new JCheckBoxMenuItem("Barra de Estado", true);
		ver_barras		= new JCheckBoxMenuItem("Barras Flotantes");
		colores_plano		= new JMenuItem("Principal");
		colores_plano2		= new JMenuItem("Secundario");
		colores_fondo		= new JMenuItem("Fondo");
		ventana_ajustar		= new JMenuItem("Ajustar tamaño");
		ayuda_acerca		= new JMenuItem("Acerca de...");
		
		archivo_nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		archivo_salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		colores_plano.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		colores_plano2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		colores_fondo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		
		archivo_nuevo.addActionListener(this);
		archivo_salir.addActionListener(this);
		ver_botones.addItemListener(this);
		ver_colores.addItemListener(this);
		ver_estado.addItemListener(this);
		ver_barras.addItemListener(this);
		colores_plano.addActionListener(this);
		colores_plano2.addActionListener(this);
		colores_fondo.addActionListener(this);
		ventana_ajustar.addActionListener(this);
		ayuda_acerca.addActionListener(this);
		
		archivo_nuevo.addMouseListener(this);
		archivo_salir.addMouseListener(this);
		ver_botones.addMouseListener(this);
		ver_colores.addMouseListener(this);
		ver_estado.addMouseListener(this);
		ver_barras.addMouseListener(this);
		colores_plano.addMouseListener(this);
		colores_plano2.addMouseListener(this);
		colores_fondo.addMouseListener(this);
		ventana_ajustar.addMouseListener(this);
		ayuda_acerca.addMouseListener(this);
		
		archivo_menu = new JMenu("Archivo");
		archivo_menu.addMouseListener(this);
		archivo_menu.add(archivo_nuevo);
		archivo_menu.addSeparator();
		archivo_menu.add(archivo_salir);
		
		ver_menu = new JMenu("Ver");
		ver_menu.addMouseListener(this);
		ver_menu.add(ver_botones);
		ver_menu.add(ver_colores);
		ver_menu.add(ver_estado);
		ver_menu.addSeparator();
		ver_menu.add(ver_barras);
		
		colores_menu = new JMenu("Color");
		colores_menu.addMouseListener(this);
		colores_menu.add(colores_plano);
		colores_menu.add(colores_plano2);
		colores_menu.add(colores_fondo);
		
		ventana_menu = new JMenu("Ventana");
		ventana_menu.addMouseListener(this);
		ventana_menu.add(ventana_ajustar);
		
		ayuda_menu = new JMenu("Ayuda");
		ayuda_menu.addMouseListener(this);
		ayuda_menu.add(ayuda_acerca);
		
		archivo_menu.setMnemonic('A');
		ver_menu.setMnemonic('V');
		colores_menu.setMnemonic('C');
		ventana_menu.setMnemonic('E');
		ayuda_menu.setMnemonic('Y');
		
		add(archivo_menu);
		add(ver_menu);
		add(colores_menu);
		add(ventana_menu);
		add(ayuda_menu);
	}
	
	public void mousePressed(MouseEvent event){}
	public void mouseDragged(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
	public void mouseClicked(MouseEvent event){}
	public void mouseEntered(MouseEvent event){
		if(event.getSource()==this){
			BarraEstado.estado_label.setText(null);
		}
			if(event.getSource()==archivo_menu){
				BarraEstado.estado_label.setText(null);
			}
			if(event.getSource()==ver_menu){
				BarraEstado.estado_label.setText(null);
			}
			if(event.getSource()==colores_menu){
				BarraEstado.estado_label.setText(null);
			}
			if(event.getSource()==ventana_menu){
				BarraEstado.estado_label.setText(null);
			}
			if(event.getSource()==ayuda_menu){
				BarraEstado.estado_label.setText(null);
			}
	/*---------------------------------------------------------------*/
		if(event.getSource()==archivo_nuevo){
			BarraEstado.estado_label.setText(" Crea un archivo nuevo.");
		}
		if(event.getSource()==archivo_salir){
			BarraEstado.estado_label.setText(" Cierra el programa.");
		}
		if(event.getSource()==ver_botones){
			BarraEstado.estado_label.setText(" Muestra u oculta la barra de dibujo.");
		}
		if(event.getSource()==ver_colores){
			BarraEstado.estado_label.setText(" Muestra u oculta la barra de colores.");
		}
		if(event.getSource()==ver_estado){
			BarraEstado.estado_label.setText(" Muestra u oculta la barra de estado.");
		}
		if(event.getSource()==ver_barras){
			BarraEstado.estado_label.setText(" Permite que las barras cambien de lugar.");
		}
		if(event.getSource()==colores_plano){
			BarraEstado.estado_label.setText(" Selecciona el color principal.");
		}
		if(event.getSource()==colores_plano2){
			BarraEstado.estado_label.setText(" Selecciona el color secundario.");
		}
		if(event.getSource()==colores_fondo){
			BarraEstado.estado_label.setText(" Selecciona el color de fondo.");
		}
		if(event.getSource()==ventana_ajustar){
			BarraEstado.estado_label.setText(" Modifica el tamaño de la ventana.");
		}
		if(event.getSource()==ayuda_acerca){
			BarraEstado.estado_label.setText(" Muestra la información del programa.");
		}
	}
	
	public void itemStateChanged(ItemEvent event){
		boolean isSelected = (event.getStateChange() == ItemEvent.SELECTED);
		boolean isNotSelected = (event.getStateChange() == ItemEvent.DESELECTED);
		
		if(event.getItemSelectable() == ver_botones){
			if(isSelected){
				BarraDibujo.barra_dibujo.setVisible(true);
			}
			if(isNotSelected){
				BarraDibujo.barra_dibujo.setVisible(false);
			}
		}
		
		if(event.getItemSelectable() == ver_colores){
			if(isSelected){
				BarraColores.barra_colores.setVisible(true);
			}
			if(isNotSelected){
				BarraColores.barra_colores.setVisible(false);
			}
		}
		
		if(event.getItemSelectable() == ver_estado){
			if(isSelected){
				BarraEstado.barra_estado.setVisible(true);
			}
			if(isNotSelected){
				BarraEstado.barra_estado.setVisible(false);
			}
		}
		
		if(event.getItemSelectable() == ver_barras){
			if(isSelected){
				BarraDibujo.barra_dibujo.setFloatable(true);
				BarraColores.barra_colores.setFloatable(true);
			}
			if(isNotSelected){
				BarraDibujo.barra_dibujo.setFloatable(false);
				BarraColores.barra_colores.setFloatable(false);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==archivo_nuevo){
			Dibujar.papel.setBackground(Color.WHITE);
			Dibujar.papel.repaint();
		}
		if(e.getSource()==archivo_salir){
			System.exit(0);
		}
	/*---------------------------------------------------------------*/
		if(e.getSource()==colores_plano){
			BarraColores.color = JColorChooser.showDialog(null, "Escoja el color principal", getForeground());
			BarraDibujo.color_sel.setBackground(BarraColores.color);
		}
		if(e.getSource()==colores_plano2){
			BarraColores.color2 = JColorChooser.showDialog(null, "Escoja el color secundario", getForeground());
			BarraDibujo.color2_sel.setBackground(BarraColores.color2);
		}
		if(e.getSource()==colores_fondo){
			BarraColores.fondo = JColorChooser.showDialog(null, "Escoja el color de fondo", getBackground());
			Dibujar.papel.setBackground(BarraColores.fondo);
		}
	/*---------------------------------------------------------------*/
		if(e.getSource()==ventana_ajustar){
			Dibujar.ajustar_frame.setVisible(true);
		}
	/*---------------------------------------------------------------*/
		if(e.getSource()==ayuda_acerca){
			JOptionPane.showMessageDialog(null, "Autor:\nJosé Darío Lumbreras Márquez\n28 de Julio del 2009", "Dibujar", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}