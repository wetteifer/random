import java.awt.*;
import javax.swing.*;

public class BarraEstado{

	public static JPanel barra_estado;
	public static JLabel estado_label, info_label;

	public BarraEstado(){
		barra_estado = new JPanel( new BorderLayout() );
		barra_estado.setBorder( BorderFactory.createEtchedBorder() );
		
		estado_label = new JLabel(" ");
		info_label = new JLabel("11/08/2009 ");
		barra_estado.add(estado_label, BorderLayout.WEST);
		barra_estado.add(info_label, BorderLayout.EAST);
	}
}