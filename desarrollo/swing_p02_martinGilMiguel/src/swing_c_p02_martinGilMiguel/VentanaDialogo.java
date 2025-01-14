/**
 * VentanaDialogo.java
 * 17 nov 2024 12:39:57
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * 
 */
public class VentanaDialogo extends JDialog implements ActionListener {

	private PanelTitulo panelTitulo;
	private DatosPersonales panelDatosCliente;
	private DatosHabitacion panelDatosAlojamiento;
	private PanelReserva panelFicha;
	private JButton btnImprimir, btnLimpiar, btnGuardar;
	private Box cajaDatos, cajaHorizontal;
	private JScrollPane scrollPane;

	public VentanaDialogo(Ventana miVentana, boolean modal) {

		super(miVentana, modal);

		this.setTitle("Alta de Reservas");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla;
		try {
			tamanoPantalla = miPantalla.getScreenSize();
		} catch (HeadlessException e) {
			// Tamaño por defecto por si ecnontrase un error al obtener screensize
			e.printStackTrace();
			tamanoPantalla = new Dimension(800, 600);
		}

		// Guardamos en dos variables el alto y ancho de nuestra pantalla
		int altoPantalla = (int) (tamanoPantalla.height / 1.03);
		int anchoPantalla = tamanoPantalla.width;

		// Queremos que la ventana sea igual a la resolución de la pantalla
		this.setSize(anchoPantalla, altoPantalla);

		// Ventana en el centro de la pantalla
		setLocationRelativeTo(null);

		// Añadimos Logo
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/logo_hotel.png"));
		setIconImage(icono.getImage());
		iniciarComponentes();
	}

	private void iniciarComponentes() {

		cajaDatos = Box.createVerticalBox();
		cajaHorizontal = Box.createHorizontalBox();

		panelTitulo = new PanelTitulo();
		Color colorBorde1 = new Color(180, 184, 165); // Creamos un borde con tonalidad más oscura que el color de fondo
		panelTitulo.setBorder(BorderFactory.createLineBorder(colorBorde1, 4));

		panelDatosCliente = new DatosPersonales();
		Color colorBorde2 = new Color(177, 169, 211);
		panelDatosCliente.setBorder(BorderFactory.createLineBorder(colorBorde2, 4));

		panelDatosAlojamiento = new DatosHabitacion();
		Color colorBorde3 = new Color(139, 159, 151);
		panelDatosAlojamiento.setBorder(BorderFactory.createLineBorder(colorBorde3, 4));

		panelFicha = new PanelReserva();
		Color colorBorde4 = new Color(63, 176, 178);
		panelFicha.setBorder(BorderFactory.createDashedBorder(colorBorde4));

		ImageIcon imagenImprimir = new ImageIcon(getClass().getResource("/recursos/impresion.png"));
		Image imgImprimir = imagenImprimir.getImage(); // Obtener la imagen
		// Redimensionar la imagen
		Image imgImprimirRedimensionada = imgImprimir.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		// Crear un nuevo ImageIcon con la imagen redimensionada
		imagenImprimir = new ImageIcon(imgImprimirRedimensionada);

		btnImprimir = new JButton(imagenImprimir); // Asignar el ImageIcon redimensionado al JButton

		btnImprimir.setToolTipText("Imprimir Datos"); // Muestra el texto al pasar por encima del componente
		btnImprimir.addActionListener(this);
		btnImprimir.setOpaque(true);
		btnImprimir.setBackground(colorBorde1);

		// Redimensionar la imagen de limpiar
		ImageIcon imagenLimpiar = new ImageIcon(getClass().getResource("/recursos/limpieza-de-datos.png"));
		Image imgLimpiar = imagenLimpiar.getImage(); // Obtener la imagen
		Image imgLimpiarRedimensionada = imgLimpiar.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Redimensionar la
																									// imagen
		imagenLimpiar = new ImageIcon(imgLimpiarRedimensionada); // Crear un nuevo ImageIcon con la imagen
																	// redimensionada
		btnLimpiar = new JButton(imagenLimpiar);
		btnLimpiar.setToolTipText("Limpiar Datos");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBackground(colorBorde2);

		// Redimensionar la imagen de guardar
		ImageIcon imagenGuardar = new ImageIcon(getClass().getResource("/recursos/salvar.png"));
		Image imgGuardar = imagenGuardar.getImage(); // Obtener la imagen
		Image imgGuardarRedimensionada = imgGuardar.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		imagenGuardar = new ImageIcon(imgGuardarRedimensionada);

		btnGuardar = new JButton(imagenGuardar);
		btnGuardar.setToolTipText("Guardar Datos");
		btnGuardar.addActionListener(this);
		btnGuardar.setOpaque(true);
		btnGuardar.setBackground(colorBorde3);

		// Añadimos paneles
		cajaDatos.add(panelTitulo);
		cajaDatos.add(panelDatosCliente);
		cajaDatos.add(panelDatosAlojamiento);
		cajaDatos.add(panelFicha);

		// Añadimos botones
		cajaHorizontal.add(btnImprimir);
		cajaHorizontal.add(Box.createHorizontalStrut(5));
		cajaHorizontal.add(btnLimpiar);
		cajaHorizontal.add(Box.createHorizontalStrut(5));
		cajaHorizontal.add(btnGuardar);

		cajaDatos.add(cajaHorizontal);

		// this.add(cajaDatos);

		// Al scrollPane le asignamos la vista a nuestra cajaDatos y lo añadimos a la
		// ventana
		scrollPane = new JScrollPane(cajaDatos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnImprimir) {
			StringBuilder datosCliente = new StringBuilder();
			datosCliente.append("Nombre: ").append(DatosPersonales.campoNombre.getText()).append("\n")
					.append("Apellidos: ").append(DatosPersonales.campoApellidos.getText()).append("\n").append("DNI: ")
					.append(DatosPersonales.campoDni.getText()).append("\n").append("Teléfono: ")
					.append(DatosPersonales.campoTelefono.getText()).append("\n");

			PanelReserva.datosCliente.setText(datosCliente.toString());

			StringBuilder datosAlojamiento = new StringBuilder();
			datosAlojamiento.append("Tipo de habitacion: ")
					.append(DatosHabitacion.comboTipoHabitacion.getSelectedItem()).append("\n")
					.append("¿Tiene niños?: ");

			if (DatosHabitacion.checkBoxTieneNinios.isSelected()) {
				datosAlojamiento.append("Sí\n").append("Edad de los niños: ").append(PanelNinios.edadNinios.getValue())
						.append("\n").append("Extra: ").append(PanelNinios.extras.getText()).append("\n");
			} else {
				datosAlojamiento.append("No\n");
			}

			datosAlojamiento.append("Precio de la Reserva: ").append(DatosHabitacion.campoPrecioCalculado.getText())
					.append("\n");

			PanelReserva.datosAlojamiento.setText(datosAlojamiento.toString());
		}

		if (e.getSource() == btnLimpiar) {

			DatosHabitacion.comboTipoHabitacion.setSelectedIndex(0);
			DatosHabitacion.spinnerNumHabitaciones.setValue(0);
			DatosHabitacion.checkBoxTieneNinios.setSelected(false);

			DatosPersonales.campoNombre.setText("");
			DatosPersonales.campoApellidos.setText("");
			DatosPersonales.campoDni.setText("");
			DatosPersonales.campoTelefono.setText("");

			PanelNinios.edadNinios.setValue(0);
			PanelNinios.extras.setText("");
			DatosPersonales.campoNombre.requestFocusInWindow();
		}

		if (e.getSource() == btnGuardar) {

			JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "", JOptionPane.INFORMATION_MESSAGE);

		}
	}
}