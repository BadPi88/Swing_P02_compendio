/**
 * DatosHabitacion.java
 * 16 nov 2024 17:10:44
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/**
 * 
 */

public class DatosHabitacion extends JPanel implements ActionListener, FocusListener {

	private JLabel etiquetaTitulo, etiquetaNumHab, etiquetaTipoHab, etiquetaTieneNinios, etiquetaPrecio;
	static JTextField campoPrecioCalculado;
	static JComboBox<String> comboProvincia, comboTipoHabitacion;
	static JSpinner spinnerNumHabitaciones, spinnerEdadNinios;
	static JCheckBox checkBoxTieneNinios;
	private PanelNinios panelNinios;
	private SpinnerModel spinnerModelValores;
	private ImageIcon imagenIcono;
	private Image imagenModificada, apoyoImagen;
	private JLabel imagenHotel, imagenHabitacion, imagenVistaHotel;
	Box cajaH5 = Box.createHorizontalBox();

	public DatosHabitacion() {
		this.setLayout(new GridLayout());

		etiquetaTitulo = new JLabel("Datos del Alojamiento");
		etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 20));

		etiquetaTipoHab = new JLabel("Tipo de Habitación: ");
		comboTipoHabitacion = new JComboBox<>(obtenerTiposHabitacion());
		comboTipoHabitacion.addActionListener(e -> actualizarPrecio());

		spinnerModelValores = new SpinnerNumberModel(0, 0, 50, 1);
		etiquetaNumHab = new JLabel("Numero de habitaciones: ");
		spinnerNumHabitaciones = new JSpinner(spinnerModelValores);
		// actualizar precio cuando cambie el número de habitaciones
		spinnerNumHabitaciones.addChangeListener(e -> actualizarPrecio());

		etiquetaTieneNinios = new JLabel("¿Niños?");
		checkBoxTieneNinios = new JCheckBox();

		// Actualizar precio cuando cambie el checkbox de niños
		checkBoxTieneNinios.addActionListener(e -> actualizarPrecio());

		panelNinios = new PanelNinios();

		etiquetaPrecio = new JLabel("Importe Habitacion: ");
		campoPrecioCalculado = new JTextField(25);
		campoPrecioCalculado.addFocusListener(this);
		campoPrecioCalculado.setEditable(false);

		// Crear las box
		Box cajaH1 = Box.createHorizontalBox();
		Box cajaH3 = Box.createHorizontalBox();
		Box cajaH4 = Box.createHorizontalBox();

		Box cajaH6 = Box.createHorizontalBox();
		Box cajaH7 = Box.createHorizontalBox();
		Box cajaVertical = Box.createVerticalBox();

		// Agregar los componentes a las box
		cajaVertical.add(Box.createVerticalStrut(10));
		cajaH1.add(etiquetaTitulo);

		cajaVertical.add(cajaH1);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH3.add(etiquetaTipoHab);
		cajaH3.add(comboTipoHabitacion);
		cajaH3.add(Box.createHorizontalStrut(10));

		cajaH3.add(Box.createHorizontalStrut(10));
		cajaH3.add(etiquetaNumHab);
		cajaH3.add(spinnerNumHabitaciones);

		cajaVertical.add(cajaH3);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH4.add(etiquetaTieneNinios);
		cajaH4.add(checkBoxTieneNinios);

		cajaVertical.add(cajaH4);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH5.add(panelNinios);
		checkBoxTieneNinios.addActionListener(this);

		// Ocultarlo inicialmente
		cajaH5.setVisible(false);

		cajaVertical.add(cajaH5);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH6.add(Box.createHorizontalStrut(30));
		cajaH6.add(etiquetaPrecio);
		cajaH6.add(campoPrecioCalculado);

		actualizarPrecio();
		this.add(cajaH6);

		cajaVertical.add(cajaH6);
		cajaVertical.add(Box.createVerticalStrut(10));

		Color colorBordeFotos = new Color(204, 255, 204);
		// imagenes
		imagenIcono = new ImageIcon(getClass().getResource("/recursos/hotel-lobby.jpg"));
		apoyoImagen = imagenIcono.getImage();
		imagenModificada = apoyoImagen.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagenIcono = new ImageIcon(imagenModificada);
		imagenHotel = new JLabel(imagenIcono);

		imagenHotel.setBorder(new LineBorder(Color.BLACK, 2));

		imagenIcono = new ImageIcon(getClass().getResource("/recursos/bed-hotel.jpg"));
		apoyoImagen = imagenIcono.getImage();
		imagenModificada = apoyoImagen.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagenIcono = new ImageIcon(imagenModificada);
		imagenHabitacion = new JLabel(imagenIcono);

		imagenHabitacion.setBorder(new LineBorder(Color.BLACK, 2));

		imagenIcono = new ImageIcon(getClass().getResource("/recursos/hotelvista.jpg"));
		apoyoImagen = imagenIcono.getImage();
		imagenModificada = apoyoImagen.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagenIcono = new ImageIcon(imagenModificada);
		imagenVistaHotel = new JLabel(imagenIcono);

		imagenHotel.setBorder(BorderFactory.createLineBorder(colorBordeFotos, 2));
		imagenHabitacion.setBorder(BorderFactory.createLineBorder(colorBordeFotos, 2));
		imagenVistaHotel.setBorder(BorderFactory.createLineBorder(colorBordeFotos, 2));
		cajaH7.add(imagenHotel);
		cajaH7.add(imagenHabitacion);
		cajaH7.add(imagenVistaHotel);

		cajaVertical.add(cajaH7);

		this.add(cajaVertical);

		// Color #66ffcc
		this.setBackground(new Color(102, 255, 204));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Muestra u oculta el panel de extras para niños
		if (checkBoxTieneNinios.isSelected()) {
			cajaH5.setVisible(true);
		} else {
			cajaH5.setVisible(false);
		}
	}

	private String[] obtenerTiposHabitacion() {
		return new String[] { "Seleccionar", "Simple", "Doble", "Suite" };
	}

	static void actualizarPrecio() {
		// Precios base por tipo de habitación
		double precioBase = 0.0;

		// Asegúrate de que el valor de DatosPersonales.diasEstancia esté actualizado
		int diasEstancia = (int) DatosPersonales.diasEstancia; // Obtener días de estancia actualizados

		// Obtener el tipo de habitación seleccionada
		String tipoHabitacion = (String) comboTipoHabitacion.getSelectedItem();
		if ("Simple".equals(tipoHabitacion)) {
			precioBase = 50;
		} else if ("Doble".equals(tipoHabitacion)) {
			precioBase = 80;
		} else if ("Suite".equals(tipoHabitacion)) {
			precioBase = 120;
		}

		// Número de habitaciones
		int numHabitaciones = (Integer) spinnerNumHabitaciones.getValue();

		// Precio por niños
		int precioNinio = 0;
		if (checkBoxTieneNinios.isSelected()) {
			precioNinio = 20;
		}

		// Cálculo del precio total
		int precioTotal = (int) ((precioBase + precioNinio) * numHabitaciones * DatosPersonales.diasEstancia);

		// Actualizar el campo de precio calculado

		campoPrecioCalculado.setText(String.valueOf(precioTotal));
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
