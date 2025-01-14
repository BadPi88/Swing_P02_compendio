/**
 * FichaReserva.java
 * 15 nov 2024 12:30:22
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * 
 */
public class PanelReserva extends JTabbedPane{

	private JPanel panelCliente, panelAlojamiento;
	private JLabel lbCliente, etiqAlojamiento;
	private String datos;
	static JTextArea datosCliente, datosAlojamiento;
	
	public PanelReserva() {
        
        this.setBackground(new Color(153, 255, 204)); 

        informacionCliente();
        informacionAlojamiento();

        this.add("Datos del Cliente", panelCliente);
        this.add("Datos del Alojamiento", panelAlojamiento);

        // Cambia el color de fondo de la segunda pestaña
        this.setBackgroundAt(1, new Color(51, 153, 153));
    }

    private void informacionCliente() {
    	
        panelCliente = new JPanel();
        panelCliente.setBackground(new Color(250, 255, 255));
        

        lbCliente = new JLabel("Datos del Cliente:");
        lbCliente.setForeground(new Color(51, 153, 153)); 

        datos = "";
        datosCliente = new JTextArea(datos);
        datosCliente.setEditable(false);

        panelCliente.add(lbCliente);
        panelCliente.add(datosCliente);
        this.add(panelCliente);
    }

    private void informacionAlojamiento() {
    	
        panelAlojamiento = new JPanel();
        panelAlojamiento.setBackground(new Color(255, 255, 255)); 
        panelAlojamiento.setBorder(new EmptyBorder(10, 10, 10, 10));

        etiqAlojamiento = new JLabel("Datos del Alojamiento:");
        etiqAlojamiento.setForeground(new Color(51, 153, 153));

        datos = "";
        datosAlojamiento = new JTextArea(datos);
        datosAlojamiento.setEditable(false);

        panelAlojamiento.add(etiqAlojamiento);
        panelAlojamiento.add(datosAlojamiento);
        this.add(panelAlojamiento);
    }
}

