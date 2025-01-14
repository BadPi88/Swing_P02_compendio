/**
 * AltaReservas.java
 * 17 nov 2024 10:02:59
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
public class AltaReservas extends JDialog implements ActionListener {

	private PanelTitulo panelTitulo;
	private DatosPersonales datosCliente;
	private DatosHabitacion panelDatosAlojamiento;
	private PanelReserva panelFicha; // panelImprimirDatos
	private JButton btnImprimir, btnLimpiar, btnGuardar;
	private Box cajaDatos, cajaHorizontal;
	private JScrollPane scrollPane;

	public AltaReservas(Ventana miVentana, boolean modal) throws IOException {
		super(miVentana, modal);
		configPantalla();
		this.setTitle("Alta de Reservas");
		iniciarComponentes();
	}

	private void configPantalla() throws IOException {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla;
		tamanoPantalla = miPantalla.getScreenSize();

		// Guardamos en dos variables el alto y ancho de nuestra pantalla
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		// Queremos que la ventana sea igual a la resolución de la pantalla
		this.setSize(anchoPantalla / 2, altoPantalla / 2); // Establecer tamaño adecuado

		// Ventana en el centro de la pantalla
		setLocationRelativeTo(null);

		// Añadimos Logo
		Image miIcono = miPantalla.getImage(getClass().getResource("/recursos/logo.png"));
		this.setIconImage(miIcono);
	}

	private void iniciarComponentes() {

		// Usamos BoxLayout para organizar los paneles vertical y horizontalmente
		cajaDatos = Box.createVerticalBox();
		cajaHorizontal = Box.createHorizontalBox();

		panelTitulo = new PanelTitulo();
		Color colorBorde1 = new Color(180, 184, 165); // Borde con tonalidad más oscura
		panelTitulo.setBorder(BorderFactory.createLineBorder(colorBorde1, 4));

		datosCliente = new DatosPersonales();
		Color colorBorde2 = new Color(177, 169, 211);
		datosCliente.setBorder(BorderFactory.createLineBorder(colorBorde2, 4));
		datosCliente.setBounds(300,300,300,300);
		panelDatosAlojamiento = new DatosHabitacion();
		Color colorBorde3 = new Color(139, 159, 151);
		panelDatosAlojamiento.setBorder(BorderFactory.createLineBorder(colorBorde3, 4));

		panelFicha = new PanelReserva();
		Color colorBorde4 = new Color(63, 176, 178);
		panelFicha.setBorder(BorderFactory.createDashedBorder(colorBorde4));

		// Botones con íconos
		ImageIcon imagenImprimir = new ImageIcon(getClass().getResource("/recursos/impresora.png"));
		btnImprimir = new JButton(imagenImprimir);
		btnImprimir.setToolTipText("Imprimir Datos");
		btnImprimir.addActionListener(this);
		btnImprimir.setOpaque(true);
		btnImprimir.setBackground(colorBorde1);

		ImageIcon imagenLimpiar = new ImageIcon(getClass().getResource("/recursos/limpiar.png"));
		btnLimpiar = new JButton(imagenLimpiar);
		btnLimpiar.setToolTipText("Limpiar Datos");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBackground(colorBorde2);

		ImageIcon imagenGuardar = new ImageIcon(getClass().getResource("/recursos/guardar.png"));
		btnGuardar = new JButton(imagenGuardar);
		btnGuardar.setToolTipText("Guardar Datos");
		btnGuardar.addActionListener(this);
		btnGuardar.setOpaque(true);
		btnGuardar.setBackground(colorBorde3);

		// Añadimos paneles verticales
		cajaDatos.add(panelTitulo);
		cajaDatos.add(datosCliente);
		cajaDatos.add(panelDatosAlojamiento);
		cajaDatos.add(panelFicha);

		// Añadimos botones
		cajaHorizontal.add(btnImprimir);
		cajaHorizontal.add(Box.createHorizontalStrut(5));
		cajaHorizontal.add(btnLimpiar);
		cajaHorizontal.add(Box.createHorizontalStrut(5));
		cajaHorizontal.add(btnGuardar);

		cajaDatos.add(cajaHorizontal);

		// Añadir un JScrollPane
		scrollPane = new JScrollPane(cajaDatos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImprimir) {
			String devuelve = "";
			devuelve += "Nombre: " + DatosPersonales.campoNombre.getText() + "\n";
			devuelve += "Apellidos: " + DatosPersonales.campoApellidos.getText() + "\n";
			devuelve += "DNI: " + DatosPersonales.campoDni.getText() + "\n";
			devuelve += "Telefono: " + DatosPersonales.campoDni.getText() + "\n";

			PanelReserva.datosCliente.setText(devuelve);

			devuelve = "";
			devuelve += "Provincia: " + (DatosHabitacion.comboProvincia.getSelectedItem()) + "\n";
			devuelve += "Tipo de camas: " + (DatosHabitacion.comboTipoHabitacion.getSelectedItem()) + "\n";
			devuelve += "¿Tiene niños?: ";

			if (DatosHabitacion.checkBoxTieneNinios.isSelected()) {
				devuelve += "Si \n";
				devuelve += "Edad de los niños: " + PanelNinios.edadNinios.getValue() + "\n";
				devuelve += "Extra: " + PanelNinios.extras.getText() + "\n";
			} else {
				devuelve += "No \n";
			}

			devuelve += "Precio Mínimo: " + DatosHabitacion.campoPrecioCalculado.getText() + "\n";

			PanelReserva.datosAlojamiento.setText(devuelve);
		}

		if (e.getSource() == btnLimpiar) {
			// Limpiar todos los campos
			DatosPersonales.campoNombre.setText("");
			DatosPersonales.campoApellidos.setText("");
			DatosPersonales.campoDni.setText("");
			DatosPersonales.campoTelefono.setText("");
			
			
			DatosHabitacion.comboProvincia.setSelectedIndex(0);
			DatosHabitacion.comboTipoHabitacion.setSelectedIndex(0);
			DatosHabitacion.spinnerNumHabitaciones.setValue(0);
		

			DatosHabitacion.checkBoxTieneNinios.setSelected(false);

			PanelNinios.edadNinios.setValue(0);
			PanelNinios.extras.setText("");
		}

		if (e.getSource() == btnGuardar) {
			JOptionPane.showMessageDialog(this, "¡Datos guardados correctamente!", "Confirmación",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
