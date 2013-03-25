import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dibujar extends JFrame implements ActionListener{
	
	//Clases
	public static BarraMenu barraMenu = new BarraMenu();
	public static BarraColores barraColores = new BarraColores();
	public static BarraDibujo barraDibujo = new BarraDibujo();
	public static BarraEstado barraEstado = new BarraEstado();
	public static Papel papel = new Papel();
	
	//Ajustar_ventana
	public static JFrame ajustar_frame;
	public static JPanel panel_grid, panel_flow;
	public static JButton aceptar_button;
	public static JLabel ancho_label, alto_label;
	public static JTextField ancho_text, alto_text;
	
	//Ventana
	public static JPanel ventana_panel;

	public Dibujar(){
		super("Dibujar");
		setJMenuBar(barraMenu);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout( new BorderLayout() );
		setIconImage(new ImageIcon("iconos/ventana_icono.png").getImage());
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		JPanel pane = new JPanel( new BorderLayout() );
		pane.setBorder(BorderFactory.createEtchedBorder());
		pane.add(papel, BorderLayout.CENTER);

		ventana_panel = new JPanel( new BorderLayout() );
		ventana_panel.add(barraDibujo.barra_dibujo, BorderLayout.WEST);
		ventana_panel.add(pane, BorderLayout.CENTER);
		ventana_panel.add(barraColores.barra_colores, BorderLayout.SOUTH);
	
		getContentPane().add(ventana_panel, BorderLayout.CENTER);
		getContentPane().add(barraEstado.barra_estado, BorderLayout.SOUTH);
		pack();
		
	/*------------------------------------------------------*/
	
		ajustar_frame = new JFrame("Ajustar");
		ajustar_frame.setResizable(false);
		ajustar_frame.setUndecorated(true);
		ajustar_frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		ancho_label = new JLabel("Ancho:", JLabel.CENTER);
		alto_label = new JLabel("Alto:", JLabel.CENTER);
		ancho_text = new JTextField(10);
		alto_text = new JTextField(10);
		aceptar_button = new JButton("Aceptar");
		
		panel_grid = new JPanel( new GridLayout(2,2) );
		panel_grid.add(ancho_label);
		panel_grid.add(ancho_text);
		panel_grid.add(alto_label);
		panel_grid.add(alto_text);
		
		panel_flow = new JPanel( new FlowLayout() );
		panel_flow.add(aceptar_button);
		
		aceptar_button.addActionListener(this);
		
		ajustar_frame.add(panel_grid, BorderLayout.NORTH);
		ajustar_frame.add(panel_flow, BorderLayout.CENTER);
		ajustar_frame.setSize(150,110);
	}
	
	public void actionPerformed(ActionEvent event){
		int ancho = Integer.parseInt( ancho_text.getText() );
		int alto = Integer.parseInt( alto_text.getText() );
		if(event.getSource()==aceptar_button){
			setSize( new Dimension(ancho, alto) );
			ajustar_frame.setVisible(false);
		}
	}
	
	public static void main(String args[]){
		new Dibujar().setVisible(true);
	}
}