/**
 * PanelTitulo.java
 * 15 nov 2024 11:18:35
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class PanelTitulo extends JPanel {
	private JLabel titulo, icono;
	private ImageIcon imagen;
	private Image logo, imagenModificada;

	public PanelTitulo() {

		titulo = new JLabel("Hotel Aquamarine ");
		titulo.setFont(new Font("Arial", Font.BOLD, 48));

		imagen = new ImageIcon(getClass().getResource("/recursos/logo_hotel.png"));
		logo = imagen.getImage();
		imagenModificada = logo.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		imagen = new ImageIcon(imagenModificada);
		icono = new JLabel(imagen);

		this.add(titulo);
		this.add(icono);

		this.setBackground(new Color(51, 153, 255));
	}
}
