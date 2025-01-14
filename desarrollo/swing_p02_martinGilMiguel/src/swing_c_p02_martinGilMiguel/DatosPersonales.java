/**
 * DatosPersonales.java
 * 16 nov 2024 18:06:30
 * @author Miguel Martin Gil
 */
package swing_c_p02_martinGilMiguel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

/**
 * 
 */

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DatosPersonales extends JPanel {

	static int diferenciaDias;
	static long diasEstancia = 1;
	private MaskFormatter telefonoMascara, dniMascara;
	static JFormattedTextField campoDni, campoTelefono;
	static JTextField campoNombre, campoApellidos, campoDiasReservados;
	private JLabel etiquetaTitulo, etiquetaNombre, etiquetaApellidos, etiquetaDni, etiquetaTelefono,
			etiquetaDiasReservados;

	public DatosPersonales() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbconstraints = new GridBagConstraints();
		gbconstraints.fill = GridBagConstraints.HORIZONTAL;
		gbconstraints.insets = new java.awt.Insets(0, 10, 10, 10);

		// Inicialización de máscaras para los campos de Dni y teléfono
		try {
			telefonoMascara = new MaskFormatter("#########");
			campoTelefono = new JFormattedTextField(telefonoMascara);
			campoTelefono.setFocusLostBehavior(JFormattedTextField.COMMIT);

			dniMascara = new MaskFormatter("########U");
			campoDni = new JFormattedTextField(dniMascara);
			campoDni.setFocusLostBehavior(JFormattedTextField.COMMIT);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Configuración del título
		etiquetaTitulo = new JLabel("Datos del Cliente");
		etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		gbconstraints.gridx = 0; // Primera columna
		gbconstraints.gridy = 0; // Primera fila
		gbconstraints.weighty = 0;
		// Ocupa dos columnas
		gbconstraints.gridwidth = 2;
		this.add(etiquetaTitulo, gbconstraints);

		// Configuración de las etiquetas y campos
		etiquetaNombre = new JLabel("Nombre:");
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 20));
		gbconstraints.gridx = 0;
		gbconstraints.gridy = 1;
		gbconstraints.gridwidth = 1;
		this.add(etiquetaNombre, gbconstraints);

		campoNombre = new JTextField(10);
		gbconstraints.gridx = 1;
		this.add(campoNombre, gbconstraints);

		etiquetaApellidos = new JLabel("Apellidos:");
		etiquetaApellidos.setFont(new Font("Arial", Font.BOLD, 20));
		gbconstraints.gridx = 0;
		gbconstraints.gridy = 2;
		this.add(etiquetaApellidos, gbconstraints);

		campoApellidos = new JTextField(10);
		gbconstraints.gridx = 1;
		this.add(campoApellidos, gbconstraints);

		etiquetaDni = new JLabel("DNI:");
		etiquetaDni.setFont(new Font("Arial", Font.BOLD, 20));
		gbconstraints.gridx = 0;
		gbconstraints.gridy = 3;
		this.add(etiquetaDni, gbconstraints);

		campoDni = new JFormattedTextField(dniMascara);
		gbconstraints.gridx = 1;
		this.add(campoDni, gbconstraints);

		etiquetaTelefono = new JLabel("Teléfono:");
		etiquetaTelefono.setFont(new Font("Arial", Font.BOLD, 20));
		gbconstraints.gridx = 0;
		gbconstraints.gridy = 4;
		this.add(etiquetaTelefono, gbconstraints);

		campoTelefono = new JFormattedTextField(telefonoMascara);
		gbconstraints.gridx = 1;
		this.add(campoTelefono, gbconstraints);

		JLabel etiquetaFechaEntrada = new JLabel("Fecha de llegada:");
		JSpinner spinnerFechaEntrada = new JSpinner(new SpinnerDateModel());
		spinnerFechaEntrada.setValue(new Date());
		gbconstraints.gridx = 0;
		gbconstraints.gridy = 5;
		this.add(etiquetaFechaEntrada, gbconstraints);
		gbconstraints.gridx = 1;
		this.add(spinnerFechaEntrada, gbconstraints);

		JLabel fechaDispText = new JLabel("Fecha de salida:");
		JSpinner fechaSalida = new JSpinner(new SpinnerDateModel());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		fechaSalida.setValue(calendar.getTime());
		gbconstraints.gridx = 0;
		gbconstraints.gridy = 6;
		this.add(fechaDispText, gbconstraints);
		gbconstraints.gridx = 1;
		this.add(fechaSalida, gbconstraints);

		// Etiqueta y campo para días reservados
		etiquetaDiasReservados = new JLabel("Días reservados:");
		etiquetaDiasReservados.setFont(new Font("Arial", Font.BOLD, 20));
		gbconstraints.gridx = 0; // Columna 0
		gbconstraints.gridy = 7; // Fila 7
		this.add(etiquetaDiasReservados, gbconstraints);

		campoDiasReservados = new JTextField(10);
		campoDiasReservados.setEditable(false); // Campo no editable
		gbconstraints.gridx = 1; // Columna 1
		agregarListenerActualizarDias(spinnerFechaEntrada, fechaSalida, campoDiasReservados);

		this.add(campoDiasReservados, gbconstraints);

		this.setBackground(new Color(102, 255, 255));
		this.setPreferredSize(new Dimension(300, 450)); // Tamaño del panel
	}

	private int calcularDiasReserva(JSpinner spinnerFechaEntrada, JSpinner spinnerFechaSalida) {
		// Obtener las fechas seleccionadas
		Date fechaEntrada = (Date) spinnerFechaEntrada.getValue();
		Date fechaSalida = (Date) spinnerFechaSalida.getValue();

		// Calcular la diferencia en milisegundos
		long diferenciaMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
		diasEstancia = (int) (diferenciaMilisegundos / (1000 * 60 * 60 * 24));
		// Convertir de milisegundos a días (1 día = 86400000 ms)
		return (int) diasEstancia;
	}

	private void agregarListenerActualizarDias(JSpinner spinnerEntrada, JSpinner spinnerSalida, JTextField campo) {
		ChangeListener listener = e -> {
			int diasReservados = calcularDiasReserva(spinnerEntrada, spinnerSalida);
			campo.setText(String.valueOf(diasReservados));
		};

		spinnerEntrada.addChangeListener(listener);
		spinnerSalida.addChangeListener(listener);
	}

}
